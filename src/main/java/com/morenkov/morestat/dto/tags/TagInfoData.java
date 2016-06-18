package com.morenkov.morestat.dto.tags;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagInfoData {
	@JsonProperty("media_count")
	private long mediaCount;

	@JsonProperty("name")
	private String tagName;

	/**
	 * @return the mediaCount
	 */
	public long getMediaCount() {
		return mediaCount;
	}

	/**
	 * @param mediaCount the mediaCount to set
	 */
	public void setMediaCount(long mediaCount) {
		this.mediaCount = mediaCount;
	}

	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

    @Override
    public String toString() {
        return String.format("TagInfoData [mediaCount=%s, tagName=%s]", mediaCount, tagName);
    }
}
