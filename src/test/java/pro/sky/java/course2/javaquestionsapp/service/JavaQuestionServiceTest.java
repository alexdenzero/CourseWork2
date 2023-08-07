package pro.sky.java.course2.javaquestionsapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.javaquestionsapp.model.Question;
import pro.sky.java.course2.javaquestionsapp.questionExceptions.QuestionNotFoundException;
import pro.sky.java.course2.javaquestionsapp.service.impl.JavaQuestionRepository;
import pro.sky.java.course2.javaquestionsapp.service.impl.JavaQuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private static final List<Question> JAVA_QUESTIONS = List.of(
            new Question("1", "1"),
            new Question("2", "2"),
            new Question("3", "3"));
    JavaQuestionRepository repository = mock(JavaQuestionRepository.class);
    JavaQuestionService out = new JavaQuestionService(repository);

    @Test
    void addPositive() {
        Question expected = new Question("question", "answer");
        when(repository.add(expected)).thenReturn(expected);
        assertEquals(out.add("question", "answer"), expected);
    }

    @Test
    void removePositive() {
        Question expected = new Question("question", "answer");
        when(repository.remove(expected)).thenReturn(expected);
        assertEquals(out.remove(expected), expected);
    }

    @Test
    void removeNonExistentQuestion() {
        Question nonExistentQuestion = new Question("question", "answer");
        when(repository.getAll()).thenReturn(JAVA_QUESTIONS);
        when(repository.remove(nonExistentQuestion)).thenThrow(QuestionNotFoundException.class);
        assertFalse(out.getAll().contains(nonExistentQuestion));
        assertThrows(QuestionNotFoundException.class, () -> out.remove(nonExistentQuestion));
    }

    @Test
    void returnAllQuestions() {
        when(repository.getAll()).thenReturn(JAVA_QUESTIONS);
        List<Question> expected = new ArrayList<>(List.of(
                new Question("1", "1"),
                new Question("2", "2"),
                new Question("3", "3")
        ));
        assertEquals(out.getAll(), expected);
    }

    @Test
    void getAllRandomQuestion() {
        when(repository.getAll()).thenReturn(JAVA_QUESTIONS);
        List<Question> gottenQuestions = (List<Question>) out.getAll();

        Question expected1 = new Question("1", "1");
        Question expected2 = new Question("2", "2");
        Question expected3 = new Question("3", "3");

        assertEquals(gottenQuestions.get(0), expected1);
        assertEquals(gottenQuestions.get(1), expected2);
        assertEquals(gottenQuestions.get(2), expected3);
    }
}
