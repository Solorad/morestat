package com.morenkov.morestat.dto.relationships;

import com.morenkov.morestat.dto.common.User;

import java.util.Set;

/**
 * DTO object for followers list and for followed_by list.
 *
 * @author emorenkov
 */
public class RelationshipStatus {

    private Set<User> data;

    public Set<User> getData() {
        return data;
    }

    public void setData(Set<User> data) {
        this.data = data;
    }
}
