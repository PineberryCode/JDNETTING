package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Create own variable SO;
public class tester {
    
    public static void main (String[] args) {
        // 8 8 8 8
        List<String> list = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        int x = 19;
        int i = 1;
        while (i <= x) {
            String uno = "1";
            if (i % 8 == 0) {
                strBuilder.append(".");    
            }
            strBuilder.append(uno);
            i++;
        }
        while (x < 32) {
            String cero = "0";
            if (x % 8 == 0) {
                strBuilder.append(".");
            }
            strBuilder.append(cero);
            x++;
        }
        System.out.println(strBuilder);
        
    }
}
