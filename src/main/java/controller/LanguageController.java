package main.java.controller;

import main.java.entity.LanguageEntity;
import main.java.helpers.ValidateHelper;
import main.java.model.LanguageModel;
import main.java.validators.CodeValidator;
import main.java.validators.NameValidator;

import java.util.List;

public class LanguageController {
    private final LanguageModel languageModel;

    /**
     * Construtor do controller
     */
    public LanguageController() {
        languageModel = new LanguageModel();
    }

    /**
     * Valida e cria um idioma
     * @param code
     * @param name
     */
    public void save(int code, String name) {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);

        languageModel.save(code, name);
    }

    /**
     * Cria e adiciona idiomas a uma lista
     * @param languages
     * @param languageCode
     * @param languageName
     * @return
     */
    public List<LanguageEntity> addLanguage(List<LanguageEntity> languages, int languageCode, String languageName){
        return languageModel.addLanguage(languages, languageCode, languageName);
    }
}
