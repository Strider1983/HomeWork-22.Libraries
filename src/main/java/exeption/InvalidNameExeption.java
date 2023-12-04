package exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class InvalidNameExeption extends RuntimeException{
    public InvalidNameExeption(String message) {
        super(message);
    }
}
