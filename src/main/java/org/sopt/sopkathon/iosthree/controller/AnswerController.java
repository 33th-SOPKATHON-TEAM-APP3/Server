package org.sopt.sopkathon.iosthree.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.service.AnswerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;


}
