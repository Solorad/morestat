package com.morenkov.morestat.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Location;

import java.util.List;

public class LocationSearchFeed {

	@JsonProperty("data")
	private List<Location> locationList;

	/**
	 * @return the locationList
	 */
	public List<Location> getLocationList() {
		return locationList;
	}

	/**
	 * @param locationList
	 *            the locationList to set
	 */
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

    @Override
    public String toString() {
        return String.format("LocationSearchFeed [locationList=%s]", locationList);
    }
}
