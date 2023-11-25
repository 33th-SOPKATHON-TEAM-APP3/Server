package org.sopt.sopkathon.iosthree.controller;

import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.controller.dto.request.SignUpRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.QuestionListDto;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayQuestion;
import org.sopt.sopkathon.iosthree.domain.SignUpResponse;
import org.sopt.sopkathon.iosthree.exception.Success;
import org.sopt.sopkathon.iosthree.service.QuestionService;
import org.sopt.sopkathon.iosthree.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping
	public ApiResponse<TodayQuestion> getQuestion(){
		return ApiResponse.success(Success.GET_QUESTION_SUCCESS, questionService.getTodayQuestion());
	}

	@GetMapping("/user")
	public ApiResponse<QuestionListDto> getMyQuestion(@RequestParam("userId") Long userId){
		log.info("여기");
		return ApiResponse.success(Success.GET_RANDOM_SUCCESS,questionService.getMyQuestion(userId));

	}
}
