package test.Command;

public class Calculator {
    private exmInterpreter exInter;
    
        public Calculator() {
            this.exInter = new exmInterpreter();
        }
    
        public void interpretCommand(String command) {
            if (command.contains("+")) {
                int number = Integer.parseInt(command.split("\\+")[1].trim());
                Expression expression = new AddExpression(number);
                expression.interpreter(exInter);
                System.out.println("Resultado: " + exInter.getValue());
            } else if (command.contains("-")) {
                int number = Integer.parseInt(command.split("-")[1].trim());
                Expression expression = new SubtractExpression(number);
                expression.interpreter(exInter);
                System.out.println("Resultado: " + exInter.getValue());
            } else {
                throw new IllegalArgumentException("Comando no válido");
            }
        }
}
