import General.DefaultClass;
import General.DefaultText;
import Logical.Methods;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Dev implements DefaultClass {
    public static DefaultText dText;
    public static Methods methods;
    /*Note => */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        methods = new Methods();
        dText = new DefaultText();
        dText.TextLN("########################################");
        dText.TextNonLN(" WELCOME TO THE VLSM SUB-NETTING");
        dText.TextLN("########################################");
        dText.TextNonLN("Type your IP => ");
        String ip = scn.next();
        methods.Split(ip); // It wouldn't be shown;
        dText.TextLN("########################################");
        dText.TextNonLN("How much quantity subnets => ");
        int q = scn.nextInt();
        dText.TextLN("########################################");
        methods.WhileAndSort(q);
        /*view*/
        /*for (int jj : methods.myArray) {
            System.out.print("myArraySorted: "+jj+" ");
        }*/
        /*#############*/
        methods.FindHostRequired();
        for (int jj : Methods.myArrayExponent) {
            System.out.println("Exponent: "+jj);
        }
        for (String a : Methods.myArrayBinary) {
            System.out.println(a);
        }
        methods.GetNewPrefNet();
    }
}