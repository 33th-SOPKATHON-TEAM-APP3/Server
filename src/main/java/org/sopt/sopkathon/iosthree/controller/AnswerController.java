package org.sopt.sopkathon.iosthree.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.controller.dto.request.TodayAnswerRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.MyAnswerResponse;
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
        return ApiResponse.success(Success.CREATE_TODAY_ANSWER_SUCCESS, answerService.postAnswer(questionId, answerRequest));
    }

    @GetMapping()
    public ApiResponse<MyAnswerResponse> getMyAnswer(@RequestParam("questionId") Long questionId, @RequestParam("userId") Long userId){
        return ApiResponse.success(Success.GET_MY_ANSWER_SUCCESS, answerService.getMyAnswer(questionId, userId));
    }
}
