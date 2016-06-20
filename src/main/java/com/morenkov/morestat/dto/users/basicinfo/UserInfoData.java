package com.morenkov.morestat.dto.users.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class UserInfoData implements Serializable{
	@JsonProperty("id")
	private String id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("profile_picture")
	private String profilePicture;

	@JsonProperty("bio")
	private String bio;

	@JsonProperty("counts")
	private Counts counts;

	@JsonProperty("website")
	private String website;

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

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Counts getCounts() {
		return counts;
	}

	public void setCounts(Counts counts) {
		this.counts = counts;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "UserInfoData{" +
			   "id='" + id + '\'' +
			   ", username='" + username + '\'' +
			   ", fullName='" + fullName + '\'' +
			   ", profilePicture='" + profilePicture + '\'' +
			   ", bio='" + bio + '\'' +
			   ", counts=" + counts +
			   ", website='" + website + '\'' +
			   '}';
	}
}