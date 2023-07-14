
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dev {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int k = 1;
        var str = Arrays.toString(args);

        if (str.contains("-ip") && str.contains("-qh")) {
            list.add(args[0]);
            if (args[0] != null) {
                System.out.println("Added IP address");
                for (int x=0; x<list.size(); x++) {
                    System.out.print(list.get(x));
                }
            }
            do {
                System.out.print(k+" ");
                k++;
            } while (k <= Integer.parseInt(args[2]));
        }
    }
}