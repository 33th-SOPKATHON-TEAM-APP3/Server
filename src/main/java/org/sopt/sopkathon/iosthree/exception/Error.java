package org.sopt.sopkathon.iosthree.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

	/**
	 * 404 NOT FOUND
	 */
	EXAMPLE_NOT_FOUND(HttpStatus.NOT_FOUND, "예시 에러 코드"),

	// NOT_FOUND(HttpStatus.NOT_FOUND, "항공사를 찾지 못했어요."),
	/**
	 * 500 INTERNAL_SERVER_ERROR
	 */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다")
	;

	private final HttpStatus httpStatus;
	private final String message;

	public int getErrorCode() {
		return httpStatus.value();
	}
}

