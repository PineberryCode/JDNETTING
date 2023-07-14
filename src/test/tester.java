package test;

import java.util.Arrays;
// Create own variable SO;
public class tester {
    public static void main (String[] args) {
        //String str = Arrays.toString(args);
        var str = Arrays.toString(args);
        if (str.contains("-qh")) {
            int i = 1;
            do {
                System.out.println(i);
                i++;
            } while (i <= Integer.parseInt(args[0]));
        }
    }
}
