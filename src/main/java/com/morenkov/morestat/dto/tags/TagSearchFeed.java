package com.morenkov.morestat.dto.tags;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;

import java.util.List;

public class TagSearchFeed {
	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("data")
	private List<TagInfoData> tagList;

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

	public List<TagInfoData> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagInfoData> tagList) {
		this.tagList = tagList;
	}

    @Override
    public String toString() {
        return String.format("TagSearchFeed [meta=%s, tagList=%s]", meta, tagList);
    }
}
