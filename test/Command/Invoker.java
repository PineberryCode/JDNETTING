package test.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<IOperación> operaciones = new ArrayList<>();
    
    public void recibirOperación(IOperación operación) {
        this.operaciones.add(operación);
    }

    public void realizarOperación() {
        this.operaciones.forEach(x -> x.execute());
        this.operaciones.clear();
    }
}
