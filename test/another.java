package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class another {
    public static void main (String[] args) {
        /*Integer[] array = {5, 2, 8, 1, 9, 3};

        // Ordenar el array en forma descendente utilizando un comparador personalizado
        Arrays.sort(array);
        System.out.println();
        // Imprimir el array ordenado
        for (int num : array) {
            System.out.print(num + " ");
        }

        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println();
        
        for (int num : array) {
            System.out.print(num+ " ");
        }*/

        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();

        if (line.contains("--qh")) {
            String[] parts = line.split(" ");
            if (parts.length > 2 && parts[parts.length - 1].equals("--qh")) {
                int num = Integer.parseInt(parts[parts.length - 2]);
            
                System.out.println("Parte 1: "+parts[parts.length - 2]+" Parte 2: "+parts[parts.length - 1]);
                int i = 1;
                while (i <= num) {
                    System.out.println("Subnet00"+i+" => ");
                    i++;
                }
            }
            /*if (parts.length == 2 && parts[1].equals("--qh")) {
                Sys
            }*/
            
        }

    }
}
