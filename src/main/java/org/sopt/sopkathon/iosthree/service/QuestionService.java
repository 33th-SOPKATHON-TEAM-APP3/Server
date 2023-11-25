package org.sopt.sopkathon.iosthree.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sopt.sopkathon.iosthree.controller.dto.response.QuestionDto;
import org.sopt.sopkathon.iosthree.controller.dto.response.QuestionListDto;
import org.sopt.sopkathon.iosthree.controller.dto.response.TodayQuestion;
import org.sopt.sopkathon.iosthree.domain.Answer;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.domain.User;
import org.sopt.sopkathon.iosthree.exception.Error;
import org.sopt.sopkathon.iosthree.exception.model.NotFoundException;
import org.sopt.sopkathon.iosthree.infrastructure.AnswerJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.QuestionJpaRepository;
import org.sopt.sopkathon.iosthree.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
	private final QuestionJpaRepository questionJpaRepository;
	private final UserJpaRepository userJpaRepository;
	private final AnswerJpaRepository answerJpaRepository;
	private final LocalDate today = LocalDate.now();

	public TodayQuestion getTodayQuestion(){
		Question question = questionJpaRepository.findByLocalDateTime(today);
		return TodayQuestion.of(question.getQuestionId(), question.getQuestionName());
	}

	public QuestionListDto getMyQuestion(Long userId) {
		Question question = questionJpaRepository.findByLocalDateTime(today);

		TodayQuestion todayQuestion = TodayQuestion.of(question.getQuestionId(), question.getQuestionName());

		User user = userJpaRepository.findByIdOrThrow(userId);
		List<Answer> answerList = answerJpaRepository.findByUser(user); // 현재 유저가 답한 답변들
		System.out.println(answerList);
		List<Question> questionList = answerList.stream().map(Answer::getQuestion).collect(Collectors.toList()); //답변들 중의 질문을 가져와서 질문리스트 만듬
		Collections.shuffle(questionList); //랜덤으로 질문 리스트를 섞었어.
		List<Question> randomQuestions = questionList.subList(0, Math.min(4, questionList.size())); //4개를 뽑았어.
		System.out.println(randomQuestions);
		List<QuestionDto> randomQuestionDtoList = randomQuestions.stream().map((q) -> QuestionDto.of(q.getQuestionId(), q.getQuestionName())).collect(Collectors.toList());
		return QuestionListDto.of(todayQuestion, randomQuestionDtoList);

	}
}

