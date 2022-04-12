package main.java.interfaces;

import main.java.exceptions.ValidatorException;

/**
 * Interface default para validação de campos
 * @param <T>
 */
public interface Validator<T> {
    void validate(T object) throws ValidatorException;
}
