package com.morenkov.morestat.dto.common;

import com.morenkov.morestat.exceptions.InstagramBadRequestException;
import com.morenkov.morestat.exceptions.InstagramException;
import com.morenkov.morestat.exceptions.InstagramRateLimitException;

import java.util.Map;

/**
 * A class to represents an error response from Instagram API
 * @author Sachin Handiekar
 *
 */
public class InstagramErrorResponse {

    private Meta errorMeta;

    private Map<String, String> headers;

    InstagramErrorResponse(Meta errorMeta) {
        this.errorMeta = errorMeta;
    }

    /**
     * Setter for headers field
     * @param responseHeaders the response headers
     */
    public void setHeaders(Map<String, String> responseHeaders) {
        this.headers = responseHeaders;
    }

    /**
     * Throw instagram exception to the client
     * @throws InstagramException
     */
    public void throwException() throws InstagramException {
        if (errorMeta != null) {
            String msg = errorMeta.getErrorType() + ": " + errorMeta.getErrorMessage();
            switch (errorMeta.getCode()) {
                case 400:
                    throw new InstagramBadRequestException(errorMeta.getErrorType(), msg, this.headers);
                case 429:
                    throw new InstagramRateLimitException(errorMeta.getErrorType(), msg, this.headers);
                default:
                    throw new InstagramException(errorMeta.getErrorType(), msg, this.headers);
            }
        } else {
            throw new InstagramException("No metadata found in response", this.headers);
        }
    }
}
