package main.java.helpers;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

public class DatabaseHelper {
    private static final String DATABASE = System.getProperty("user.dir") + File.separator + "database" + File.separator;

    /**
     * Helper para listar registros no json
     * @param table
     * @return
     */
    public JSONArray get(String table) {
        JSONArray jsonArray = new JSONArray();

        try {
            JSONObject ob = (JSONObject) new JSONParser().parse(new FileReader(DATABASE + table + ".json"));
            jsonArray = (JSONArray) ob.get("data");
            return jsonArray;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    /**
     * Helper para adicionar registro no respectivo json
     * @param table
     * @param data
     */
    public void create(String table, JSONObject data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONArray jsonArray = select(table);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATABASE + table + ".json"))) {
            data.put("created_at", sdf.format(new Date()));
            data.put("updated_at", sdf.format(new Date()));
            jsonArray.add(data);
            JSONObject newOb = new JSONObject();
            newOb.put("data", jsonArray);
            bw.write(newOb.toJSONString());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Função auxiliar de retorno de registros json
     * @param table
     * @return
     */
    private JSONArray select(String table) {
        return get(table);
    }
}
