package com.yougo.APIRESTTP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(columnDefinition = "integer default 1")
    private int points;

    @ManyToOne
    @JoinColumn(name = "quiz_id",nullable = false)
    private Quiz quiz;

    @JsonIgnore
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Question(Long id, String libelle,int points, Quiz quiz, List<Reponse> reponses) {
        this.id = id;
        this.libelle = libelle;
        this.points = points;
        this.quiz = quiz;
        this.reponses = reponses;
    }
}
