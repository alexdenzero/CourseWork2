package pro.sky.java.course2.javaquestionsapp.questionExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongQuestionsAmountRequest extends RuntimeException{
    public WrongQuestionsAmountRequest() {
    }

    public WrongQuestionsAmountRequest(String message) {
        super(message);
    }

    public WrongQuestionsAmountRequest(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongQuestionsAmountRequest(Throwable cause) {
        super(cause);
    }

    public WrongQuestionsAmountRequest(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
