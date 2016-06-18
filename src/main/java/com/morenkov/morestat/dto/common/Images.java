package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Images {
	@JsonProperty("low_resolution")
	private ImageData lowResolution;

	@JsonProperty("standard_resolution")
	private ImageData standardResolution;

	@JsonProperty("thumbnail")
	private ImageData thumbnail;

	public ImageData getLowResolution() {
		return lowResolution;
	}

	public void setLowResolution(ImageData lowResolution) {
		this.lowResolution = lowResolution;
	}

	public ImageData getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(ImageData thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ImageData getStandardResolution() {
		return standardResolution;
	}

	public void setStandardResolution(ImageData standardResolution) {
		this.standardResolution = standardResolution;
	}

    @Override
    public String toString() {
        return String.format("Images [lowResolution=%s, standardResolution=%s, thumbnail=%s]",
                lowResolution, standardResolution, thumbnail);
    }
}
