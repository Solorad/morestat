package com.morenkov.morestat.service;

import com.morenkov.morestat.dto.UserStateSnapshot;
import com.morenkov.morestat.dto.common.User;
import com.morenkov.morestat.dto.relationships.RelationshipStatus;
import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author emorenkov
 */
@Service
public class SnapshotService {
    private static final Logger log = LogManager.getLogger(SnapshotService.class);

    private final RestTemplate restTemplate;
    private final Environment environment;
    private final OAuth2ClientContext oauth2ClientContext;
    private final UserRepository userRepository;

    public SnapshotService(RestTemplate restTemplate, Environment environment, OAuth2ClientContext oauth2ClientContext,
                           UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.environment = environment;
        this.oauth2ClientContext = oauth2ClientContext;
        this.userRepository = userRepository;
    }

    @Async
    public ListenableFuture<ResponseEntity<?>> retrieveUserSnapshot(UserInfoData userInfoData) {
//        userRepository.find
        return buildUserNewSnapshot(userInfoData);
    }

    @Async
    public ListenableFuture<ResponseEntity<?>> buildUserNewSnapshot(UserInfoData userInfoData) {
        UserStateSnapshot userStateSnapshot = new UserStateSnapshot();
        if (userInfoData == null) {
            log.error("UserInfoData must not be null.");
            return new AsyncResult<>(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        userStateSnapshot.setCreated(LocalDateTime.now());
        userStateSnapshot.setId(userInfoData.getId());
        userStateSnapshot.setMedia(userInfoData.getCounts().getMedia());

        OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
        if (accessToken == null || StringUtils.isEmpty(accessToken.getValue())) {
            log.error("Access token must not be null.");
            return new AsyncResult<>(new ResponseEntity<>("Access token must not be null.", HttpStatus.FORBIDDEN));
        }
        String followRequest = environment.getProperty("instagram.resource.follows");
        String followedByRequest = environment.getProperty("instagram.resource.follows");
        userStateSnapshot.setFollowers(getRelations(followRequest, accessToken.getValue()));
        userStateSnapshot.setFollowedBy(getRelations(followedByRequest, accessToken.getValue()));

        return new AsyncResult<>(new ResponseEntity<>(userStateSnapshot, HttpStatus.OK));
    }

    private Set<User> getRelations(String query, String accessToken) {
        ResponseEntity<RelationshipStatus> response =
                restTemplate.getForEntity(query, RelationshipStatus.class, accessToken);
        return response.getBody().getData();
    }
}
