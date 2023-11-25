package org.sopt.sopkathon.iosthree.controller.dto.response;

public record TodayQuestion(Long questionId, String question) {
	public static TodayQuestion of (Long questionId, String question){
		return new TodayQuestion(questionId, question);
	}
}
