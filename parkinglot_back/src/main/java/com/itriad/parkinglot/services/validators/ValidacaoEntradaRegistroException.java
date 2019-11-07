package com.itriad.parkinglot.services.validators;

public class ValidacaoEntradaRegistroException extends RuntimeException {
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    public ValidacaoEntradaRegistroException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ValidacaoEntradaRegistroException(String msg) {
        super(msg);
    }
}