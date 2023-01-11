package engtelecom.poo;

import java.util.ArrayList;

public abstract class Fila implements LeitorFila {
    protected ArrayList<Switch> conexaoSwitch;
    protected ArrayList<Computer> conexaoPc;
    protected int id;

    protected String logFile;

    protected int gerados;
    protected int processados;
    protected int descartados;

    public Fila(int id, String logFile) {
        this.id = id;
        this.gerados = 0;
        this.processados = 0;
        this.descartados = 0;
        this.logFile = logFile;
        
    }

   
}
