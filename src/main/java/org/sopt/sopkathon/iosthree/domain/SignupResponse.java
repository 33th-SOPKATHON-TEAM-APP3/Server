package org.sopt.sopkathon.iosthree.domain;

public record SignupResponse(Long userId, Boolean isAnswered) {
	public static SignupResponse of(Long userId, Boolean isAnswered){
		return new SignupResponse(userId, isAnswered);
	}
}
