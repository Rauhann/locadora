package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class PeriodValidator implements Validator<Integer> {
    /**
     * Valida periodo
     * @param code
     * @throws ValidatorException
     */
    @Override
    public void validate(Integer code) throws ValidatorException {
        if (code <= 0) {
            throw new ValidatorException("O período deve ser maior que zero");
        }
    }
}
