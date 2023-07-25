package com.yougo.APIRESTTP.repository;

import com.yougo.APIRESTTP.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);

}
