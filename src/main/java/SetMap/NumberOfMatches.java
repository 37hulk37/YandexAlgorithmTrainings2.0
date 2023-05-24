package SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class NumberOfMatches {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] a = reader.readLine().split(" ");
            HashSet<String> b = new HashSet<>(Arrays.asList(reader.readLine().split(" ")));

            int n = 0;
            for (var aa : a) {
                n = b.contains(aa) ? n + 1 : n;
            }

            System.out.println(n);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
