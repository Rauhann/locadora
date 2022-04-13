package main.java.model;

import com.google.gson.Gson;
import main.java.entity.UserEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserModel {
    private final DatabaseHelper db;
    private final String table = "users";

    /**
     * Construtor da model
     */
    public UserModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva um registro no json
     *
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

        db.create(table, user);
    }

    /**
     * Printa na tela os usuarios disponiveis
     *
     * @return
     */
    public List<Integer> print() {
        JSONArray users = db.get(table);
        Gson gson = new Gson();
        UserEntity[] userArray = gson.fromJson(String.valueOf(users), UserEntity[].class);
        List<Integer> codes = new ArrayList<>();

        for (UserEntity user : userArray) {
            System.out.println(user.getCode() + " - " + user.getName());
            codes.add(user.getCode());
        }

        return codes;
    }

    /**
     * Verifica se usuario esta na lista
     *
     * @param list
     * @param opt
     * @return
     */
    public boolean checkExistsInList(List<Integer> list, int opt) {
        return list.contains(opt);
    }
}
