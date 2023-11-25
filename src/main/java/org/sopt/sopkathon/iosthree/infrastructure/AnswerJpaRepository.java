package org.sopt.sopkathon.iosthree.infrastructure;

import org.sopt.sopkathon.iosthree.domain.Answer;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.sopt.sopkathon.iosthree.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> findByUserAndQuestion(User user, Question question);
    List<Answer> findByUser(User user);

}
