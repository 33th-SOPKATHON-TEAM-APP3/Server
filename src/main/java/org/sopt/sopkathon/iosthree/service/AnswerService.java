package org.sopt.sopkathon.iosthree.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.controller.dto.request.TodayAnswerRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.MyAnswerResponse;
import org.sopt.sopkathon.iosthree.controller.dto.response.QuestionDto;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayAnswerResponse;
import org.sopt.sopkathon.iosthree.domain.Answer;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.domain.User;
import org.sopt.sopkathon.iosthree.infrastructure.AnswerJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.QuestionJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
                        .answerName(answerRequest.answer())
                        .build()
                );

        return new TodayAnswerResponse(true);
    }

    public MyAnswerResponse getMyAnswer(Long questionId, Long userId){
        Question question = questionJpaRepository.findByIdOrThrow(questionId);
        User user = userJpaRepository.findByIdOrThrow(userId);

        QuestionDto questionDto = new QuestionDto(
                question.getQuestionId(),
                question.getQuestionName()
        );

        Optional<Answer> answerOptional = answerJpaRepository.findByUserAndQuestion(user, question);
        String myAnswer = answerOptional.map(Answer::getAnswerName).orElse(null);

        return new MyAnswerResponse(questionDto, myAnswer);

    }

}
