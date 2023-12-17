package bank.util;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NullCheck<T> {

    private T value;


    public NullCheck(T value) {
        this.value = value;
    }

    public <V> NullCheck with(Function<T, V> getter) {
        return value != null ? new NullCheck<>(getter.apply(value)) : new NullCheck<>(null);
    }

    public Boolean isItNull() {
        return true == (value == null ? true : false);
    }


    public static final Boolean isItNumeric2(String val) {
        if (val == null) {
            return false;
        }
        try {
            Long temp = Long.parseLong(val);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public Boolean isItNumeric(String val) {
        boolean isNumeric = Stream.of(val)
                .filter(s -> s != null && !s.isEmpty())
                .filter(Pattern.compile("\\D").asPredicate().negate())
                .mapToLong(Long::valueOf)
                .boxed()
                .findAny()
                .isPresent();
        return isNumeric;
    }

}

