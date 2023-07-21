package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse,Long> {
}
