package main.java.helpers;

import java.text.Normalizer;

public class StringHelper {
    public static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
