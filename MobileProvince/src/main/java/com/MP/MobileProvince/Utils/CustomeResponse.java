package com.MP.MobileProvince.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
@NoArgsConstructor
    public class CustomeResponse<T> {
        private String message;
        private Integer statusCode = HttpStatus.OK.value();
        private T entity;


    }


