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

    public static int getLevenshteinDistance(String a, String b) {
        int[][] matrix = new int[b.length() + 1][a.length() + 1];

        // Initialize the matrix
        for (int i = 0; i <= b.length(); i++) {
            matrix[i][0] = i;
        }
        for (int j = 0; j <= a.length(); j++) {
            matrix[0][j] = j;
        }

        // Calculate distances
        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {
                if (b.charAt(i - 1) == a.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, // Substitution
                            Math.min(matrix[i][j - 1] + 1, // Insertion
                                    matrix[i - 1][j] + 1)); // Deletion
                }
            }
        }

        return matrix[b.length()][a.length()];
    }
}
