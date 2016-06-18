package com.morenkov.morestat.dto;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;

/**
 * @author emorenkov
 */
public class InstagramResult {
    private String access_token;
    private UserInfoData user;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String accessToken) {
        this.access_token = accessToken;
    }

    public UserInfoData getUser() {
        return user;
    }

    public void setUser(UserInfoData user) {
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
