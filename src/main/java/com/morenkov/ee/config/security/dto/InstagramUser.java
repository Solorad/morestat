package com.morenkov.ee.config.security.dto;

/**
 * @author emorenkov
 */
public class InstagramUser {
    private String id;
    private String username;
    private String full_name;
    private String profile_picture;
    private String bio;
    private String website;
    private Counts counts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String fullName) {
        this.full_name = fullName;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profilePicture) {
        this.profile_picture = profilePicture;
    }

    @Override
    public String toString() {
        return "InstagramUser{" +
               "id='" + id + '\'' +
               ", username='" + username + '\'' +
               ", fullName='" + full_name + '\'' +
               ", profilePicture='" + profile_picture + '\'' +
               '}';
    }


    public static class Counts {
        private int media;
        private int follows;
        private int followed_by;

        public int getMedia() {
            return media;
        }

        public void setMedia(int media) {
            this.media = media;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getFollowed_by() {
            return followed_by;
        }

        public void setFollowed_by(int followed_by) {
            this.followed_by = followed_by;
        }
    }
}
