package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
public class ObjectNotFoundException extends EkiDaoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public ObjectNotFoundException () {
        super(ErrorCode.OBJECT_NOT_FOUND);
    }

    /**
     * @param message
     */
    public ObjectNotFoundException ( String message) {
        super(message, ErrorCode.OBJECT_NOT_FOUND);
    }
}
