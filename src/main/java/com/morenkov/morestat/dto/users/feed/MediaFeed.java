package com.morenkov.morestat.dto.users.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;
import com.morenkov.morestat.dto.common.Pagination;

import java.util.List;

public class MediaFeed {
	@JsonProperty("data")
	private List<MediaFeedData> data;

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("pagination")
	private Pagination pagination;

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
	 * @return the data
	 */
	public List<MediaFeedData> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<MediaFeedData> data) {
		this.data = data;
	}

    @Override
    public String toString() {
        return String.format("MediaFeed [data=%s, meta=%s, pagination=%s]", data, meta, pagination);
    }
}
