package com.yougo.APIRESTTP.services;

import com.yougo.APIRESTTP.model.Participation;
import com.yougo.APIRESTTP.model.Question;
import com.yougo.APIRESTTP.repository.ParticipationRepository;
import com.yougo.APIRESTTP.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    public Participation createQuiz(Participation participation){
        return participationRepository.save(participation);
    }
    public List<Participation> getAllQuestions(){
        return participationRepository.findAll();
    }

    public Optional<Participation> getQuestionById(Long id){
        return participationRepository.findById(id);
    }

    public String editParticipation(Long id, int score){
        participationRepository.findById(id)
                .map(p ->{
                    p.setScore(score);
                    return participationRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Question non trouvé"));
        return "Modification éffectué";
    }
    public boolean deleQuestionById(Long id){
        participationRepository.deleteById(id);
        return true;
    }
}