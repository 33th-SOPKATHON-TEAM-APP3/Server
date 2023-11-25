package org.sopt.sopkathon.iosthree.infrastructure;

import org.sopt.sopkathon.iosthree.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {

}
