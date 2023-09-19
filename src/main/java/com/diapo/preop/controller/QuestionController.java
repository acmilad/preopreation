package com.diapo.preop.controller;

import com.diapo.preop.model.Question;
import com.diapo.preop.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {
    QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/all")
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id) {
        return questionRepository.findById(id);
    }

    @PostMapping
    public String saveQuestion(@RequestBody Question Question) {
        questionRepository.save(Question);
        return "Question saved successfully";
    }

    @GetMapping("/getchilds/{parentId}")
    public List<Question> getQuestionChilds(@PathVariable Long parentId) {
        Question q = new Question();
        q.setId(parentId);
        return questionRepository.findByQuestionParent(q);
    }
}
