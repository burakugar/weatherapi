package com.project.weatherapi.exception;

import com.project.weatherapi.common.CommonException;
import com.project.weatherapi.constant.ErrorCodes;

public class FeignClientException extends CommonException {

    public FeignClientException(Integer statusCode, String body) {
        super("An error is occurred during feign request with status code: " + statusCode + " and with body: " + body,
                ErrorCodes.FEIGN_CLIENT_ERROR);
    }
}
