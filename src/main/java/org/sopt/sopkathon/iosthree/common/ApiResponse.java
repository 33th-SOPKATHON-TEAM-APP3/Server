package org.sopt.sopkathon.iosthree.common;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import org.sopt.sopkathon.iosthree.exception.Error;
import org.sopt.sopkathon.iosthree.exception.Success;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiResponse<T> {

	private final int code;
	private final String message;
	private T data;


	public static ApiResponse success(Success success){
		return new ApiResponse<>(success.getHttpStatusCode(), success.getMessage());
	}

	public static <T> ApiResponse<T> success(Success success, T data){
		return new ApiResponse<T>(success.getHttpStatusCode(), success.getMessage(), data);
	}

	public static ApiResponse error(Error error){
		return new ApiResponse<>(error.getErrorCode(), error.getMessage());
	}

	public static ApiResponse error(Error error, String message){
		return new ApiResponse<>(error.getErrorCode(), message);
	}
}
