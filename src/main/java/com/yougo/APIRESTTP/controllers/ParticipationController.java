package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Participation;
import com.yougo.APIRESTTP.model.Question;
import com.yougo.APIRESTTP.repository.ParticipationRepository;
import com.yougo.APIRESTTP.services.ParticipationService;
import com.yougo.APIRESTTP.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("participation")
@RestController
public class ParticipationController {

    private final ParticipationService participationService;

    @Autowired
    public ParticipationController(ParticipationService participationService){
        this.participationService = participationService;
    }

    @GetMapping("")
    public Optional<List> getAllQuestions(){
        Optional<List> user = Optional.ofNullable(participationService.getAllQuestions());
        return Optional.ofNullable(user.orElse(null));
    }
    @GetMapping("{id}")
    public Participation getQuestionById(@PathVariable Long id){
        Optional<Participation> question = participationService.getQuestionById(id);
        return (Participation) question.orElse(null);
    }
    @PutMapping("update/{id}")
    public Question updateQuiz(@PathVariable Long id,@RequestBody Participation question){
        Optional<Question> question1 = Optional.ofNullable(participationService.editParticipation(id, question));
        return (Question) question1.orElse(null);
    }
    @DeleteMapping("delete/")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return participationService.deleQuestionById(id);
    }

    @PostMapping("/creer")
    public Question create(@RequestBody Question question){
        return participationService.createQuiz(question);
    }
}