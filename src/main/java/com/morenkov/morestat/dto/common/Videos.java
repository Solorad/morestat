package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Videos {

	@JsonProperty("low_resolution")
	private VideoData lowResolution;


	@JsonProperty("standard_resolution")
	private VideoData standardResolution;
	
	
	public VideoData getLowResolution() {
		return lowResolution;
	}

	public void setLowResolution(VideoData lowResolution) {
		this.lowResolution = lowResolution;
	}

	public VideoData getStandardResolution() {
		return standardResolution;
	}

	public void setStandardResolution(VideoData standardResolution) {
		this.standardResolution = standardResolution;
	}
	
    @Override
    public String toString() {
        return String.format("Videos [lowResolution=%s, standardResolution=%s]",
                lowResolution, standardResolution);
    }
}
