package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.ApiResponse;
import com.yougo.APIRESTTP.model.*;
import com.yougo.APIRESTTP.services.ParticipationService;
import com.yougo.APIRESTTP.services.QuestionService;
import com.yougo.APIRESTTP.services.ReponseService;
import com.yougo.APIRESTTP.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("participation")
@RestController
public class ParticipationController {

    private final ParticipationService participationService;
    private final UtilisateurService utilisateurService;

    private final QuestionService questionService;

    private final ReponseService reponseService;


    @Autowired
    public ParticipationController(ParticipationService participationService,UtilisateurService utilisateurService,
                                    QuestionService questionService,ReponseService reponseService){
        this.participationService = participationService;
        this.utilisateurService = utilisateurService;
        this.questionService = questionService;
        this.reponseService = reponseService;
    }

    @GetMapping("/{userId}/{quizId}/init")
    public Participation init(@PathVariable Long userId,@PathVariable Long quizId){
        Participation participation = participationService.getParticipationByUserAndQuizId(userId,quizId);
        if(participation != null){
            participationService.editParticipation(participation.getId(), 0);
                participation.setScore(0);
            return participation;
        }
        return  new Participation();
    }
    @GetMapping("/{userId}/{quizId}/{questionId}")
    public ApiResponse game(@PathVariable Long userId,@PathVariable Long quizId, @PathVariable Long questionId,
                            @RequestParam Long checkedReponseID){
            Utilisateur utilisateur = utilisateurService.findUtilisateurById(userId);
            Question quest = questionService.findQuestionById(questionId);
            Quiz quiz = quest.getQuiz();

          // Long quizzId = quiz.getId();
           boolean checkResponse = reponseService.getReponseById(checkedReponseID).get().isIscorrect();
           Participation participation = participationService.getParticipationByUserAndQuizId(userId,quizId);
           if(participation == null){
                participation = new Participation();
                participation.setScore(0);
                participation.setQuiz(quiz);
                participation.setUtilisateur(utilisateur);
                participationService.createQuiz(participation);
           }
           List <Reponse> responses = reponseService.getAllResponsesByQuizId(quizId);
           if(checkResponse){
               participationService.editParticipation(participation.getId(), participation.getScore()+quest.getPoints());
               return new ApiResponse(200,"Mr "+utilisateur.getName()+" Vous avez choici la bonne reponse votre score est de "+(participation.getScore()),null);
           }else
               return new ApiResponse(200," Oups Mr "+utilisateur.getName()+" Vous avez choici la nauvaise reponse votre score est de "+(participation.getScore()),responses);

    }
    @GetMapping("{id}")
    public Participation getQuestionById(@PathVariable Long id){
        Optional<Participation> question = participationService.getParticipationById(id);
        return (Participation) question.orElse(null);
    }
    @PutMapping("update/{id}")
    public String updateQuiz(@PathVariable Long id,@RequestBody int score){
        Optional<String> participation1 = Optional.ofNullable(participationService.editParticipation(id, score));
        return (String) participation1.orElse(null);
    }
    @DeleteMapping("delete/{id}")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return participationService.deleQuestionById(id);
    }

    @PostMapping("/creer")
    public Participation create(@RequestBody Participation participation){
        return participationService.createQuiz(participation);
    }
}