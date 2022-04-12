package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class ValueValidator implements Validator<Double> {
    /**
     * Valida um valor double
     * @param value
     * @throws ValidatorException
     */
    @Override
    public void validate(Double value) throws ValidatorException {
        if (value <= 0) {
            throw new ValidatorException("O valor deve ser maior do que zero");
        }
    }
}
