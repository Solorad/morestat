package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

public class Pagination {
	@JsonProperty("deprecation_warning")
	private String depreciationWarning;

	@JsonProperty("min_tag_id")
	private String minTagId;

	@JsonProperty("next_max_id")
	private String nextMaxId;

	@JsonProperty("next_max_tag_id")
	private String nextMaxTagId;

	@JsonProperty("next_min_id")
	private String nextMinId;

	@JsonProperty("next_url")
	private String nextUrl;
	
	@JsonProperty("next_cursor")
	private String nextCursor;

	/**
	 * @return the nextUrl
	 */
	public String getNextUrl() {
		return nextUrl;
	}

	/**
	 * @param nextUrl the nextUrl to set
	 */
	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	/**
	 * @return the nextMaxId
	 */
	public String getNextMaxId() {
		return nextMaxId;
	}

	/**
	 * @param nextMaxId the nextMaxId to set
	 */
	public void setNextMaxId(String nextMaxId) {
		this.nextMaxId = nextMaxId;
	}

	/**
	 * @return the nextMinId
	 */
	public String getNextMinId() {
		return nextMinId;
	}

	/**
	 * @param nextMinId the nextMinId to set
	 */
	public void setNextMinId(String nextMinId) {
		this.nextMinId = nextMinId;
	}

	/**
	 * @return the minTagId
	 */
	public String getMinTagId() {
		return minTagId;
	}

	/**
	 * @param minTagId the minTagId to set
	 */
	public void setMinTagId(String minTagId) {
		this.minTagId = minTagId;
	}

	/**
	 * @return the nextMaxTagId
	 */
	public String getNextMaxTagId() {
		return nextMaxTagId;
	}

	/**
	 * @param nextMaxTagId the nextMaxTagId to set
	 */
	public void setNextMaxTagId(String nextMaxTagId) {
		this.nextMaxTagId = nextMaxTagId;
	}
    
    /**
     * @param The next cursor
     */
    public String getNextCursor() {
        return nextCursor;
    }

    /**
     * @param nextCursor The next cursor to set
     */
    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }

	/**
	 * @return the depreciationWarning
	 */
	public String getDepreciationWarning() {
		return depreciationWarning;
	}

	/**
	 * @param depreciationWarning the depreciationWarning to set
	 */
	public void setDepreciationWarning(String depreciationWarning) {
		this.depreciationWarning = depreciationWarning;
	}

    public boolean hasNextPage() {
        return !StringUtils.isBlank(nextUrl);
    }

    @Override
    public String toString() {
        return String.format("Pagination [depreciationWarning=%s, minTagId=%s, nextMaxId=%s, nextMaxTagId=%s, nextMinId=%s, nextUrl=%s]",
                        depreciationWarning, minTagId, nextMaxId, nextMaxTagId, nextMinId, nextUrl);
    }
}
