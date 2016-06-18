package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GridPosition {

	@JsonProperty("x")
	private double x;

	@JsonProperty("y")
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
