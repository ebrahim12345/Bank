package bank.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private Date timestamp;
    private String message;
    private HashMap data;
    private String details;

}
