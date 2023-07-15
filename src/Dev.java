
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import command.commander;
import model.VLSM;

public class Dev implements commander {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        VLSM vlsm = new VLSM();
        /*List<String> listIPs = new ArrayList<>();
        List<Integer> listHostRequired = new ArrayList<>();
        List<Integer> listQH = new ArrayList<>();
        List<Integer> listPrefix = new ArrayList<>();
        List<Integer> jumpList = new ArrayList<>();*/
        int k = 1;
        //var str = Arrays.toString(args01);
        String line = scn.nextLine();
        String[] parts = line.split("\\s+");
        int jump = 0;
        if (line.contains(IP_ADDRESS) && line.contains(QUANTITY_HOST)) {
            if (parts[0] != null) {
                vlsm.listIPAddress.add(parts[0]);
                System.out.println("Added IP address");
                /*for (int x=0; x<list.size(); x++) {
                    System.out.print(list.get(x));
                }*/
            }
            System.out.println("#### Write the quantity host by subnet ####");
            /*
             * Quantity host
             */
            while (k <= Integer.parseInt(parts[2])) {
                System.out.print("Subnet "+k+"=> ");
                int qh = Integer.parseInt(scn.next());
                vlsm.listQuantityHost.add(qh);
                k++;
            }

            /* 
            Sort list
            */
            Comparator<Integer> descendingComparator = (a, b) -> b.compareTo(a);
            Collections.sort(vlsm.listQuantityHost, descendingComparator);

            for (int f=0; f < vlsm.listQuantityHost.size(); f++) {
                System.out.println(vlsm.listQuantityHost.get(f));
            }
            /*
             * Prefix and Host Required
             */
            for (int o=0; o<vlsm.listQuantityHost.size(); o++) {
                int i = 1;
                while (true) {
                    int formula = (int) (Math.pow(2, i) - 2);
                    if (formula >= vlsm.listQuantityHost.get(o)) {
                        vlsm.listHostRequired.add(formula);
                        
                        vlsm.listPrefix.add(32-i);
                        i = 1;
                        break;
                    }
                    i++;
                }
            }
            for (int z=0; z<vlsm.listHostRequired.size(); z++) {
                System.out.println(vlsm.listHostRequired.get(z));
            }

            /*
             * JUMPER
             */
            for (int a=0; a<vlsm.listPrefix.size(); a++) {
                jump = (int) Math.pow(2, (32 - vlsm.listPrefix.get(a)) - 8);
                vlsm.listJump.add(jump);
                System.out.println("JUMP "+vlsm.listPrefix.get(a));
            }

            
            scn.close();
        }
    }
}