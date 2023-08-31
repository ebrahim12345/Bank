package bank.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String FIELD_IS_NULL_MESSAGE = "فیلد زیر خالی است";
    public static final String FIELDS_MUST_BE_FILLED_ATLEAST_MESSAGE = "حداقل یکی از فیلدهای زیر باید پر شوند";
    public static final String MAX_VALUE_OBEY_RULE = "عدم رعایت حداکثر مقدار ";
    public static final String CONFILICT_VALUE_OBEY_RULE = "عدم رعایت محدوده ";
    public static final String CONFILICT_DISCOUNT_SYSTEMS = "برای این محصول در این تاریخ، قبلاً تخفیف سیستمی تعریف شده است. نام محصول: ";
    public static final String REPEATED_DISCOUNT_SYSTEMS_NAME = "نام تخفیف سیستمی تکراری است.";
    public static final String INVALID_TIMESPAN = "بازۀ زمانی تعریف شده نامعتبر است. ";
    public static final String CONFILICT_DISCOUNT_SYSTEMS_PERIOD = "بازۀ تعریف شده برای از تعداد/ کیلومتر/ تعداد ماه، تا تعداد/ کیلومتر/ تعداد ماه با بازه هایی که قبلا تعریف شده تداخل دارد. ";
    public static final String INVALID_KILOMETER_PERIOD = "کیلومتر شروع باید کمتر از کیلومتر پایان باشد. ";

    private HashMap data;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, String field) {
        super(message + "\n" + field);
    }

    public BadRequestException(String message, String... fields) {
        super(message + "\n" + fields);
    }

    public BadRequestException(String message, HashMap<String, Object> data) {
        super(message);
        this.data = data;
    }

}
