package org.sopt.sopkathon.iosthree.domain;

public record SignUpResponse(Long userId, Boolean isAnswered) {
	public static SignUpResponse of(Long userId, Boolean isAnswered){
		return new SignUpResponse(userId, isAnswered);
	}
}
