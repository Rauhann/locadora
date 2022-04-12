package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class PromotionValidator implements Validator<Integer> {
    /**
     * Valida se o item é promocao
     * @param promotion
     * @throws ValidatorException
     */
    @Override
    public void validate(Integer promotion) throws ValidatorException {
        if (promotion != 1 && promotion != 0) {
            throw new ValidatorException("O período deve 1 ou 0");
        }
    }
}
