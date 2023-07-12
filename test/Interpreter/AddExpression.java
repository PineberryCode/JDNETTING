package test.Interpreter;

public class AddExpression implements Expression{
    private int number;

        //Constructor
        public AddExpression(int number) {
            this.number = number;
        }

        @Override
        public void interpreter(exmInterpreter exInter) {
            exInter.setValue(exInter.getValue()+number);            
        }
}
