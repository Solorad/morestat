package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class to denote users_in_photo json data.
 * 
 e.x. 
 
 "users_in_photo": [{
            "user": {
                "username": "kevin",
                "full_name": "Kevin S",
                "id": "3",
                "profile_picture": "..."
            },
            "position": {
                "x": 0.315,
                "y": 0.9111
            }
        }],
        
        
 * @author Sachin Handiekar
 * @since 1.1.10
 */
public class UsersInPhoto {

	@JsonProperty("user")
	private User user;

	@JsonProperty("position")
	private GridPosition position;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GridPosition getPosition() {
		return position;
	}

	public void setPosition(GridPosition position) {
		this.position = position;
	}

}
