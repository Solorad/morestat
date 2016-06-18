package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FromTagData {
	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("id")
	private String id;

	@JsonProperty("profile_picture")
	private String profilePicture;

	@JsonProperty("username")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    @Override
    public String toString() {
        return String.format("FromTagData [fullName=%s, id=%s, profilePicture=%s, username=%s]",
                fullName, id, profilePicture, username);
    }
}
