package pro.sky.java.course2.javaquestionsapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.WrongQuestionsAmountRequest;
import pro.sky.java.course2.javaquestionsapp.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.javaquestionsapp.service.impl.JavaQuestionService;
import pro.sky.java.course2.javaquestionsapp.service.impl.MathQuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    public static final List<Question> JAVA_QUESTIONS = List.of(
            new Question("1", "1"),
            new Question("2", "2"));
    public static final  List<Question> MATH_QUESTIONS = List.of(
            new Question("3", "3"),
            new Question("4", "4"));
    JavaQuestionService javaService = mock(JavaQuestionService.class);
    MathQuestionService mathService = mock(MathQuestionService.class);
    ExaminerServiceImpl out = new ExaminerServiceImpl(javaService, mathService);


    @Test
    void returnRandomAmountOfQuestions() {
        when(javaService.getRandomQuestion()).thenReturn(JAVA_QUESTIONS.get(0)).thenReturn(JAVA_QUESTIONS.get(1));
        when(mathService.getRandomQuestion()).thenReturn(MATH_QUESTIONS.get(0)).thenReturn(MATH_QUESTIONS.get(1));
        when(javaService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathService.getAll()).thenReturn(MATH_QUESTIONS);
        int expectedAmount = 4;
        assertEquals(expectedAmount, out.getQuestions(expectedAmount).size());
    }
    @Test
    void throwWrongQuestionsAmountException() {
        int veryBigAmount = 5;
        assertThrows(WrongQuestionsAmountRequest.class, () -> out.getQuestions(veryBigAmount));
    }
}
