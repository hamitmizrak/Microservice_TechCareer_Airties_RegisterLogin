package com.hamitmizrak.error;

import lombok.Data;

@Data
public class ApiError {

    private String status;
    private String message;
    private String path;

    public ApiError() {
    }

    public ApiError(String status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
