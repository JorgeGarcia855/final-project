package co.edu.unbosque.finalproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VetNotFoundException extends RuntimeException {
    public VetNotFoundException(String username) {
        super(MessageFormat.format("Could not find vet with username: {0}", username));
    }
}
