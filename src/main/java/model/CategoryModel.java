package main.java.model;

import main.java.helpers.DatabaseHelper;
import org.json.simple.JSONObject;

public class CategoryModel {
    private final DatabaseHelper db;

    /**
     * Construtor da model
     */
    public CategoryModel() {
        db = new DatabaseHelper();
    }

    /**
     * Salva um registro no json
     *
     * @param code
     * @param name
     * @param value
     * @param period
     * @param indicatePromotion
     * @param promotionPeriod
     */
    public void save(
            int code,
            String name,
            double value,
            int period,
            int indicatePromotion,
            int promotionPeriod
    ) {
        JSONObject category = new JSONObject();
        category.put("code", code);
        category.put("name", name);
        category.put("value", value);
        category.put("period", period);
        category.put("indicate_promotion", indicatePromotion);
        category.put("promotion_period", promotionPeriod);

        db.create("categories", category);
    }
}
