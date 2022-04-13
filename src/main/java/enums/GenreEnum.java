package main.java.enums;

public enum GenreEnum {
    AVENTURA,
    DRAMA,
    TERROR,
    ACAO,
    DESENHO,
    FICCAO,
    SUSPENSE;

    public static boolean checkIfExists(String item) {
        try {
            GenreEnum.valueOf(item);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
