package com.morenkov.morestat.service;

import com.morenkov.morestat.dto.UserStateSnapshot;
import com.morenkov.morestat.dto.common.User;
import com.morenkov.morestat.dto.relationships.UserSet;
import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.dto.users.feed.MediaFeed;
import com.morenkov.morestat.dto.users.feed.MediaFeedData;
import com.morenkov.morestat.repository.UserStateSnapshotRepository;
import com.morenkov.morestat.utils.Queries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.time.temporal.ChronoUnit.HOURS;

/**
 * @author emorenkov
 */
@Service
public class SnapshotService {
    private static final Logger log = LogManager.getLogger(SnapshotService.class);

    private final RestTemplate restTemplate;
    private final UserStateSnapshotRepository userStateSnapshotRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SnapshotService(RestTemplate restTemplate,
                           UserStateSnapshotRepository userStateSnapshotRepository, MongoTemplate mongoTemplate) {
        this.restTemplate = restTemplate;
        this.userStateSnapshotRepository = userStateSnapshotRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Async
    public ListenableFuture<ResponseEntity<?>> retrieveUserSnapshot(UserInfoData userInfoData, OAuth2AccessToken accessToken) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "created"));

        UserStateSnapshot userStateSnapshot = mongoTemplate.findOne(query, UserStateSnapshot.class);
        if (userStateSnapshot != null && HOURS.between(userStateSnapshot.getCreated(), LocalDateTime.now()) < 12) {
            return  new AsyncResult<>(new ResponseEntity<>(userStateSnapshot, HttpStatus.OK));
        }
        return buildUserNewSnapshot(userInfoData, accessToken);
    }

    @Async
    public ListenableFuture<ResponseEntity<?>> buildUserNewSnapshot(UserInfoData userInfoData, OAuth2AccessToken accessToken) {
        UserStateSnapshot userStateSnapshot = new UserStateSnapshot();
        if (userInfoData == null) {
            log.error("UserInfoData must not be null.");
            return new AsyncResult<>(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        userStateSnapshot.setCreated(LocalDateTime.now());
        userStateSnapshot.setId(userInfoData.getId());
        userStateSnapshot.setMedia(userInfoData.getCounts().getMedia());

        if (accessToken == null || StringUtils.isEmpty(accessToken.getValue())) {
            log.error("Access token must not be null.");
            return new AsyncResult<>(new ResponseEntity<>("Access token must not be null.", HttpStatus.FORBIDDEN));
        }
        String accessTokenValue = accessToken.getValue();
        userStateSnapshot.setFollowers(getRelations(Queries.FOLLOWS, accessTokenValue));
        userStateSnapshot.setFollowedBy(getRelations(Queries.FOLLOWED_BY, accessTokenValue));
        getMediaFeedAndProcessIt(userStateSnapshot, accessTokenValue);

        return new AsyncResult<>(new ResponseEntity<>(userStateSnapshot, HttpStatus.OK));
    }

    private void getMediaFeedAndProcessIt(UserStateSnapshot userStateSnapshot, String accessToken) {
        ResponseEntity<MediaFeed> response = restTemplate.getForEntity(Queries.RECENT_MEDIA, MediaFeed.class, accessToken);
        processMedia(userStateSnapshot, accessToken, response);
    }

    private void getMediaFeedAndProcessIt(UserStateSnapshot userStateSnapshot, String accessToken, Long minId) {
        ResponseEntity<MediaFeed> response = restTemplate.getForEntity(Queries.RECENT_MEDIA_WITH_MIN_ID, MediaFeed.class, accessToken, minId);
        processMedia(userStateSnapshot, accessToken, response);
    }

    private void processMedia(UserStateSnapshot userStateSnapshot, String accessToken,
                              ResponseEntity<MediaFeed> response) {
        List<MediaFeedData> data = response.getBody().getData();

        Long minId = processMediaFeedAndReturnFirstId(data, userStateSnapshot, accessToken);
        if (data.size() > 20 && minId != null) {
            getMediaFeedAndProcessIt(userStateSnapshot, accessToken, minId);
        }
    }

    private Long processMediaFeedAndReturnFirstId(List<MediaFeedData> data, UserStateSnapshot userStateSnapshot,
                                                  String accessToken) {
        Integer feedLikes = 0;
        Integer feedComments = 0;

        for (MediaFeedData media : data) {
            feedLikes += media.getLikes().getCount();
            feedComments += media.getComments().getCount();
            ResponseEntity<UserSet> responseEntity = restTemplate
                    .getForEntity(Queries.WHO_LIKED_LIST, UserSet.class, media.getId(), accessToken);
            Set<User> likers = responseEntity.getBody().getData();

        }
        userStateSnapshot.setTotalLikes(userStateSnapshot.getTotalLikes() + feedLikes);
        userStateSnapshot.setTotalComments(userStateSnapshot.getTotalComments() + feedComments);
        return null;
    }

    private Set<User> getRelations(String query, String accessToken) {
        ResponseEntity<UserSet> response = restTemplate.getForEntity(query, UserSet.class, accessToken);
        return response.getBody().getData();
    }
}
