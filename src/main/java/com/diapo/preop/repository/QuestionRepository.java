package com.diapo.preop.repository;

import com.diapo.preop.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByQuestionParent(Question question);

}
