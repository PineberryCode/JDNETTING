package Controller;

import java.util.Scanner;

import Controller.Commands.Command;

public class VLSM implements Command {
    
    private static int mySoloHostQuantity[];
    Scanner scn = new Scanner(System.in);
    String line = "";

    //private void 

    private void Context () {
        System.out.println("WELCOME");
        while (!line.contains(CANCEL)) {
            line = scn.nextLine();
            if (line.contains(QUANTITY_HOST)) {
                String[] parts = line.split(" ");
                
            }
        }
    }



    public void vlsm() {
        Context();
    }

}
