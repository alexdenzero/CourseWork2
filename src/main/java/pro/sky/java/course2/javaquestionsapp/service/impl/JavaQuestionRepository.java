package pro.sky.java.course2.javaquestionsapp.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.QuestionNotFoundException;
import pro.sky.java.course2.javaquestionsapp.service.QuestionRepository;

import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> JAVA_QUESTIONS = new HashSet<>();
    @PostConstruct
    public void init() {
        JAVA_QUESTIONS.add(new Question("4", "4"));
        JAVA_QUESTIONS.add(new Question("5", "5"));
        JAVA_QUESTIONS.add(new Question("6", "6"));
    }

    @Override
    public Question add(Question question) {
        JAVA_QUESTIONS.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!JAVA_QUESTIONS.contains(question)) {
            throw new QuestionNotFoundException("There isn't " + question);
        }
        JAVA_QUESTIONS.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(JAVA_QUESTIONS));
    }
}
