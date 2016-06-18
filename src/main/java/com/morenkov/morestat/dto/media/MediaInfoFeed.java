package com.morenkov.morestat.dto.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;
import com.morenkov.morestat.dto.users.feed.MediaFeedData;

public class MediaInfoFeed {
	@JsonProperty("data")
	private MediaFeedData data;

	@JsonProperty("meta")
	private Meta meta;

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
	public MediaFeedData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(MediaFeedData data) {
		this.data = data;
	}

    @Override
    public String toString() {
        return String.format("MediaInfoFeed [data=%s, meta=%s]", data, meta);
    }
}
