package com.diapo.preop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;
    private Question questionParent;
    private Set<Question> questions;
    private String title;
    private String type;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
//                ", questionParent=" + questionParent +
//                ", questions=" + questions +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    public Question getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(Question questionParent) {
        this.questionParent = questionParent;
    }
    @OneToMany(mappedBy = "questionParent",fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
