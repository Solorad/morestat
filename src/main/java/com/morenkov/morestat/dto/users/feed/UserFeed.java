package com.morenkov.morestat.dto.users.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;
import com.morenkov.morestat.dto.common.Pagination;

import java.util.List;

public class UserFeed {
	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("pagination")
	private Pagination pagination;

	@JsonProperty("data")
	private List<UserFeedData> userList;

	/**
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	/**
	 * @return the userList
	 */
	public List<UserFeedData> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserFeedData> userList) {
		this.userList = userList;
	}

    @Override
    public String toString() {
        return String.format("UserFeed [meta=%s, pagination=%s, userList=%s]", meta, pagination, userList);
    }
}
