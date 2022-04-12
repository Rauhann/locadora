package main.java.exceptions;

public class ValidatorException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Exceção de validação
     * @param message
     */
    public ValidatorException(String message) {
        super(message);
    }
}
