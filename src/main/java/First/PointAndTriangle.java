package First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.pow;

public class PointAndTriangle {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int d = Integer.parseInt(reader.readLine());
            String[] str = reader.readLine().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            if (x >= 0 && y >= 0 && x + y <= d) {
                System.out.println(0);
            } else {
                TreeMap<Double, Integer> map = new TreeMap<>();
                double a = pow(x, 2) + pow(y, 2);
                double b = pow(x - d, 2) + pow(y, 2);
                double c = pow(x, 2) + pow(y - d, 2);

                if (!map.containsKey(a)) {
                    map.put(a, 1);
                }
                if (!map.containsKey(b)) {
                    map.put(b, 2);
                }
                if (!map.containsKey(c)) {
                    map.put(c, 3);
                }

                System.out.println(Collections.min(map.entrySet(), Map.Entry.comparingByKey()).getValue());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
