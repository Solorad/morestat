package com.morenkov.morestat.dto.users.basicinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Counts implements Serializable {
	@JsonProperty("FOLLOWS")
	private int follows;

	@JsonProperty("followed_by")
	private int followedBy;

	@JsonProperty("media")
	private int media;

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

	public int getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(int follwedBy) {
		this.followedBy = follwedBy;
	}

    @Override
    public String toString() {
        return String.format("Counts [FOLLOWS=%s, followed_by=%s, media=%s]", follows, followedBy, media);
    }
}
