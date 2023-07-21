package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
