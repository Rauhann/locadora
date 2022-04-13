package main.java.controller;

import main.java.entity.ClientEntity;
import main.java.entity.LocationItemsEntity;
import main.java.entity.UserEntity;
import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.CategoryModel;
import main.java.model.LocationModel;
import main.java.model.TitleModel;
import main.java.validators.*;

import java.util.List;

public class LocationController {
    private final LocationModel locationModel;

    /**
     * Construtor do controller
     */
    public LocationController() {
        locationModel = new LocationModel();
    }

    /**
     * Salva uma locação no json
     *
     * @param code
     * @param user
     * @param client
     * @param items
     * @throws ValidatorException
     */
    public void save(
            int code,
            int user,
            int client,
            List<Integer> items
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);

        locationModel.save(code, user, client, items);
    }

    /**
     * Lista as locações cadastrados
     *
     * @return
     */
    public String list() {
        return locationModel.list();
    }
}
