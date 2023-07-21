package com.yougo.APIRESTTP.services;

import com.yougo.APIRESTTP.model.Reponse;
import com.yougo.APIRESTTP.repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseService {
    @Autowired
    private ReponseRepository reponseRepository;

    public Reponse createReponse(Reponse reponse){
        return reponseRepository.save(reponse);
    }
    public List<Reponse> getAllResponses(){
        return reponseRepository.findAll();
    }

    public Optional<Reponse> getReponseById(Long id){
        return reponseRepository.findById(id);
    }

    public Reponse editReponse(Long id, Reponse reponse){
        reponseRepository.findById(id)
                .map(p ->{
                    p.setText(reponse.getText());
                    p.setQuestion(reponse.getQuestion());
                    p.setIscorrect(reponse.isIscorrect());
                    return reponseRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
        return reponse;
    }
    public boolean deleteReponseById(Long id){
        reponseRepository.deleteById(id);
        return true;
    }
}