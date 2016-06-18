package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class to denote the ImageData.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
public class ImageData {
	@JsonProperty("height")
	private int imageHeight;

	@JsonProperty("url")
	private String imageUrl;

	@JsonProperty("width")
	private int imageWidth;

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the imageWidth
	 */
	public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

    @Override
    public String toString() {
        return String.format("ImageData [imageHeight=%s, imageUrl=%s, imageWidth=%s]",
                imageHeight, imageUrl, imageWidth);
    }
}
