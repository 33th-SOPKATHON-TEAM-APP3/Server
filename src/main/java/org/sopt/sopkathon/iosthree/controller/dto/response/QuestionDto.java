package org.sopt.sopkathon.iosthree.controller.dto.response;

public record QuestionDto(
        Long questionId,
        String questionName

) {
	public static QuestionDto of(Long questionId, String questionName){
		return new QuestionDto(questionId, questionName);
	}
}
