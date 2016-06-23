package com.morenkov.morestat.dto;

import com.morenkov.morestat.dto.common.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author emorenkov
 */
@Document
public class UserStateSnapshot {
    @Id
    private String id;
    @Indexed
    private LocalDateTime created;
    @Indexed
    private String userId;
    private int media;
    private Set<User> followers;
    private Set<User> followedBy;
    private Integer totalLikes;
    private Integer totalComments;
    private Map<String, Integer> userLikeMap;
    private Map<String, Integer> userCommentMap;

    public UserStateSnapshot() {
        this.followers = new HashSet<>();
        this.followedBy = new HashSet<>();
        this.userLikeMap = new HashMap<>();
        this.userCommentMap = new HashMap<>();
        totalComments = 0;
        totalLikes = 0;
    }

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

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(Set<User> followedBy) {
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
