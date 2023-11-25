package org.sopt.sopkathon.iosthree.controller.dto.response;

public record TodayQuestion(Long questionId, String questionName) {
	public static TodayQuestion of (Long questionId, String questionName){
		return new TodayQuestion(questionId, questionName);
	}
}
