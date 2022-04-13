package main.java.controller;

import main.java.enums.GenreEnum;
import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.GenreModel;
import main.java.validators.CodeValidator;
import main.java.validators.NameValidator;

public class GenreController {
    private final GenreModel genreModel;

    /**
     * Construtor do controller
     */
    public GenreController() {
        genreModel = new GenreModel();
    }

    public void save(
            int code,
            String name
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);

        if (!GenreEnum.checkIfExists(name)) {
            genreModel.save(code, name);
        }
    }
}
