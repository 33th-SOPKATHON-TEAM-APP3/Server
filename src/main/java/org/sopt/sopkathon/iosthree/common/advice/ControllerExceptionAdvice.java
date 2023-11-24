package org.sopt.sopkathon.iosthree.common.advice;

import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.exception.model.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.NoArgsConstructor;

@RestControllerAdvice
@Component
@NoArgsConstructor
public class ControllerExceptionAdvice {
	/**
	 * custom error
	 */
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ApiResponse> handleCustomException(CustomException e) {
		return ResponseEntity.status(e.getHttpStatus())
			.body(ApiResponse.error(e.getError(), e.getMessage()));
	}
}
