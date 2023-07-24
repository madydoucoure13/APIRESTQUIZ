package com.yougo.APIRESTTP.model;

import jakarta.persistence.*;

import java.util.List;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;


    public Category() {
    }

    public Category(Long id, String titre,Utilisateur utilisateur) {
        this.id = id;
        this.titre = titre;
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

}
