package com.yougo.APIRESTTP.services;

import com.yougo.APIRESTTP.model.Utilisateur;
import com.yougo.APIRESTTP.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id){
        return utilisateurRepository.findById(id);
    }

    public Utilisateur editUtilisateur(Long id, Utilisateur utilisateur){
        utilisateurRepository.findById(id)
                .map(p ->{
                    p.setName(utilisateur.getName());
                    p.setPassword(utilisateur.getPassword());
                    return utilisateurRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
        return utilisateur;
    }
    public boolean deleteUtilisateurById(Long id){
        utilisateurRepository.deleteById(id);
        return true;
    }
}
