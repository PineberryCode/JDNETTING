package test;

public class testFake {
    public static void main (String[] args) {
        int[] myArray = new int[5];
        myArray[0] = 6;
        myArray[1] = 2;
        myArray[2] = 3;
        myArray[3] = 5;
        myArray[4] = 8;

        int max = myArray[0];

        for (int k = 0; k < myArray.length; k++) { // 6, 2, 3, 5, 8
            if (myArray[k] >= max) {
                max = myArray[k];
            }
        }
        System.out.println(max);

        System.out.println("Exponente: "+Math.pow(2,7));
    }
}
