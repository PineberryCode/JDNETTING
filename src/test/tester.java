package test;

// Create own variable SO;
public class tester {
    
    public static void main (String[] args) {
        int prefix = 30;
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

    }
}
