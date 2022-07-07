
package application.dbscan_anasimad;

import java.util.Arrays;

/* StringDistances inclus les méthodes nécessaires pour le calcul de la distance levenshtein */
public class StringDistances {

    public static int cout_de_remplacement(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }

    static int calculatelv(String x, String y) {
    int[][] dp = new int[x.length() + 1][y.length() + 1];
 
    for (int i = 0; i <= x.length(); i++) {
        for (int j = 0; j <= y.length(); j++) {
            if (i == 0) {
                dp[i][j] = j;
            }
            else if (j == 0) {
                dp[i][j] = i;
            }
            else {
                dp[i][j] = min(dp[i - 1][j - 1] 
                 + cout_de_remplacement(x.charAt(i - 1), y.charAt(j - 1)),
                  dp[i - 1][j] + 1, 
                  dp[i][j - 1] + 1);
            }
        }
    }
 
    return dp[x.length()][y.length()];
}


    
}
