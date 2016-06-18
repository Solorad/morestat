package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Likes {
	@JsonProperty("count")
	private int count;

	@JsonProperty("data")
	private List<User> likesUserList;

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public List<User> getLikesUserList() {
		return likesUserList;
	}

	public void setLikesUserList(List<User> likesUserList) {
		this.likesUserList = likesUserList;
	}

    @Override
    public String toString() {
        return String.format("Likes [count=%s, likesUserList=%s]", count, likesUserList);
    }
}
