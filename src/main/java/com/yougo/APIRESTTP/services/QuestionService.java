package com.yougo.APIRESTTP.services;

import com.yougo.APIRESTTP.model.Question;
import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.repository.QuestionRepository;
import com.yougo.APIRESTTP.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuiz(Question question){
        return questionRepository.save(question);
    }
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id){
        return questionRepository.findById(id);
    }

    public Question findQuestionById(Long id){
        return questionRepository.findQuestionById(id);
    }

    public Question editQuestion(Long id, Question question){
        questionRepository.findById(id)
                .map(p ->{
                    p.setLibelle(question.getLibelle());
                    return questionRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Question non trouvé"));
        return question;
    }
    public boolean deleQuestionById(Long id){
        questionRepository.deleteById(id);
        return true;
    }
}