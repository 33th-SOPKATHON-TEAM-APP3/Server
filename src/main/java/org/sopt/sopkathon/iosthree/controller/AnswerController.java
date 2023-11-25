package org.sopt.sopkathon.iosthree.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.controller.dto.request.TodayAnswerRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayAnswerResponse;
import org.sopt.sopkathon.iosthree.exception.Success;
import org.sopt.sopkathon.iosthree.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping(path = "/{questionId}", produces = "application/json")
    public ApiResponse<TodayAnswerResponse> postTodayAnswer(@PathVariable Long questionId, @RequestBody TodayAnswerRequest answerRequest){
        TodayAnswerResponse response = answerService.postAnswer(questionId, answerRequest);
        return ApiResponse.success(Success.CREATE_TODAY_ANSWER_SUCCESS, response);
    }
}
