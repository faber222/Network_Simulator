package engtelecom.poo;

import java.util.ArrayList;

public abstract class Fila {
    private ArrayList<String> fila;
    private ArrayList<Switch> conexaoSwitch;
    private ArrayList<Computer> conexaoPc;
    
    public Fila(ArrayList<String> fila, ArrayList<Switch> conexaoSwitch, ArrayList<Computer> conexaoPc) {
        this.fila = fila;
        this.conexaoSwitch = conexaoSwitch;
        this.conexaoPc = conexaoPc;
    }

}
