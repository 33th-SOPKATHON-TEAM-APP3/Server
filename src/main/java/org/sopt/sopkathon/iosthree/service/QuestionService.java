package org.sopt.sopkathon.iosthree.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.sopt.sopkathon.iosthree.controller.dto.response.TodayQuestion;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.infrastructure.QuestionJpaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
	private final QuestionJpaRepository questionJpaRepository;
	private final Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

	public TodayQuestion getTodayQuestion(){
		Optional<Question> question = questionJpaRepository.findByLocalDateTime(today);

		return TodayQuestion.of(question.get().getQuestionName());
	}
}
