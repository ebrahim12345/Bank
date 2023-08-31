package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
//@ApplicationException(rollback=true)
public class EkiServiceException extends EkiException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public EkiServiceException ( ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * @param message
     * @param errorCode
     */
    public EkiServiceException ( String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message
     * @param cause
     * @param errorCode
     */
    public EkiServiceException ( String message, Throwable cause,
                                 ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * @param message
     * @param cause
     */
    public EkiServiceException ( String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public EkiServiceException ( String message) {
        super(message);
    }

    /**
     * @param cause
     * @param errorCode
     */
    public EkiServiceException ( Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    /**
     * @param cause
     */
    public EkiServiceException ( Throwable cause) {
        super(cause);
    }


}
