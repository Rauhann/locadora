package main.java.enums;

public enum LanguageEnum {
    PORTUGUES,
    INGLES,
    ESPANHOL,
    FRANCES,
    ALEMAO,
    ITALIANO;

    public static boolean checkIfExists(String item) {
        try {
            LanguageEnum.valueOf(item);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
