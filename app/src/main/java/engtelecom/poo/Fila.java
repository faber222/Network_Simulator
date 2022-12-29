package engtelecom.poo;

import java.util.ArrayList;

public abstract class Fila implements LeitorFila {
    protected ArrayList<Switch> conexaoSwitch;
    protected ArrayList<Computer> conexaoPc;
    protected int id;

    protected int gerados;
    protected int processados;
    protected int descartados;

    public Fila(int id) {
        this.id = id;
        this.gerados = 0;
        this.processados = 0;
        this.descartados = 0;
        
    }

   
}
