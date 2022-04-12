package main.java.controller;

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

    public void save(int code, String name) {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);

        genreModel.save(code, name);
    }
}
