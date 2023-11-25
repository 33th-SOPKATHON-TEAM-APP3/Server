package org.sopt.sopkathon.iosthree.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.sopkathon.iosthree.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJpaRepository extends JpaRepository<Question, Long> {

    default Question findByIdOrThrow(Long questionId){
        return findById(questionId)
                .orElseThrow(()-> new EntityNotFoundException("해당하는 질문이 없습니다."));
    }
}