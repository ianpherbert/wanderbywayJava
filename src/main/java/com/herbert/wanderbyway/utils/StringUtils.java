package com.herbert.wanderbyway.utils;
import java.text.Normalizer;

public class StringUtils {

    public static String removeAccentsAndSpecialCharacters(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        String accentRemoved = normalized.replaceAll("\\p{M}", "");
        return accentRemoved.replaceAll("[^a-zA-Z0-9\\s]", "") // Keep alphanumeric characters and spaces
                .replaceAll("\\s+", "-") // Replace one or more spaces with a single dash
                .toLowerCase(); // Convert to lowercase
    }
}
