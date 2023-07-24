package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    List<Quiz> findByTitreContaining(String titre);

    List<Quiz> findByUtilisateur_id(Long id);
}
