package com.morenkov.morestat.service;

import com.morenkov.morestat.dto.users.feed.MediaFeed;
import com.morenkov.morestat.exceptions.InstagramException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * @author emorenkov
 */
@Service
public class UserInfoService {
    private static final Logger log = LogManager.getLogger(UserInfoService.class);

    private final OAuth2ClientContext oauth2ClientContext;
    private final RestTemplate restTemplate;
    private final Environment environment;

    @Autowired
    public UserInfoService(OAuth2ClientContext oauth2ClientContext, RestTemplate restTemplate,
                           Environment environment) {
        this.oauth2ClientContext = oauth2ClientContext;
        this.restTemplate = restTemplate;
        this.environment = environment;
    }


    public MediaFeed getRecentMediaFeed(String userId) throws InstagramException {
        try {
            log.debug("getRecentMediaFeed({}) started.", userId);
            String recentMediaUri = environment.getProperty("instagram.resource.recentMedia");
            OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
            ResponseEntity<MediaFeed> responseEntity =
                    restTemplate.getForEntity(recentMediaUri, MediaFeed.class, userId, accessToken.getValue());
            return responseEntity.getBody();
        } catch (RestClientException e) {
            log.error("Exception occurred", e);
            throw new InstagramException(e.getMessage(), e);
        }
    }
}
