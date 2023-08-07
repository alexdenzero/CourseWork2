package pro.sky.java.course2.javaquestionsapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.service.QuestionRepository;
import pro.sky.java.course2.javaquestionsapp.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository repository;
    public MathQuestionService(MathQuestionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        return repository.add(questionToAdd);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = (List<Question>) repository.getAll();
        return questionList.get(random.nextInt(0, questionList.size()));
    }
}
