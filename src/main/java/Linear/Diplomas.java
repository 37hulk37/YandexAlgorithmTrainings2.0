package Linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Diplomas {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            int sum = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .limit(n-1)
                    .sum();

            System.out.println(sum);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
