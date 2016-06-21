package com.morenkov.morestat.entity;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * @author emorenkov
 */
public class UserStateSnapshotEntity {
    @Id
    private String id;
    private LocalDateTime created;
    private String userId;
    private int media;
    private Set<String> followers;
    private Set<String> followedBy;
    private int totalLikes;
    private int totalComments;
    private Map<String, Integer> userLikeMap;
    private Map<String, Integer> userCommentMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<String> followers) {
        this.followers = followers;
    }

    public Set<String> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(Set<String> followedBy) {
        this.followedBy = followedBy;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    public Map<String, Integer> getUserLikeMap() {
        return userLikeMap;
    }

    public void setUserLikeMap(Map<String, Integer> userLikeMap) {
        this.userLikeMap = userLikeMap;
    }

    public Map<String, Integer> getUserCommentMap() {
        return userCommentMap;
    }

    public void setUserCommentMap(Map<String, Integer> userCommentMap) {
        this.userCommentMap = userCommentMap;
    }
}
