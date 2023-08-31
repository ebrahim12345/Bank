package bank.exceptions;


import ir.bank.enums.ErrorCode;

/**
 * @author mosio
 */
public class SaveObjectException extends EkiDaoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public SaveObjectException () {
        super(ErrorCode.SAVE_ERROR);
    }
}
