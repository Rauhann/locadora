package main.java.helpers;

import main.java.exceptions.ValidatorException;
import main.java.interfaces.Validator;

public class ValidateHelper {
    public static <T> void validate(Validator<T> validator, T object) {
        try {
            validator.validate(object);
        } catch (ValidatorException e) {
            System.err.println(e.getMessage());
        }
    }
}
