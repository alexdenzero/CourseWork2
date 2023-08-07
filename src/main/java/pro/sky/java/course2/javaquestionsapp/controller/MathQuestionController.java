package pro.sky.java.course2.javaquestionsapp.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService")QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question add(Question question) {
        return questionService.add(question);
    }
    @GetMapping("/remove")
    public Question remove(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
