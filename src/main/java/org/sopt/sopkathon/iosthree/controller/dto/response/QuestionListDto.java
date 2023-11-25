package org.sopt.sopkathon.iosthree.controller.dto.response;

import java.util.List;

import org.sopt.sopkathon.iosthree.domain.Question;

public record QuestionListDto(TodayQuestion todayQuestion, List<QuestionDto> questionList) {
	public static QuestionListDto of(TodayQuestion todayQuestion, List<QuestionDto> questionList){
		return new QuestionListDto(todayQuestion, questionList);
	}
}
