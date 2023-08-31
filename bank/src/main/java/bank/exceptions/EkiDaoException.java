package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
public class EkiDaoException extends EkiException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public EkiDaoException ( ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * @param message
     * @param errorCode
     */
    public EkiDaoException ( String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    /**
     * @param message
     * @param cause
     * @param errorCode
     */
    public EkiDaoException ( String message, Throwable cause,
                             ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    /**
     * @param message
     * @param cause
     */
    public EkiDaoException ( String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public EkiDaoException ( String message) {
        super(message);
    }

    /**
     * @param cause
     * @param errorCode
     */
    public EkiDaoException ( Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }

    /**
     * @param cause
     */
    public EkiDaoException ( Throwable cause) {
        super(cause);
    }


}
