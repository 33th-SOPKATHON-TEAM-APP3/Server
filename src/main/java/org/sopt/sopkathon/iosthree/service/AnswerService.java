package org.sopt.sopkathon.iosthree.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.iosthree.controller.dto.request.TodayAnswerRequest;
import org.sopt.sopkathon.iosthree.controller.dto.response.MyAnswerResponse;
import org.sopt.sopkathon.iosthree.controller.dto.response.QuestionDto;
import org.sopt.sopkathon.iosthree.controller.dto.response.RandomAnswerResponse;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayAnswerResponse;
import org.sopt.sopkathon.iosthree.domain.Answer;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.domain.User;
import org.sopt.sopkathon.iosthree.infrastructure.AnswerJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.QuestionJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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

        user.setIsAnswered(true);
        userJpaRepository.save(user);

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

    public RandomAnswerResponse getRandomAnswer(Long questionId, Long userId){
        List<Answer> answers = answerJpaRepository.findByQuestionAndUserNot(questionJpaRepository.findByIdOrThrow(questionId), userJpaRepository.findByIdOrThrow(userId));
        if (answers.isEmpty()) {
            return new RandomAnswerResponse(null);
        }
        Answer randomAnswer = answers.get(new Random().nextInt(answers.size()));
        return new RandomAnswerResponse(randomAnswer.getAnswerName());
    }

}
