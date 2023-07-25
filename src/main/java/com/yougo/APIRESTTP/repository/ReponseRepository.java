package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReponseRepository extends JpaRepository<Reponse,Long> {

    List<Reponse> findReponsesByQuestion_Id(Long id);
}
