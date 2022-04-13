package main.java.model;

import main.java.entity.ClientEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

import java.util.Objects;

public class ClientModel {
    private final DatabaseHelper db;

    /**
     * Construtor da model
     */
    public ClientModel() {
        db = new DatabaseHelper();
    }

    /**
     * Registra um cliente no json
     *
     * @param code
     * @param name
     * @param cpf
     * @param parentClient
     */
    public void save(
            int code,
            String name,
            String cpf,
            ClientEntity parentClient
    ) {
        JSONObject client = new JSONObject();
        client.put("code", code);
        client.put("name", name);
        client.put("cpf", cpf);

        String checkName = "";
        if (!Objects.equals(parentClient.getName(), "")) {
            checkName = parentClient.getName();
        }
        client.put("parent_client", checkName);

        db.create("clients", client);
    }
}
