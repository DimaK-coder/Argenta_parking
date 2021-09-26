package com.example.demo.controllers;

import com.example.demo.dto.response.ApiResponse;

public abstract class BaseController {
    protected <T> ApiResponse<T> ReturnResponse(T data){
        return new ApiResponse<>(data);
    }
}
