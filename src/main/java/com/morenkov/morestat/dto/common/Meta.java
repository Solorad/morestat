package com.morenkov.morestat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The meta key is used to communicate extra information about the response to
 * the developer. If all goes well, you'll only ever see a code key with value
 * 200.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
public class Meta {
	@JsonProperty("code")
	private int code;

	@JsonProperty("error_message")
	private String errorMessage;

	@JsonProperty("error_type")
	private String errorType;

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    @Override
    public String toString() {
        return String.format("Meta [code=%s, errorMessage=%s, errorType=%s]", code, errorMessage, errorType);
    }
}
