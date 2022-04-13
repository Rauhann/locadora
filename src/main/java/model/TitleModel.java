package main.java.model;

import com.google.gson.Gson;
import main.java.entity.*;
import main.java.entity.TitleEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
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

    /**
     * Lista os filmes cadastrados no json
     *
     * @return
     */
    public String list() {
        return db.select(table);
    }


    public List<Integer> print() {
        JSONArray titles = db.get(table);
        Gson gson = new Gson();
        TitleEntity[] titleArray = gson.fromJson(String.valueOf(titles), TitleEntity[].class);
        List<Integer> codes = new ArrayList<>();

        for (TitleEntity title : titleArray) {
            System.out.println(title.getCode() + " - " + title.getTitle());
            codes.add(title.getCode());
        }

        return codes;
    }

    /**
     * Verifica se o filme esta na lista
     * @param list
     * @param opt
     * @return
     */
    public boolean checkExistsInList(List<Integer> list, int opt) {
        return list.contains(opt);
    }
}
