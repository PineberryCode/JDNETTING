package test;

public class testFake {

    public static void prinTable(String[][] data, int[] columnWidths) {
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
                System.out.print(padRight(cell, width)+" | ");
            }
            System.out.println();
            if (i == 0) {
                printLine(totalWidth);
            }
        }
        printLine(totalWidth);
    }

    public static String padRight(String cell, int width) {
        return String.format("%-"+width+"s",cell);
    }

    public static void printLine(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        String[][] data = {
            {"Host","Host Required","Red IP","Prefix","SubredMask"},
            {"5000","8190","192.168.0.0","19","255.255.224.0"}
        };
        int[] columnWidths = {5,13,15,6,15};
        prinTable(data, columnWidths);
    }
}
