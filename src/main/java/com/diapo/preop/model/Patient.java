package com.diapo.preop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    private sex sex;
    private String attendingPhysician;
    private String ward;
    private Long unitNo;
    private String probableDiagnosis;
    private String description;
    private candidate candidate;
    List<Answer> answerList;


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", attendingPhysician='" + attendingPhysician + '\'' +
                ", ward='" + ward + '\'' +
                ", unitNo=" + unitNo +
                ", probableDiagnosis='" + probableDiagnosis + '\'' +
                ", description='" + description + '\'' +
                ", candidate=" + candidate +
                '}';
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Column
    @Enumerated
    public com.diapo.preop.model.sex getSex() {
        return sex;
    }

    public void setSex(com.diapo.preop.model.sex sex) {
        this.sex = sex;
    }
    @Column
    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }
    @Column
    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
    @Column(name = "unit_no")
    public Long getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Long unitNo) {
        this.unitNo = unitNo;
    }
    @Column
    public String getProbableDiagnosis() {
        return probableDiagnosis;
    }

    public void setProbableDiagnosis(String probableDiagnosis) {
        this.probableDiagnosis = probableDiagnosis;
    }
    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column
    @Enumerated
    public com.diapo.preop.model.candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(com.diapo.preop.model.candidate candidate) {
        this.candidate = candidate;
    }
    @JsonManagedReference
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}

enum sex{
    MALE
    ,FEMALE
}
enum candidate{
    OPERATION,
    PROCEDURE
}
