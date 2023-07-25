package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Question;
import com.yougo.APIRESTTP.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Question findQuestionById(Long questionId);
}
