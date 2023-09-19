package com.diapo.preop.controller;

import com.diapo.preop.model.Answer;
import com.diapo.preop.repository.AnswerRepository;
import com.diapo.preop.util.MyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    AnswerRepository answerRepository;
    @Autowired
    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @GetMapping("/all")
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public String getAnswer(@PathVariable Long id) throws JsonProcessingException {
        Answer answer = answerRepository.findById(id).get();
        return MyUtil.answerToJson(answer);
    }

    @PostMapping
    public String saveAnswer(@RequestBody Answer Answer) {
        answerRepository.save(Answer);
        return "Answer saved successfully";
    }
}
