package main.java.controller;

import main.java.entity.CategoryEntity;
import main.java.entity.GenreEntity;
import main.java.entity.LanguageEntity;
import main.java.entity.ProducerEntity;
import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.TitleModel;
import main.java.validators.CodeValidator;
import main.java.validators.NameValidator;

import java.util.List;

public class TitleController{
    private final TitleModel titleModel;

    /**
     * Construtor do controller
     */
    public TitleController() {
        titleModel = new TitleModel();
    }

    /**
     * Salva um registro no json
     *
     * @param code
     * @param title
     * @param subTitle
     * @param genre
     * @param languages
     * @param producer
     * @param category
     */
    public void save(
            int code,
            String title,
            String subTitle,
            GenreEntity genre,
            List<LanguageEntity> languages,
            ProducerEntity producer,
            CategoryEntity category
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), title);
        ValidateHelper.validate(new NameValidator(), subTitle);

        titleModel.save(code, title, subTitle, genre, languages, producer, category);
    }

    public String list() {
        return titleModel.list();
    }
}
