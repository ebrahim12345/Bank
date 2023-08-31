package bank.exceptions;


import javax.security.sasl.AuthenticationException;

public class EkiAuthenticationException extends AuthenticationException {

    public EkiAuthenticationException(String msg, Throwable e) {
        super(msg, e);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
