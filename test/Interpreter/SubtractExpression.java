package test.Interpreter;

public class SubtractExpression implements Expression {
    private int number;

    public SubtractExpression(int number) {
        this.number = number;
    }
    @Override
    public void interpreter(exmInterpreter exInter) {
        exInter.setValue(exInter.getValue() - number);
    }
}
