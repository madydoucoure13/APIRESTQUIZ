package com.yougo.APIRESTTP.model;

import jakarta.persistence.*;

public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "quiz_id",nullable = false)
    private Quiz quiz;

    public Participation() {
    }

    public Participation(Long id, Utilisateur utilisateur, Quiz quiz, int score) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.quiz = quiz;
        this.score = score;
    }

    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
