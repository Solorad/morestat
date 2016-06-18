package com.morenkov.morestat.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserStats)) {
            return false;
        }

        UserStats userStats = (UserStats) o;

        if (totalLikes != null ? !totalLikes.equals(userStats.totalLikes) : userStats.totalLikes != null) {
            return false;
        }
        return !(totalComments != null ? !totalComments.equals(userStats.totalComments)
                                       : userStats.totalComments != null);

    }

    @Override
    public int hashCode() {
        int result = totalLikes != null ? totalLikes.hashCode() : 0;
        result = 31 * result + (totalComments != null ? totalComments.hashCode() : 0);
        return result;
    }
}
