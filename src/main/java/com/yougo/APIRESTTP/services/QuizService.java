package com.yougo.APIRESTTP.services;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public  Quiz createQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
    public List<Quiz> getAllQuiz(){

        return quizRepository.findAll();
    }
    public List<Quiz> getAllQuizByUtilisateur(Long id){

        return quizRepository.findByUtilisateur_id(id);
    }

    public List<Quiz> getSearchQuiz(String titre){

        return quizRepository.findByTitreContaining(titre);
    }
    public Optional<Quiz> getQuizById(Long id){
        return quizRepository.findById(id);
    }

    public Quiz editQuiz(Long id, Quiz quiz){
            quizRepository.findById(id)
                    .map(p ->{
                        p.setTitre(quiz.getTitre());
                        p.setUtilisateur(quiz.getUtilisateur());
                        return quizRepository.save(p);
                    }).orElseThrow(() -> new RuntimeException("Quiz non trouvé"));
        return quiz;
    }
    public boolean deleQuizById(Long id){
         quizRepository.deleteById(id);
         return true;
    }
}