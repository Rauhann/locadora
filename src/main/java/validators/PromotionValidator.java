package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class PromotionValidator implements Validator<Boolean> {
    /**
     * Valida se o item é promocao
     * @param promotion
     * @throws ValidatorException
     */
    @Override
    public void validate(Boolean promotion) throws ValidatorException {
        if (promotion != true || promotion != false) {
            throw new ValidatorException("O período deve true ou false");
        }
    }
}
