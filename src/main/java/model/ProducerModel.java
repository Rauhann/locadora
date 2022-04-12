package main.java.model;

import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

public class ProducerModel {
    private final DatabaseHelper db;

    /**
     * Construtor da model
     */
    public ProducerModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva um registro no json
     * @param code
     * @param name
     */
    public void save(int code, String name) {
        JSONObject language = new JSONObject();
        language.put("code", code);
        language.put("name", name);

        db.create("producers", language);
    }
}
