package co.edu.unbosque.finalproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetCaseNotFoundException extends RuntimeException {
    public PetCaseNotFoundException(Long id) {
        super(MessageFormat.format("Could not find pet case with id: {0}", id));
    }
}
