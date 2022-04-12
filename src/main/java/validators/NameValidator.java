package main.java.validators;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class NameValidator implements Validator<String> {
    /**
     * Valida nome
     * @param name
     * @throws ValidatorException
     */
    @Override
    public void validate(String name) throws ValidatorException {
        if (name.length() > 50) {
            throw new ValidatorException("O nome deve ter no máximo 50 caracteres");
        }
    }
}
