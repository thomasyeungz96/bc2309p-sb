package com.thomas.coins.infra;

import java.lang.reflect.Array;
import java.util.List;

import com.thomas.coins.dto.Coingecko.CoinsIdDTO;
import com.thomas.coins.model.Coin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@ToString
public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    public static <T> ApiResponseBuilder<T> builder() {
        return new ApiResponseBuilder<T>();
    }

    @Getter
    public static class ApiResponseBuilder<T> {

        private String code;
        private String message;
        private T data;

        // ApiResponseBuilder() {

        // }

        public ApiResponseBuilder<T> status(Syscode syscode) {
            this.code = syscode.getCode();
            this.message = syscode.getMessage();
            return this;
        }
        public ApiResponseBuilder<T> status(Syscode syscode, String url) {
            this.code = syscode.getCode();
            this.message = syscode.getMessage().concat(": ").concat(syscode.setUrl(url).getUrl());
            return this;
        }

        public ApiResponseBuilder<T> setData(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<T>(this.getCode(), this.getMessage(), this.getData());
        }

    }

}
