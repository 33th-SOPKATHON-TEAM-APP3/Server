package org.sopt.sopkathon.iosthree.controller.dto.response;

public record TodayQuestion(String question) {
	public static TodayQuestion of (String question){
		return new TodayQuestion(question);
	}
}
