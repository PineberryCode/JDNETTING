package test;

import java.util.Arrays;
import java.util.Scanner;

public class testing {
    public static void splitClonned(String str) {
        char[] c = str.toCharArray();
        for (char x : c) {
            String sh = String.valueOf(x);
            int num = Integer.parseInt(sh);
            if (num <= 2 && num >= 0) {
                System.out.print(num+" ");
            }
        }
    }
    public static void join(String str) {
        char[] c = str.toCharArray();
        String inner = "";
        for (int i=0; i<c.length; i++) {
            String x = String.valueOf(c[i]);
            //int num = Integer.parseInt(inner);
            inner+=x;
        }
        System.out.println("i => "+inner);
    }
    public static void main(String[] args) {
        String[] array = new String[1];
        String binary = String.format("%8s",Integer.toBinaryString(252))
                .replace(' ','0');
        //if ()
        array[0] = binary;
        for (String x : array) {
            System.out.println(x);
        }
    }
}
