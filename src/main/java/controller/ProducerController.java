package main.java.controller;

import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.GenreModel;
import main.java.model.ProducerModel;
import main.java.validators.CodeValidator;
import main.java.validators.NameValidator;

public class ProducerController {
    private final ProducerModel producerModel;

    /**
     * Construtor do controller
     */
    public ProducerController() {
        producerModel = new ProducerModel();
    }

    /**
     * Valida e cria uma produtora
     *
     * @param code
     * @param name
     */
    public void save(
            int code,
            String name
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);

        producerModel.save(code, name);
    }
}
