package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoData {

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@JsonProperty("url")
	private String url;

	@JsonProperty("width")
	private int width;

	@JsonProperty("height")
	private int height;
	
    @Override
    public String toString() {
        return String.format("VideoData [videoWidth=%i, videoHeight=%i, videoUrl=%s]",
                width, height, url);
    }
}
