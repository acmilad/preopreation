package com.diapo.preop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private Long id;
    private Patient patient;
    private Question question;
    private String value;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    @JoinColumn(name = "question_id")
    @ManyToOne
    @JsonIgnore
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    @Column
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
