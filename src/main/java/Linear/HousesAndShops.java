package Linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class HousesAndShops {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] coords = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < coords.length; i++) {
                if (coords[i] == 2) {
                    list.add(i);
                }
            }

            int l = -10, r = list.pollFirst(), dist = 0;
            for (int i = 0; i < coords.length; i++) {
                if (coords[i] == 1) {
                    if (l >= 0 && r < coords.length) {
                        dist = max(dist, min(abs(l - i), abs(r - i)));
                    } else if (r >= coords.length) {
                        dist = max(dist, abs(l - i));
                    } else {
                        dist = max(dist, abs(r - i));
                    }
                } else if ((coords[i] == 2 || i > r) && !list.isEmpty()) {
                    l = r;
                    r = list.pollFirst();
                }
            }

            System.out.println(dist);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
