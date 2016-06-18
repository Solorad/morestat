package com.morenkov.ee.config.security.dto;

/**
 * @author emorenkov
 */
public class InstagramResult {
    private String access_token;
    private InstagramUser user;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String accessToken) {
        this.access_token = accessToken;
    }

    public InstagramUser getUser() {
        return user;
    }

    public void setUser(InstagramUser user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "InstagramResult{" +
               "access_token='" + access_token + '\'' +
               ", user=" + user +
               '}';
    }
}
