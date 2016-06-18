package com.morenkov.morestat.dto.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;

import java.util.List;

public class MediaCommentsFeed {
	@JsonProperty("data")
	private List<CommentData> commentDataList;

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
	 * @return the commentDataList
	 */
	public List<CommentData> getCommentDataList() {
		return commentDataList;
	}

	/**
	 * @param commentDataList the commentDataList to set
	 */
	public void setCommentDataList(List<CommentData> commentDataList) {
		this.commentDataList = commentDataList;
	}

    @Override
    public String toString() {
        return String.format("MediaCommentsFeed [commentDataList=%s, meta=%s]", commentDataList, meta);
    }
}
