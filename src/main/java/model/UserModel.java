package main.java.model;

import main.java.entity.ClientEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

import java.util.Objects;

public class UserModel {
    private final DatabaseHelper db;

    /**
     * Construtor da model
     */
    public UserModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva um registro no json
     * @param code
     * @param name
     * @param login
     * @param password
     * @param status
     */
    public void save(
            int code,
            String name,
            String login,
            String password,
            boolean status
    ) {
        JSONObject user = new JSONObject();
        user.put("code", code);
        user.put("name", name);
        user.put("login", login);
        user.put("password", password);
        user.put("status", status);

        db.create("users", user);
    }
}
