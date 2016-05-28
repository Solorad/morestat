package com.morenkov.ee.config.security;

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

    public static class InstagramUser {
        private String id;
        private String username;
        private String full_name;
        private String profile_picture;

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
    }


    @Override
    public String toString() {
        return "InstagramResult{" +
               "access_token='" + access_token + '\'' +
               ", user=" + user +
               '}';
    }
}
