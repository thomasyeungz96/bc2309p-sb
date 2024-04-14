package com.thomas.coins.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.thomas.coins.infra.ApiResponse;
import com.thomas.coins.infra.Syscode;
import com.thomas.coins.service.CoinService;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    CoinService coinService;

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> restClientExceptionHandler() {
        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .status(Syscode.NO_RESPONDED, coinService.getUrl() )
                .build();

        return apiResponse;
    }

}
