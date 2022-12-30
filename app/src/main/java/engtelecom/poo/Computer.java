package engtelecom.poo;

import java.util.ArrayList;

public class Computer extends Fila {
    private int seq;
    private ArrayList<Trafego> filaLocalPc;

    public Computer(int id) {
        super(id);
        this.seq = 0;
        this.filaLocalPc = new ArrayList<Trafego>();
    }

    public void leTrafegoFila(ArrayList<Trafego> fila) {
        if (fila.get(0).getHostOrigem().equals("h" + getId())) {
            this.gerados += 1;
            getConexaoSwitch().get(0).addFila(fila.get(0));
            fila.remove(0);
        }

        // setSeq(getSeq() + 1);

        // imprimeFinal(getId());
    }

    public void leTrafegoFilaLocal() {
        int x = 0;
        while (x < getFilaLocalPc().size()) {
            if (getFilaLocalPc().get(x).getHostDestino().equals("h" + getId())) {
                this.processados += 1;
                getFilaLocalPc().remove(x);
            }
            x++;
        }
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getGerados() {
        return gerados;
    }

    public int getProcessados() {
        return processados;
    }

    public int getDescartados() {
        return descartados;
    }

    public void setGerados(int gerados) {
        this.gerados = gerados;
    }

    public void setProcessados(int processados) {
        this.processados = processados;
    }

    public void setDescartados(int descartados) {
        this.descartados = descartados;
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

    @Override
    public void imprimeFinal(int x) {
        String s = String.format("| h%-10s | %7d | %11d | %11d |", x, this.gerados, this.processados,
                this.descartados);
        System.out.println(s);

    }

    public ArrayList<Trafego> getFilaLocalPc() {
        return filaLocalPc;
    }

    @Override
    public void setFila(ArrayList<Trafego> fila) {
        this.filaLocalPc = fila;
    }

    @Override
    public void addFila(Trafego fila) {
        this.filaLocalPc.add(fila);
    }

    @Override
    public ArrayList<Trafego> getFilaLocal() {
        return null;
    }

}
