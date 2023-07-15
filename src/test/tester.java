package test;

import java.util.ArrayList;
import java.util.List;
// Create own variable SO;
public class tester {
    
    public static void main (String[] args) {
        int x = 19;
        String ip = "13.14.0.0";
        String[] parts = ip.split("\\.");
        String identity = "";
        int i = 0;
        int jump = (int) Math.pow(2,(32 - x) - 8);
        System.out.println(jump);
        System.out.println(ip);
        while (i < parts.length) {
            identity = parts[i];
            if (identity.equals("0")) {
                parts[i] = String.valueOf(jump);
                break;
            }
            i++;
        }

        for (int u=0; u<parts.length; u++) {
            System.out.println("index = > "+parts[u]);
        }
    }
}
