package Controller;

import java.util.Scanner;

import Process.DefaultClass;
import Process.DefaultText;
import Process.SubnetList;

public class Methods extends DefaultText implements DefaultClass {
    public static int[] myArray;
    public static int[] myArrayHost;
    public static int[] myArrayExponent;
    public static String[] myArrayDefaultSubnet;
    public static String[] myArrayBinary;
    public SubnetList subnetList;
    public DefaultText dText;

    public void WhileAndSort(int x) {
        Scanner scn = new Scanner(System.in);
        int j = 0;
        int temp;
        myArray = new int[x];
        while (j < x) {
            System.out.print("SUBNET00"+(j+1)+" => ");
            int i = scn.nextInt();
            myArray[j] = i;
            j++;
        }

        for(int ii=0;ii<myArray.length; ii++) {
            for(int k=ii;k<myArray.length;k++) {
                if(myArray[ii] < myArray[k]) {
                    temp = myArray[k];
                    myArray[k] = myArray[ii];
                    myArray[ii] = temp;
                }
            }
        }
    }
    public void FindHostRequired() {
        myArrayHost = new int[myArray.length];
        myArrayExponent = new int[myArray.length];
        int exponent = 0;
        for (int jj=0; jj<myArray.length; jj++) {
            int formula;
            while (exponent <= myArray[jj]) {
                formula = (int) (Math.pow(2, exponent) - 2);
                if (formula >= myArray[jj]) {
                    myArrayHost[jj] = formula;
                    myArrayExponent[jj] = exponent;
                    exponent = 0;
                    break;
                }
                exponent++;
            }
        }
        //For example: myArray[0] = 1000. Therefore hh = 10,
        // because the conditional 'if' is the rule about the break loop
    }

    public void GetNewSubnet() {
        myArrayBinary = new String[4]; //4 = quantity octets
        for (int n=0; n<myArrayDefaultSubnet.length; n++) { // Ex: [0]255 [1]0 [2]0 [3]0
            int nConverted = Integer.parseInt(myArrayDefaultSubnet[n]);
            String binary = String.format("%8s",Integer.toBinaryString(nConverted))
                    .replace(' ', '0');
            myArrayBinary[n] = binary;

        }
    }

    public void GetNewPrefNet() {
        int storedBinary = 0;
        char[] convertBinary;
        for (String binary : myArrayBinary) {
            convertBinary = binary.toCharArray();
            for (char c : convertBinary) {
                if (c == '1') {
                    storedBinary+=1;
                }
            }
        }
        System.out.println("Sum: "+storedBinary);
    }

    public void Split(String ip) { // Find Subnet
        dText = new DefaultText();
        char[] c = ip.toCharArray();
        subnetList = new SubnetList();
        String inner = "";
        String defaultSubnet = "";
        int newInt = 0;
        for (char newChar : c) {
            if (newChar == '.') {break;}
            String str = String.valueOf(newChar);
            inner += str;
            newInt = Integer.parseInt(inner);
        }
        if (newInt >= IPClassA[0] && newInt <= IPClassA[1]) {
            ///subnetList.addSubnetMask("255.0.0.0");
            //subnetList.display();
            defaultSubnet = "255.0.0.0";
            myArrayDefaultSubnet = defaultSubnet.split("\\.");
            dText.TextLN("Your default mask -> "+defaultSubnet);
            GetNewSubnet();
        } else if (newInt >= IPClassB[0] & newInt <= IPClassB[1]) {
            //subnetList.addSubnetMask("255.255.0.0");
            //subnetList.display();
            defaultSubnet = "255.255.0.0";
            myArrayDefaultSubnet = defaultSubnet.split("\\.");
            dText.TextLN("Your default mask -> "+defaultSubnet);
            GetNewSubnet();
        } else if (newInt >= IPClassC[0] & newInt <= IPClassC[1]) {
            //subnetList.addSubnetMask("255.255.255.0");
            //subnetList.display();
            defaultSubnet = "255.255.255.0";
            myArrayDefaultSubnet = defaultSubnet.split("\\.");
            dText.TextLN("Your default mask -> "+defaultSubnet);
            GetNewSubnet();
        }
    }
}
