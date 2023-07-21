package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Question;
import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("question")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("")
    public Optional<List> getAllQuestions(){
        Optional<List> user = Optional.ofNullable(questionService.getAllQuestions());
        return Optional.ofNullable(user.orElse(null));
    }
    @PutMapping("{id}")
    public Question getQuestionById(@PathVariable Long id){
        Optional<Question> question = questionService.getQuestionById(id);
        return (Question) question.orElse(null);
    }
    @PutMapping("update/{id}")
    public Question updateQuiz(@PathVariable Long id,@RequestBody Question question){
        Optional<Question> question1 = Optional.ofNullable(questionService.editQuestion(id, question));
        return (Question) question1.orElse(null);
    }
    @DeleteMapping("delete/")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return questionService.deleQuestionById(id);
    }

    @PostMapping("creer")
    public Question create(@RequestBody Question question){
        return questionService.createQuiz(question);
    }
}