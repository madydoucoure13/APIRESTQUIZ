package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Utilisateur;
import com.yougo.APIRESTTP.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("quiz")
@RestController
public class QuizController {

    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<List> getAllQuizByUtilisateur(@PathVariable Long id){
        Optional<List> user = Optional.ofNullable(quizService.getAllQuizByUtilisateur(id));
        return Optional.ofNullable(user.orElse(null));
    }
    @GetMapping("")
    public Optional<List> getAllQuiz(){
        Optional<List> user = Optional.ofNullable(quizService.getAllQuiz());
        return Optional.ofNullable(user.orElse(null));
    }
    @GetMapping("/search/{titre}")
    public Optional<List> getAllQuizSearch(@PathVariable String titre){
        Optional<List> user = Optional.ofNullable(quizService.getSearchQuiz(titre));
        return Optional.ofNullable(user.orElse(null));
    }
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
        Optional<Quiz> quiz = quizService.getQuizById(id);
        return (Quiz) quiz.orElse(null);
    }
    @PutMapping("/update/{id}")
    public Quiz updateQuiz(@PathVariable Long id,@RequestBody Quiz quiz){
        Optional<Quiz> quizz = Optional.ofNullable(quizService.editQuiz(id, quiz));
        return (Quiz) quizz.orElse(null);
    }
    @DeleteMapping("/delete/{id}")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return quizService.deleQuizById(id);
    }

    @PostMapping("/create")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }
}