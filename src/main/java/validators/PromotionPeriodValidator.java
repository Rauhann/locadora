package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class PromotionPeriodValidator implements Validator<Integer> {
    /**
     * Valida periodo promocional
     * @param code
     * @throws ValidatorException
     */
    @Override
    public void validate(Integer code) throws ValidatorException {
        if (code < 0) {
            throw new ValidatorException("O período de promoção deve ser maior ou igual a zero");
        }
    }
}
