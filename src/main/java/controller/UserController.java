package main.java.controller;

import main.java.entity.ClientEntity;
import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.UserModel;
import main.java.validators.CodeValidator;
import main.java.validators.CpfValidator;
import main.java.validators.NameValidator;

public class UserController {
    private final UserModel userModel;

    /**
     * Construtor do controller
     */
    public UserController() {
        userModel = new UserModel();
    }

    /**
     * Salva um registro no json
     * @param code
     * @param name
     * @param login
     * @param password
     * @param status
     * @throws ValidatorException
     */
    public void save(
            int code,
            String name,
            String login,
            String password,
            boolean status
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);
        ValidateHelper.validate(new NameValidator(), login);
        ValidateHelper.validate(new NameValidator(), password);

        userModel.save(code, name, login, password, status);
    }
}
