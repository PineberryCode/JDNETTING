
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import command.commander;
import model.VLSM;

public class Dev implements commander {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        VLSM vlsm = new VLSM();
        int k = 1;
        System.out.println("##### WELCOME #####");
        String line = scn.nextLine();
        String[] parts = line.split("\\s+");

        if (!parts[0].equals(null)) {
            vlsm.listRedIP.add(parts[0]);
            System.out.println("Added IP address");
        }
        System.out.println("#### Write the quantity host by subnet ####");
        /*
         * Quantity host
         */
        while (k <= Integer.parseInt(parts[1])) {
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
        for (int f=0; f < vlsm.listQuantityHost.size(); f++) {
            System.out.println(vlsm.listQuantityHost.get(f));
        }
        /*
         * Prefix and Host Required
         */
        vlsm.PrefixAndHostRequired();

        for (int z=0; z<vlsm.listHostRequired.size(); z++) {
            System.out.println("Host required: "+vlsm.listHostRequired.get(z));
        }
        for (int h = 0; h<vlsm.listPrefix.size(); h++) {
            System.out.println("Prefix: "+vlsm.listPrefix.get(h));
        }
        /*
         * JUMPER
         */
        vlsm.Jumper();

        for (int hh=0; hh<vlsm.listJump.size(); hh++) {
            System.out.println("JUMP: "+vlsm.listJump.get(hh));
        }

        /*
         * Subred Mask
         */
        vlsm.FindSubredMask();

        for (int s=0; s<vlsm.listSubredMask.size(); s++) {
            System.out.println("Subred Mask: "+vlsm.listSubredMask.get(s));
        }

        /*
         * RED IP
         */
        vlsm.FindRedIP();

        for (int t=0;t<vlsm.listRedIP.size();t++) {
            System.out.println(vlsm.listRedIP.get(t));
        }

        scn.close();
    }
    
}