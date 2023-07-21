package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Utilisateur;
import com.yougo.APIRESTTP.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("quiz/")
@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @GetMapping("")
    public Optional<List> getAllQuiz(){
        Optional<List> user = Optional.ofNullable(quizService.getAllQuiz());
        return Optional.ofNullable(user.orElse(null));
    }
    @PutMapping("{id}")
    public Quiz getQuizById(@PathVariable Long id){
        Optional<Quiz> quiz = quizService.getQuizById(id);
        return (Quiz) quiz.orElse(null);
    }
    @PutMapping("update/{id}")
    public Quiz updateQuiz(@PathVariable Long id,@RequestBody Quiz quiz){
        Optional<Quiz> quizz = Optional.ofNullable(quizService.editQuiz(id, quiz));
        return (Quiz) quizz.orElse(null);
    }
    @DeleteMapping("delete/")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return quizService.deleQuizById(id);
    }

    @PostMapping("creer")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }
}