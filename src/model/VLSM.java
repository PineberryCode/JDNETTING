package model;

import java.util.ArrayList;
import java.util.List;

public class VLSM extends Subnetting {

    public List<Integer> listQuantityHost;
    public List<Integer> listHostRequired;
    public List<Integer> listPrefix;
    public List<Integer> listJump;
    
    public VLSM () {

        listRedIP = new ArrayList<>();
        listSubredMask = new ArrayList<>();
        listQuantityHost = new ArrayList<>();
        listHostRequired = new ArrayList<>();
        listPrefix = new ArrayList<>();
        listJump = new ArrayList<>();

    }

    public void PrefixAndHostRequired () {
        for (int o=0; o<listQuantityHost.size(); o++) {
            int i = 1;
            while (true) {
                int formula = (int) (Math.pow(2, i) - 2);
                if (formula >= listQuantityHost.get(o)) {
                    listHostRequired.add(formula);
                    
                    listPrefix.add(32 - i);
                    i = 1;
                    break;
                }
                i++;
            }
        }
    }

    public void Jumper () {
        for (int x = 0; x < listPrefix.size(); x++) {
            int countZeros = 1;
            StringBuilder strBuilder = new StringBuilder();
            int i = 1;
            while (i <= 32) {
                if (strBuilder.length() <= listPrefix.get(x)) {
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
                        }
                    }
                    break;
                }
                
            }
            listJump.add((int) Math.pow(2,countZeros));
        }
    }

    public void FindSubredMask () {
        for (int q = 0; q < listPrefix.size(); q++) {
            int ll = 1;
            StringBuilder strBuilder = new StringBuilder();
            while (ll <= 32) {
                if (strBuilder.length() < listPrefix.get(q)) {
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
            listSubredMask.add(subredMask);
        }
    }

    public void FindRedIP () {
        int w = 0;
        while (w < listSubredMask.size()) {
            String redIP = listRedIP.get(w);
            String[] splitRedIP = redIP.split("\\.");
            String[] splitSubredMask = listSubredMask.get(w).split("\\.");
            for (int i = 0; i < splitSubredMask.length; i++) {
                if (!splitSubredMask[i].contains("255")) {
                    int octectRed = Integer.parseInt(splitRedIP[i]);
                    int jumper = listJump.get(w);
                    int octectModified = octectRed + jumper;
                    splitRedIP[i] = String.valueOf(octectModified);
                    break;
                }
            }
            if (w < listSubredMask.size()-1) {
                String newNet = String.join(".",splitRedIP);
                listRedIP.add(newNet);
            }
            w++;
        }
    }

    /*
     * Table
     */
    public void Overview () {
        String[][] data = new String[listRedIP.size()+1][6];
        data[0] = new String[]{"Subnet","Host","Host Required","Red IP","Prefix","Subred Mask"};
        int num=1;
        for (int k = 0; k < listRedIP.size(); k++) {
            data[k+1][0] = "Subnet "+num++;
            data[k+1][1] = listQuantityHost.get(k).toString();
            data[k+1][2] = listHostRequired.get(k).toString();
            data[k+1][3] = listRedIP.get(k).toString();
            data[k+1][4] = listPrefix.get(k).toString();
            data[k+1][5] = listSubredMask.get(k).toString();
        }

        int[] columnWidths = {10,5,13,15,6,15};
        printTable(data, columnWidths);
    }

    private String paddingRight (String cell, int width) {
        return String.format("%-"+width+"s",cell);
    }

    private void printLine (int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printTable (String[][] data, int[] columnWidths) {
        int totalWidth = 1;
        for (int w : columnWidths) {
            totalWidth += w + 3;
        }

        printLine(totalWidth);

        for (int i = 0; i < data.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < data[i].length; j++) {
                String cell = data[i][j];
                int width = columnWidths[j];
                System.out.print(paddingRight(cell, width)+" | ");
            }
            System.out.println();

            if (i == 0) {
                printLine(totalWidth);
            }
        }
        printLine(totalWidth);
    }

}
