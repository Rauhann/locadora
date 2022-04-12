package main.java.controller;

import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.CategoryModel;
import main.java.model.GenreModel;
import main.java.validators.*;

public class CategoryController {
    private final CategoryModel categoryModel;

    /**
     * Construtor do controller
     */
    public CategoryController() {
        categoryModel = new CategoryModel();
    }

    /**
     * Valida e cria uma categoria no json
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
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);
        ValidateHelper.validate(new ValueValidator(), value);
        ValidateHelper.validate(new PeriodValidator(), period);
        ValidateHelper.validate(new PromotionValidator(), indicatePromotion);
        ValidateHelper.validate(new PromotionPeriodValidator(), promotionPeriod);

        categoryModel.save(code, name, value, period, indicatePromotion, promotionPeriod);
    }
}
