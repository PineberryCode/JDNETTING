
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
        String line = scn.nextLine();
        String[] parts = line.split("\\s+");

        System.out.println("##### WELCOME #####");

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
                    
                    vlsm.listPrefix.add(32 - i);
                    i = 1;
                    break;
                }
                i++;
            }
        }
        for (int z=0; z<vlsm.listHostRequired.size(); z++) {
            System.out.println("Host required: "+vlsm.listHostRequired.get(z));
        }
        /*
         * JUMPER
         */
        
        for (int x = 0; x < vlsm.listPrefix.size(); x++) {
            int countZeros = 1;
            StringBuilder strBuilder = new StringBuilder();
            int i = 1;
            while (i <= 32) {
                if (strBuilder.length() <= vlsm.listPrefix.get(x)) {
                    strBuilder.append("1");
                } else {
                    strBuilder.append("0");
                }
                i++;
            }
            strBuilder.insert(8, '.');
            strBuilder.insert(17, '.');
            strBuilder.insert(26, '.');
            String[] octects = strBuilder.toString().split("\\.");
            
            for (int g = 0; g < octects.length; g++) {
                if (octects[g].contains("1") && octects[g].contains("0")) {
                    for (int j = 0; j < octects[g].length();j++) {
                        if (octects[g].charAt(j) == '0') {
                            countZeros++;
                            System.out.println(countZeros);
                        }
                    }
                    break;  
                }
                
            }
            vlsm.listJump.add((int) Math.pow(2,countZeros));
            //countZeros = 1;
        }

        for (int hh=0; hh<vlsm.listJump.size(); hh++) {
            System.out.println("JUMP: "+vlsm.listJump.get(hh));
        }

        /*
         * Subred Mask
         */
        for (int q = 0; q < vlsm.listPrefix.size(); q++) {
            int ll = 1;
            StringBuilder strBuilder = new StringBuilder();
            while (ll <= 32) {
                if (strBuilder.length() <= vlsm.listPrefix.get(q)) {
                    strBuilder.append("1");
                } else {
                    strBuilder.append("0");
                }
                ll++;
            }
            strBuilder.insert(8, '.');
            strBuilder.insert(17, '.');
            strBuilder.insert(26, '.');
            String[] splitSubredZeroAndOne = strBuilder.toString().split("\\.");
            int firstOctetValue = Integer
            .parseInt(splitSubredZeroAndOne[0],2);
            int secondOctetValue = Integer
            .parseInt(splitSubredZeroAndOne[1], 2);
            int thirdOctetValue = Integer
            .parseInt(splitSubredZeroAndOne[2], 2);
            int fourthOctetValue = Integer.
            parseInt(splitSubredZeroAndOne[3], 2);
            String subredMask = firstOctetValue+"."+secondOctetValue+"."
                                +thirdOctetValue+"."+fourthOctetValue;
            vlsm.listSubredMask.add(subredMask);
        }

        for (int s=0; s<vlsm.listSubredMask.size(); s++) {
            System.out.println("Subred Mask: "+vlsm.listSubredMask.get(s));
        }

        String ipAddressConverted = "";
        for (int hh=0;hh<vlsm.listRedIP.size();hh++){
            //System.out.println(vlsm.listIPAddress.get(hh));
            String ipAddress = vlsm.listRedIP.get(hh);
            char[] c = ipAddress.toCharArray();
            char[] x = c.clone();
            ipAddressConverted = String.valueOf(x);
        }
        vlsm.listRedIP.add(ipAddressConverted);
        /*for (int t=0;t<vlsm.listRedIP.size();t++) {
            System.out.println(vlsm.listRedIP.get(t));
        }*/
        
        scn.close();
    }
    
}