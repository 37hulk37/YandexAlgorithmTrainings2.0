package SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CarNumbers {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n, m;
            n = Integer.parseInt(reader.readLine());

            List<Character>[] charList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                String pred = reader.readLine();

                charList[i] = new ArrayList<>();

                charList[i].addAll(pred
                        .chars()
                        .mapToObj(ch -> (char) ch)
                        .toList()
                );
            }

            m = Integer.parseInt(reader.readLine());
            Set<Character>[] carNumbers = new HashSet[m];
            Map<Integer, Integer> carNumberScores = new HashMap<>();
            List<String> carNumbersOutput = new ArrayList<>();
            String carNumber;
            for (int i = 0; i < m; i++) {
                carNumber = reader.readLine();

                carNumbers[i] = new HashSet<>();

                carNumbersOutput.add(carNumber);

                carNumbers[i].addAll(carNumber
                        .chars()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.toSet())
                );

                carNumberScores.put(i, 0);
            }

            for (List<Character> chars : charList) {
                int j = 0;
                for (Set<Character> setNumber : carNumbers) {
                    for (char ch : chars) {
                        if (setNumber.contains(ch)) {
                            carNumberScores.compute(j, (k, v) -> v + 1);
                        }
                    }
                    if (carNumberScores.get(j) < chars.size()) {
                        carNumberScores.put(j, 0);
                    }
                    j++;
                }
            }

            var maxScore = carNumberScores.entrySet()
                            .stream().max(Map.Entry.comparingByValue()
                    ).get().getValue();


            int k = 0;
            var out = new ArrayList<>();
            for (var entry : carNumberScores.entrySet()) {
                String number = carNumbersOutput.get(k);
                if (entry.getValue().equals(maxScore)) {
                    out.add(number);
                }
                k++;
            }
            out.forEach(System.out::println);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
