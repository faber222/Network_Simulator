package engtelecom.poo;

import java.util.ArrayList;

public abstract class Fila implements LeitorFila {
    private ArrayList<String> fila;
    private ArrayList<Switch> conexaoSwitch;
    private ArrayList<Computer> conexaoPc;
    private int id;
    
    public Fila(ArrayList<String> fila, int id) {
        this.fila = fila;
        this.id = id;
    }

    public ArrayList<String> getFila() {
        return fila;
    }

    public ArrayList<Switch> getConexaoSwitch() {
        return conexaoSwitch;
    }

    public ArrayList<Computer> getConexaoPc() {
        return conexaoPc;
    }

    public int getId() {
        return id;
    }

    public void setConexaoSwitch(ArrayList<Switch> conexaoSwitch) {
        this.conexaoSwitch = conexaoSwitch;
    }

    public void setConexaoPc(ArrayList<Computer> conexaoPc) {
        this.conexaoPc = conexaoPc;
    }

}
