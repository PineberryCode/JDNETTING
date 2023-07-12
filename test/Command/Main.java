package test.Command;
    public class Main {
        public static void main(String[] args) {
            Calculator calculator = new Calculator();
            calculator.interpretCommand("+ 5");  // Resultado: 5
            calculator.interpretCommand("- 3");  // Resultado: 2
        }
}
