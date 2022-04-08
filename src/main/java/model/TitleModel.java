package main.java.model;

import main.java.entity.LanguageEntity;

import java.util.List;

public class TitleModel {
    private final List<LanguageEntity> languages;

    public TitleModel(List<LanguageEntity> languages) {
        this.languages = languages;
    }

    public void addLanguage(LanguageEntity language){
        this.languages.add(language);
    }

    public void removeLanguage(LanguageEntity language){
        this.languages.remove(language);
    }
}
