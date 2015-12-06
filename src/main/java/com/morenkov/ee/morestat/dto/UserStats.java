package com.morenkov.ee.morestat.dto;

/**
 * @author emorenkov
 */
public class UserStats {
    private Long totalLikes;
    private Long totalComments;

    public UserStats() {
    }


    public UserStats(Long totalLikes, Long totalComments) {
        this.totalLikes = totalLikes;
        this.totalComments = totalComments;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Long totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Long getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(Long totalComments) {
        this.totalComments = totalComments;
    }
}
