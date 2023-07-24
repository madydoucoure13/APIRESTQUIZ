package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Quiz;
import com.yougo.APIRESTTP.model.Reponse;
import com.yougo.APIRESTTP.services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reponse")
public class ReponseController {

    private final ReponseService reponseService;

    @Autowired
    public ReponseController(ReponseService reponseService){
        this.reponseService = reponseService;
    }

    @GetMapping("")
    public Optional<List> getAllReponses(){
        Optional<List> responses = Optional.ofNullable(reponseService.getAllResponses());
        return Optional.ofNullable(responses.orElse(null));
    }
    @PutMapping("{id}")
    public Reponse getResponseById(@PathVariable Long id){
        Optional<Reponse> reponse = reponseService.getReponseById(id);
        return (Reponse) reponse.orElse(null);
    }
    @PutMapping("update/{id}")
    public Reponse updateResponse(@PathVariable Long id,@RequestBody Reponse reponse){
        Optional<Reponse> quizz = Optional.ofNullable(reponseService.editReponse(id, reponse));
        return (Reponse) quizz.orElse(null);
    }
    @DeleteMapping("delete/")
    public  Boolean delete(@PathVariable Long id){
        return reponseService.deleteReponseById(id);
    }

    @PostMapping("creer")
    public Reponse create(@RequestBody Reponse reponse){
        return reponseService.createReponse(reponse);
    }


}