
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import model.VLSM;

public class Dev {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        VLSM vlsm = new VLSM();
        int k = 1;
        System.out.println("##### WELCOME TO JDNETTING #####");

        if (!args[0].equals(null)) {
            vlsm.listRedIP.add(args[0]);
            System.out.println("Red IP added");
        }
        System.out.println("#### Write the quantity host by subnet ####");
        
        /*
         * Quantity host
         */
        while (k <= Integer.parseInt(args[1])) {
            System.out.print("Subnet "+k+"=> ");
            int qh = Integer.parseInt(scn.next());
            vlsm.listQuantityHost.add(qh);
            k++;
        }

        /*
         * Sort List
         */
        Comparator<Integer> descendingComparator = (a, b) -> b.compareTo(a);
        Collections.sort(vlsm.listQuantityHost, descendingComparator);

        /*
         * Prefix and Host Required
         */
        vlsm.PrefixAndHostRequired();

        /*
         * JUMPER
         */
        vlsm.Jumper();

        /*
         * Subred Mask
         */
        vlsm.FindSubredMask();

        /*
         * RED IP
         */
        vlsm.FindRedIP();

        /*
         * Overview O.O
         */
        vlsm.Overview();

        scn.close();
    }
    
}