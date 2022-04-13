package main.java.model;

import com.google.gson.Gson;
import main.java.entity.*;
import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class LocationModel {
    private final DatabaseHelper db;
    private final String table = "locations";

    /**
     * Construtor da model
     */
    public LocationModel() {
        db = new DatabaseHelper();
    }

    public void save(
            int code,
            int user,
            int client,
            List<Integer> titles
    ) {
        JSONObject location = new JSONObject();
        location.put("code", code);
        location.put("user", user);
        location.put("client", client);
        List<String> addTitles = new ArrayList<>();

        for (Integer title : titles) {
            JSONArray item = db.searchByCode("titles", title);
            if (item.size() > 0) {
                JSONObject rec = (JSONObject) item.get(0);
                String getTitle = (String) rec.get("title");
                addTitles.add(getTitle);
            }
        }

        // Os dias devem ser pegos de algum lugar
        location.put("devolution_date", addDays(3));
        db.create(table, location);
    }

    /**
     * Lista as locações cadastrados no json
     *
     * @return
     */
    public String list() {
        return db.select(table);
    }

    private String addDays(int days) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, days);
        dt = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(dt);
    }
}
