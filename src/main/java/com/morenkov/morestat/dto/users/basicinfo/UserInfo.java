package com.morenkov.morestat.dto.users.basicinfo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private UserInfoData data;

    public UserInfoData getData() {
        return data;
    }

    public void setData(UserInfoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("UserInfo [data=%s]", data);
    }
}
