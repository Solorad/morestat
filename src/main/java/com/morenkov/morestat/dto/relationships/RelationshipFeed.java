package com.morenkov.morestat.dto.relationships;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Meta;

public class RelationshipFeed {
	@JsonProperty("data")
	private RelationshipData data;

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
	 * @return the data
	 */
	public RelationshipData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(RelationshipData data) {
		this.data = data;
	}

    @Override
    public String toString() {
        return String.format("RelationshipFeed [data=%s, meta=%s]", data, meta);
    }
}
