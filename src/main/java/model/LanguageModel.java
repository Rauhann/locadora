package main.java.model;

import main.java.entity.LanguageEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

import java.util.List;

public class LanguageModel {
    private final DatabaseHelper db;

    /**
     * Construtor para a entidade
     */
    public LanguageModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva no json um idioma
     *
     * @param code
     * @param name
     */
    public void save(
            int code,
            String name
    ) {
        JSONObject language = new JSONObject();
        language.put("code", code);
        language.put("name", name);

        db.create("languages", language);
    }

    /**
     * Cria e retorna uma lista de idiomas
     *
     * @param languages
     * @param languageCode
     * @param languageName
     * @return
     */
    public List<LanguageEntity> addLanguage(
            List<LanguageEntity> languages,
            int languageCode,
            String languageName
    ) {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setCode(languageCode);
        languageEntity.setName(languageName);
        languages.add(languageEntity);

        return languages;
    }
}
