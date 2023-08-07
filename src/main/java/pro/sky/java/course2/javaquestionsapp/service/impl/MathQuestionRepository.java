package pro.sky.java.course2.javaquestionsapp.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.QuestionNotFoundException;
import pro.sky.java.course2.javaquestionsapp.service.QuestionRepository;

import java.util.*;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> MATH_QUESTIONS = new HashSet<>();
    @PostConstruct
    public void init() {
        MATH_QUESTIONS.add(new Question("1", "1"));
        MATH_QUESTIONS.add(new Question("2", "2"));
        MATH_QUESTIONS.add(new Question("3", "3"));
    }

    @Override
    public Question add(Question question) {
        MATH_QUESTIONS.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!MATH_QUESTIONS.contains(question)) {
            throw new QuestionNotFoundException("There isn't " + question);
        }
        MATH_QUESTIONS.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(MATH_QUESTIONS));
    }
}
