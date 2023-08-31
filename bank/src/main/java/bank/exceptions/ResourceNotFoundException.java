package bank.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    private static final String RESOURCE_NOT_FOUND_MESSAGE = "موردی با مشخصات زیر یافت نشد";

    private HashMap data;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String arg1, Object arg2) {
        super( RESOURCE_NOT_FOUND_MESSAGE + " \n" + arg1 + " :" + arg2);
    }

    public ResourceNotFoundException(String arg1, String arg2, HashMap data) {
        super( RESOURCE_NOT_FOUND_MESSAGE + " \n" + arg1 + " :" + arg2);
        this.data = data;
    }

}
