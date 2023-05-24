package Linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BenchesInTheAtrium {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            int l = tmp[0], k = tmp[1];
            int[] coords = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int center = l / 2, i = 0;
            while (coords[i] >= center) {
                if (coords[i] == center && l % 2 == 1) {
                    System.out.println(coords[i]);
                } else {
                    System.out.println(coords[i-1] + " " + coords[i]);
                }
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
