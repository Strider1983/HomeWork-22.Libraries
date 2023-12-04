package exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployeeAlreadyExistExeption extends RuntimeException{

    public EmployeeAlreadyExistExeption(String message) {
        super(message);
    }
}
