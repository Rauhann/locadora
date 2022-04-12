package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class CodeValidator implements Validator<Integer> {
    /**
     * Valida código
     * @param code
     * @throws ValidatorException
     */
    @Override
    public void validate(Integer code) throws ValidatorException {
        if (code <= 0) {
            throw new ValidatorException("O código deve ser maior que zero");
        }
    }
}
