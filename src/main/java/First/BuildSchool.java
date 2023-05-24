package First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildSchool {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] coords = reader.readLine().split(" ");

            System.out.println(coords[n / 2]);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
