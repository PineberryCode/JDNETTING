package test.Command;

public class RetirarImpl implements IOperación {
    private Cuenta cuenta;
    private double monto;

    public RetirarImpl(Cuenta cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void execute() {
        this.cuenta.retirar(this.monto);
    }
    
}
