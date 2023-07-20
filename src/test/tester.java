package test;

// Create own variable SO;
public class tester {
    
    public static void main (String[] args) {
        /*int prefix = 30;
        int i = 1;
        StringBuilder strBuilder = new StringBuilder();
        while (i <= 32) {
            if (strBuilder.length() <= prefix) {
                strBuilder.append("1");
            } else {
                strBuilder.append("0");
            }
            i++;
        }
        strBuilder.insert(8, '.');
        strBuilder.insert(17, '.');
        strBuilder.insert(26, '.');
        String[] octetos = strBuilder.toString().split("\\.");
        int countZeros = 1;
        for (int g = 0; g < octetos.length; g++) {
            if (octetos[g].contains("1") && octetos[g].contains("0")) {
                for (int j = 0; j < octetos[g].length();j++) {
                    if (octetos[g].charAt(j) == '0') {
                        countZeros++;
                    }
                }
                break;
            }
        }
        System.out.println(countZeros);
        System.out.println("JUMPER: "+Math.pow( 2, countZeros));
        /*
         * Subred mask
         */
        /*int j = 1;
        StringBuilder strBuilderSubred = new StringBuilder();
        while (j <= 32) {
            if (strBuilderSubred.length() <= prefix) {
                strBuilderSubred.append("1");
            } else {
                strBuilderSubred.append("0");
            }
            j++;
        }
        strBuilderSubred.insert(8, '.');
        strBuilderSubred.insert(17, '.');
        strBuilderSubred.insert(26, '.');
        String[] partsSubredZeroAndOne = strBuilderSubred.toString().split("\\.");
        System.out.println("4Octet: "+partsSubredZeroAndOne[3]);
        int firstValue = Integer.parseInt(partsSubredZeroAndOne[0], 2);
        int secondValue = Integer.parseInt(partsSubredZeroAndOne[1], 2);
        int thirdValue = Integer.parseInt(partsSubredZeroAndOne[2],2);
        int fourthValue = Integer.parseInt(partsSubredZeroAndOne[3],2);
        System.out.println(firstValue+"."+secondValue+"."+thirdValue+"."+fourthValue);
        System.out.println("1Or0 Subred => "+strBuilderSubred);*/
        System.out.print(padRight("Hola", 10));
        System.out.print(padRight("Hola", 10));
        System.out.print(padRight("Hola", 10));
    }
    public static String padRight(String cell, int width) {
        return String.format("%-"+width+"s",cell);
    }
}
