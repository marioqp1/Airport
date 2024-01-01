package com.sw.airport.airport.dto;

import lombok.Setter;

@Setter
public class ApiResponseBuilder <T>{

    private Integer statusCode;
    private Boolean success;
    private String message;
    private T entity;

    public ApiResponse<T> build(){
        return new ApiResponse<T>(this.statusCode,this.success,this.message,this.entity);
    }

}
