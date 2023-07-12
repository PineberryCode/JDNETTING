package test.Command;

public class App {
    public static void main (String[] args) {
        Cuenta cuenta = new Cuenta(1,200);
        
        DepositarImpl operaciónDepo = new DepositarImpl(cuenta, 100);
        RetirarImpl operaciónReti = new RetirarImpl(cuenta, 100);

        Invoker ivk = new Invoker();
        ivk.recibirOperación(operaciónDepo);
        ivk.recibirOperación(operaciónReti);
        ivk.realizarOperación();
    }
}
