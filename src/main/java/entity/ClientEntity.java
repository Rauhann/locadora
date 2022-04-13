package main.java.entity;

public class ClientEntity {
    private int code;
    private String name;
    private String cpf;
    private ClientEntity parentClient;

    public ClientEntity() {
    }

    public ClientEntity(int code, String name, String cpf, ClientEntity parentClient) {
        this.code = code;
        this.name = name;
        this.cpf = cpf;
        this.parentClient = parentClient;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ClientEntity getParentClient() {
        return parentClient;
    }

    public void setParentClient(ClientEntity parentClient) {
        this.parentClient = parentClient;
    }
}
