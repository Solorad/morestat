package com.morenkov.morestat.dto.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morenkov.morestat.dto.common.Location;

public class LocationInfo {

	@JsonProperty("data")
	private Location locationData;

	public Location getLocationData() {
		return locationData;
	}

	public void setLocationData(Location locationData) {
		this.locationData = locationData;
	}

    @Override
    public String toString() {
        return String.format("LocationInfo [locationData=%s]", locationData);
    }
}
