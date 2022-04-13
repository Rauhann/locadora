package main.java.controller;

import main.java.entity.ClientEntity;
import main.java.exceptions.ValidatorException;
import main.java.helpers.ValidateHelper;
import main.java.model.ClientModel;
import main.java.validators.*;

public class ClientController {
    private final ClientModel clientModel;

    /**
     * Construtor do controller
     */
    public ClientController() {
        clientModel = new ClientModel();
    }

    /**
     * Salva um registro de cliente no json
     * @param code
     * @param name
     * @param cpf
     * @param parentClient
     * @throws ValidatorException
     */
    public void save(
            int code,
            String name,
            String cpf,
            ClientEntity parentClient
    ) throws ValidatorException {
        ValidateHelper.validate(new CodeValidator(), code);
        ValidateHelper.validate(new NameValidator(), name);
        ValidateHelper.validate(new CpfValidator(), cpf);

        clientModel.save(code, name, cpf, parentClient);
    }
}
