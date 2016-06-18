package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.comments.CommentData;

import java.util.List;

public class Comments {
	@JsonProperty("data")
	private List<CommentData> comments;

	@JsonProperty("count")
	private int count;

	public List<CommentData> getComments() {
		return comments;
	}

	public void setComments(List<CommentData> comments) {
		this.comments = comments;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    @Override
    public String toString() {
        return String.format("Comments [comments=%s, count=%s]", comments, count);
    }
}
