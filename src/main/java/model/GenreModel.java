package main.java.model;

import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

public class GenreModel {
    private final DatabaseHelper db;

    /**
     * Construtor da model
     */
    public GenreModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva um registro no json
     * @param code
     * @param name
     */
    public void save(int code, String name) {
        JSONObject genre = new JSONObject();
        genre.put("code", code);
        genre.put("name", name);

        db.create("genres", genre);
    }
}
