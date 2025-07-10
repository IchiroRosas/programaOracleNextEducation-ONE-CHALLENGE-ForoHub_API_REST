package com.example.ProgramaONE_Challenge_ForoHub.domain.shared;

public record ApiResponse<T>(
        boolean ok,
        String message,
        T data
) {
    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<T>(true,message,data);
    }

    public static <T> ApiResponse<T> error(String message, T data){
        return new ApiResponse<T>(false,message,data);
    }
}
