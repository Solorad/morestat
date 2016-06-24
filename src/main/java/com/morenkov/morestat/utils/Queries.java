package com.morenkov.morestat.utils;

/**
 * @author emorenkov
 */
public interface Queries {

    String SELF_INFO = "https://api.instagram.com/v1/users/self?access_token={access_token}";

    String FOLLOWS = "https://api.instagram.com/v1/data/self/FOLLOWS?access_token={access_token}";
    String FOLLOWED_BY = "https://api.instagram.com/v1/data/self/followed-by?access_token={access_token}";
    String RECENT_MEDIA = "https://api.instagram.com/v1/data/{user_id}/media/recent?access_token={access_token}";
    String RECENT_MEDIA_WITH_MIN_ID =
            "https://api.instagram.com/v1/data/{user_id}/media/recent?access_token={access_token}&max_id={max_id}";
    String WHO_LIKED_LIST = "https://api.instagram.com/v1/media/{media-id}/likes?access_token={access_token}";
    String WHO_COMMENTED_LIST = "https://api.instagram.com/v1/media/{media-id}/comments?access_token={access_token}";
}
