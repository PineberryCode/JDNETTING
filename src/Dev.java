
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Dev {

    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        List<String> list = new ArrayList<>();
        List<Integer> listHostRequired = new ArrayList<>();
        List<Integer> listQH = new ArrayList<>();
        List<Integer> listPrefix = new ArrayList<>();
        int k = 1;
        var str = Arrays.toString(args);

        if (str.contains("-ip") && str.contains("-qh")) {
            if (args[0] != null) {
                list.add(args[0]);
                System.out.println("Added IP address");
                /*for (int x=0; x<list.size(); x++) {
                    System.out.print(list.get(x));
                }*/
            }
            System.out.println("#### Write the quantity host by subnet ###");
            while (k <= Integer.parseInt(args[2])) {
                System.out.print("Subnet00"+k+"=> ");
                int qh = Integer.parseInt(scn.next());
                listQH.add(qh);
                k++;
            }

            Comparator<Integer> descendingComparator = (a, b) -> b.compareTo(a);
            Collections.sort(listQH, descendingComparator);

            for (int f=0; f < listQH.size(); f++) {
                System.out.println(listQH.get(f));
            }
            for (int o=0; o<listQH.size(); o++) {
                int i = 1;
                while (true) {
                    int formula = (int) (Math.pow(2, i) - 2);
                    if (formula >= listQH.get(o)) {
                        listHostRequired.add(formula);
                        
                        int prefix = 32 - i;
                        
                        listPrefix.add(prefix);
                        i = 1;
                        break;
                    }
                    i++;
                }
            }
            for (int z=0; z<listHostRequired.size(); z++) {
                System.out.println(listHostRequired.get(z));
            }
            for (int a=0; a<listPrefix.size(); a++) {
                int jump = (int) Math.pow(2, (32 - listPrefix.get(a)) - 8);
                System.out.println("JUMP "+jump);
            }
            scn.close();
        }
    }
}