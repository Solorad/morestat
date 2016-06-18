package com.morenkov.morestat.service;

import com.morenkov.morestat.dto.users.feed.MediaFeed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author emorenkov
 */
@Service
public class UserInfoService {
    private static final Logger log = LogManager.getLogger(UserInfoService.class);

    private final OAuth2ClientContext oauth2ClientContext;

    @Autowired
    public UserInfoService(OAuth2ClientContext oauth2ClientContext) {
        this.oauth2ClientContext = oauth2ClientContext;
    }


    public MediaFeed getRecentMediaFeed(String userId, HttpSession session) {
        log.debug("getRecentMediaFeed({}) started.", userId);
        OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
        return null;
    }
}
