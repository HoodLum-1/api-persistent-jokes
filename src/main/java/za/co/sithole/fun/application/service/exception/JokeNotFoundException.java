package za.co.sithole.fun.application.service.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus
public class JokeNotFoundException extends RuntimeException {
    private final String message;
    public JokeNotFoundException(String message) {
        this.message = message;
    }
}
