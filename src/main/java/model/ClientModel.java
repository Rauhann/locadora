package main.java.model;

import com.google.gson.Gson;
import main.java.entity.ClientEntity;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientModel {
    private final DatabaseHelper db;
    private final String table = "clients";

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

        db.create(table, client);
    }

    /**
     * Printa na tela os usuarios disponiveis
     *
     * @return
     */
    public List<Integer> print() {
        JSONArray clients = db.get(table);
        Gson gson = new Gson();
        ClientEntity[] clientArray = gson.fromJson(String.valueOf(clients), ClientEntity[].class);
        List<Integer> codes = new ArrayList<>();

        for (ClientEntity client : clientArray) {
            System.out.println(client.getCode() + " - " + client.getName());
            codes.add(client.getCode());
        }

        return codes;
    }

    /**
     * Verifica se cliente esta na lista
     *
     * @param list
     * @param opt
     * @return
     */
    public boolean checkExistsInList(List<Integer> list, int opt) {
        return list.contains(opt);
    }
}
