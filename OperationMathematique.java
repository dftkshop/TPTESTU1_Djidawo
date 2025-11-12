import java.util.Arrays;
import java.util.Collections;

public class OperationMathematique {


    public boolean estPositif(int n) {
        return n >= 0;
    }
    public int factoriel(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }
    public Integer[] trier(Integer[] liste) {
        Arrays.sort(liste, Collections.reverseOrder());
        return liste;
    }
    public double maxNumba(double[] valeurs) {
        return Arrays.stream(valeurs).max().orElse(Double.NaN);
    }








}
