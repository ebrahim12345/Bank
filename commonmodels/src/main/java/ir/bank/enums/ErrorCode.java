package ir.bank.enums;

/**
 * @author Ebrahim
 */
public enum ErrorCode {

    UNKNOWN(0),
    INTERNAL_ERROR(10001),
    INTERNAL_IO_ERROR(10002),
    VERSION_CHANGED(10003),
    LOCK_ERROR(10004),
    DATA_IS_INVALID(10005),
    SAVE_ERROR(10006),
    REMOVE_ERROR(10007),
    GET_ERROR(10008),
    OBJECT_NOT_FOUND(10009),
    OBJECT_EXIST(10010),
    DATA_DUPLICATE(10011),
    ACCESS_DENIDE(10012),
    OBJECT_USED(10013),
    FIELD_IS_EMPTY(10014),
    INVALID_DATE_FORMAT(10015),
    NOT_ENOUGH_PARAMETERS(10016),
    CALCULATION_ERROR(10017),
    TODATE_BEFORE_FROMDATE(10018),
    OBJECT_IS_NOT_ACTIVE(1019),
    ATLEAST_ONE_TRACK_NEEDED(10100),
    HOUSEWAY_HAS_NO_TRACK(10101),
    KEY_NOT_UNIQUE(10102),
    INVALID_INSTANCE_CLASS(10103),
    INVALID_DATA_FORMAT(10104),
    ALREADY_IN_SAME_STATE(10105),
    INVALID_ACTION(10106),
    MISSING_CONFIG(10107);


    private final int value;

    /**
     * @param value
     */
    ErrorCode(int value) {
        this.value = value;
    }

    /**
     * @param value
     * @return
     */
    public static ErrorCode fromValue(int value) {

        for (ErrorCode thisValue : values()) {
            if (thisValue.value == value) {
                return thisValue;
            }
        }

        return getDefault();
    }

    /**
     * @return
     */
    public int toValue() {
        return value;
    }

    /**
     * @return
     */
    public static ErrorCode getDefault() {
        return UNKNOWN;
    }
}