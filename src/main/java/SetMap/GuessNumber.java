package SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GuessNumber {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            Set<Integer> guessSet = new HashSet<>();
            Set<Integer> src;

            for (int i = 1; i < n+1; i++) {
                guessSet.add(i);
            }

            String[] str;
            while ( !(str = reader.readLine().split(" "))[0].equals("HELP") ) {
                src = Arrays.stream(str)
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
                String answer = reader.readLine();

                switch (answer) {
                    case "YES" ->
                            guessSet.retainAll(src);

                    case "NO" ->
                            guessSet.removeAll(src);
                }
            }

            guessSet.stream().sorted().forEach(x -> System.out.print(x + " "));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
