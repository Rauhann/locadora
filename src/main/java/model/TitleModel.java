package main.java.model;

import main.java.entity.CategoryEntity;
import main.java.entity.GenreEntity;
import main.java.entity.LanguageEntity;
import main.java.entity.ProducerEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class TitleModel {
    private final DatabaseHelper db;
    private final String table = "titles";

    /**
     * Construtor da model
     */
    public TitleModel() {
        db = new DatabaseHelper();
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
    ) {
        JSONObject movie = new JSONObject();
        movie.put("code", code);
        movie.put("title", title);
        movie.put("subtitle", subTitle);
        movie.put("genre", genre.getName());
        JSONArray arrayLanguages = new JSONArray();

        for (LanguageEntity lang : languages) {
            arrayLanguages.add(lang.getName());
        }

        movie.put("languages", arrayLanguages);
        movie.put("producer", producer.getName());
        movie.put("category", category.getName());

        db.create(table, movie);
    }

    public String list() {
        return db.select(table);
    }
}
