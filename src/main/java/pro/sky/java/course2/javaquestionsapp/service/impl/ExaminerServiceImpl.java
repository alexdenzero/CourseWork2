package pro.sky.java.course2.javaquestionsapp.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.WrongQuestionsAmountRequest;
import pro.sky.java.course2.javaquestionsapp.service.ExaminerService;
import pro.sky.java.course2.javaquestionsapp.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Qualifier("javaQuestionService")
    private final QuestionService javaQuestionService;

    @Qualifier("mathQuestionService")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        int count = 0;
        Set<Question> gottenQuestions = new LinkedHashSet<>();
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new WrongQuestionsAmountRequest("Invalid request");
        }
        while (gottenQuestions.size() < amount) {
            count = random.nextInt(0, 2);
            switch (count) {
                case 0:
                    gottenQuestions.add(javaQuestionService.getRandomQuestion());
                    break;
                case 1:
                    gottenQuestions.add(mathQuestionService.getRandomQuestion());
                    break;
            }
        }
        return gottenQuestions;
    }
}
