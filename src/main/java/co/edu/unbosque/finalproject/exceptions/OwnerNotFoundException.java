package co.edu.unbosque.finalproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException (String username) {
        super(MessageFormat.format("Could not find owner with username: {0}", username));
    }
}
