package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("bio")
	private String bio;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("id")
	private String id;

	@JsonProperty("profile_picture")
	private String profilePictureUrl;

	@JsonProperty("username")
	private String userName;

	@JsonProperty("website")
	private String websiteUrl;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the profilePictureUrl
	 */
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	/**
	 * @param profilePictureUrl the profilePictureUrl to set
	 */
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the websiteUrl
	 */
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	/**
	 * @param websiteUrl the websiteUrl to set
	 */
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return String.format("User [bio=%s, fullName=%s, id=%s, profilePictureUrl=%s, userName=%s, websiteUrl=%s]",
                bio, fullName, id, profilePictureUrl, userName, websiteUrl);
    }
}
