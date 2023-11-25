package org.sopt.sopkathon.iosthree.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Answer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	private String answerName;

	@Builder
	public Answer(User user, Question question, String answerName){
		this.user = user;
		this.question = question;
		this.answerName = answerName;
	}

}
