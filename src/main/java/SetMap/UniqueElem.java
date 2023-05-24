package SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class UniqueElem {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] seq = reader.readLine().split(" ");
            LinkedHashMap<String, Integer> numbers = new LinkedHashMap<>();

            for (var elem : seq) {
                if ( !numbers.containsKey(elem) ) {
                    numbers.put(elem, 1);
                } else {
                    numbers.compute(elem, (k, v) -> v+1);
                }
            }

            numbers.forEach((k, v) -> {
                if (v == 1) {
                    System.out.print(k + " ");
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
