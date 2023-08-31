package bank.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Data
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends Exception {

    private static final long serialVersionUID = 1L;

    private HashMap data;

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, HashMap data) {
        super(message);
        this.data = data;
    }

}
