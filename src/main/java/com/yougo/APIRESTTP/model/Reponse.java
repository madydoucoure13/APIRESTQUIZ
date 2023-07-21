package com.yougo.APIRESTTP.model;

import jakarta.persistence.*;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id",nullable = false)
    private Question question;

    @Column(nullable = false)
    private boolean iscorrect;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    public Reponse() {
    }

    public Reponse(Long id, String text, Question question, boolean iscorrect) {
        this.id = id;
        this.text = text;
        this.question = question;
        this.iscorrect = iscorrect;
    }
}
