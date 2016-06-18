package com.morenkov.morestat.dto.likes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;
import com.morenkov.morestat.dto.common.User;

import java.util.List;

public class LikesFeed  {

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("data")
	private List<User> userList;

	/**
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @param meta
	 *            the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return String.format("LikesFeed [meta=%s, userList=%s]", meta, userList);
	}
}
