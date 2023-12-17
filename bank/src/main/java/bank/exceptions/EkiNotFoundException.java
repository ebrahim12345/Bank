package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author Ebrahim
 */
public class EkiNotFoundException extends EkiRecoverableException {

    private static final long serialVersionUID = -8582951065266241410L;

    /**
     *
     */
    public EkiNotFoundException () {

        super(ErrorCode.OBJECT_NOT_FOUND);
    }

    /**
     * @param errorCode
     */
    public EkiNotFoundException ( ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * @param message
     * @param errorCode
     */
    public EkiNotFoundException ( String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message
     * @param cause
     * @param errorCode
     */
    public EkiNotFoundException ( String message, Throwable cause,
                                  ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * @param message
     * @param cause
     */
    public EkiNotFoundException ( String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public EkiNotFoundException ( String message) {
        super(message);
    }

    /**
     * @param cause
     * @param errorCode
     */
    public EkiNotFoundException ( Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    /**
     * @param cause
     */
    public EkiNotFoundException ( Throwable cause) {
        super(cause);
    }


}
