package org.sopt.sopkathon.iosthree.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.controller.dto.request.TodayAnswerRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayAnswerResponse;
import org.sopt.sopkathon.iosthree.domain.Answer;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.domain.User;
import org.sopt.sopkathon.iosthree.infrastructure.AnswerJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.QuestionJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {

    private final AnswerJpaRepository answerJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Transactional
    public TodayAnswerResponse postAnswer(Long questionId, TodayAnswerRequest answerRequest){
        Question question = questionJpaRepository.findByIdOrThrow(questionId);
        User user = userJpaRepository.findByIdOrThrow(answerRequest.userId());

        Answer answer = answerJpaRepository.save(
                Answer.builder()
                    .question(question)
                    .user(user)
                    .build()
                );

        return new TodayAnswerResponse(true);
    }

}
