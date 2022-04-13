package main.java.controller;

import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.UserModel;
import main.java.validators.CodeValidator;
import main.java.validators.NameValidator;

import java.util.List;

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
     *
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

    /**
     * Lista os usuarios cadastrados formatados para locação
     *
     * @return
     */
    public List<Integer> print() {
        return userModel.print();
    }

    /**
     * Verifica se usuario esta na lista
     *
     * @param list
     * @param opt
     * @return
     */
    public boolean checkExistsInList(List<Integer> list, int opt) {
        return userModel.checkExistsInList(list, opt);
    }
}
