package pro.sky.java.course2.javaquestionsapp.service;

import pro.sky.java.course2.javaquestionsapp.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    void init();
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
