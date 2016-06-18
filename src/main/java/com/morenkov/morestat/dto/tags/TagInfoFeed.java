package com.morenkov.morestat.dto.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;

public class TagInfoFeed {
	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("data")
	private TagInfoData tagInfo;

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

	public TagInfoData getTagInfo() {
		return tagInfo;
	}

	public void setTagInfo(TagInfoData tagInfo) {
		this.tagInfo = tagInfo;
	}

    @Override
    public String toString() {
        return String.format("TagInfoFeed [meta=%s, tagInfo=%s]", meta, tagInfo);
    }
}
