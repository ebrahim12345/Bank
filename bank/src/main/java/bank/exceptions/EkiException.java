package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
public class EkiException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    /**
     * @param message
     */
    public EkiException ( String message) {
        super(message);
    }

    /**
     * @param message
     */
    public EkiException ( ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * @param cause
     */
    public EkiException ( Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public EkiException ( String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @param message
     * @param cause
     */
    public EkiException ( String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public EkiException ( Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * @param message
     * @param cause
     */
    public EkiException ( String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }


}
