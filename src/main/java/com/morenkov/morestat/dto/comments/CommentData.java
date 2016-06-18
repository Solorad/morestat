package com.morenkov.morestat.dto.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.FromTagData;

public class CommentData {
	@JsonProperty("from")
	private FromTagData commentFrom;

	@JsonProperty("created_time")
	private String createdTime;

	@JsonProperty("id")
	private String id;

	@JsonProperty("text")
	private String text;

	/**
	 * @return the createdTime
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the commentFrom
	 */
	public FromTagData getCommentFrom() {
		return commentFrom;
	}

	/**
	 * @param commentFrom the commentFrom to set
	 */
	public void setCommentFrom(FromTagData commentFrom) {
		this.commentFrom = commentFrom;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("CommentData [commentFrom=%s, createdTime=%s, id=%s, text=%s]", commentFrom, createdTime,
				id, text);
	}
}
