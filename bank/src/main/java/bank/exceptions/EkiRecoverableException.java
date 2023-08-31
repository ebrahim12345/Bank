package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
public class EkiRecoverableException extends EkiServiceException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public EkiRecoverableException ( ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * @param message
     * @param errorCode
     */
    public EkiRecoverableException ( String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message
     * @param cause
     * @param errorCode
     */
    public EkiRecoverableException ( String message, Throwable cause,
                                     ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * @param message
     * @param cause
     */
    public EkiRecoverableException ( String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public EkiRecoverableException ( String message) {
        super(message);
    }

    /**
     * @param cause
     * @param errorCode
     */
    public EkiRecoverableException ( Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    /**
     * @param cause
     */
    public EkiRecoverableException ( Throwable cause) {
        super(cause);
    }


}
