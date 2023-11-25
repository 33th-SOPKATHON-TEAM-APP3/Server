package org.sopt.sopkathon.iosthree.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Success {

	/**
	 * 201 CREATED
	 */
	SIGNUP_SUCCESS(HttpStatus.CREATED, "새 유저가 생성되었습니다."),
	CREATE_TODAY_ANSWER_SUCCESS(HttpStatus.CREATED, "오늘의 답변 저장 성공"),


	/**
	 * 200 OK
	 */
	GET_EXAMPLE_SUCESS(HttpStatus.OK, "예시성공 코드"),
	LOGIN_SUCCESS(HttpStatus.OK, "로그인이 성공했습니다."),


	/**
	 * 204 NO_CONTENT
	 */

	;

	private final HttpStatus httpStatus;
	private final String message;

	public int getHttpStatusCode(){
		return httpStatus.value();
	}

}
