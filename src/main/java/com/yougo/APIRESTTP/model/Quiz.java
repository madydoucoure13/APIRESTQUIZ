package com.yougo.APIRESTTP.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private List<Question> questions;

    public Quiz() {
    }

    public Quiz(Long id, String titre,Utilisateur utilisateur, List<Question> questions) {
        this.id = id;
        this.titre = titre;
        this.questions = questions;
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
