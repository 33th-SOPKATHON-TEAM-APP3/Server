package org.sopt.sopkathon.iosthree.domain;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;

	private LocalDate localDateTime;
	private String questionName;
}
