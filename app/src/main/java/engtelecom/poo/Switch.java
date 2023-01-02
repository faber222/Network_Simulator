package engtelecom.poo;

import java.util.ArrayList;

public class Switch extends Fila {
    private int seq;
    private ArrayList<Trafego> filaLocal;

    public Switch(int id) {
        super(id);
        this.seq = 0;
        this.filaLocal = new ArrayList<Trafego>();
    }

    public void leTrafegoFilaSwitch() {
        while (!getFilaLocal().isEmpty()) {
            boolean semHost = true;
            for (Computer pc : getConexaoPc()) {
                if (getFilaLocal().get(0).getHostDestino().equals("h" + pc.getId())) {
                    this.processados += 1;
                    getConexaoPc().get(getConexaoPc().indexOf(pc)).addFila(getFilaLocal().get(0));
                    semHost = false;
                }
            }
            if (semHost) {
                int x = getFilaLocal().get(0).getTtl();
                x--;
                if (x <= 0) {
                    this.descartados += 1;
                } else {
                    this.processados += 1;
                    getFilaLocal().get(0).setTtl(x);
                    for (Switch sw : getConexaoSwitch()) {            
                            sw.addFila(getFilaLocal().get(0));
                    }
                }
            }
            getFilaLocal().remove(0);
        }
        // if (fila.get(0).getHostOrigem().equals("h" + getId())) {
        // this.gerados += 1;
        // getConexaoSwitch().get(0).addFila(fila.get(0));
        // fila.remove(0);
        // }
        // if (!getFilaLocal().isEmpty() && getFilaLocal().get(0).equals("h" + getId()))
        // {
        // this.processados += 1;
        // this.filaLocal.remove(0);
        // }

        // this.descartados += 1;

        // setSeq(getSeq() + 1);

        // imprimeFinal(getId());
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
        String s = String.format("| s%-10s | %7d | %11d | %11d |", x, this.gerados, this.processados,
                this.descartados);
        System.out.println(s);

    }

    @Override
    public ArrayList<Trafego> getFilaLocal() {
        return filaLocal;
    }

    @Override
    public void setFila(ArrayList<Trafego> fila) {
        this.filaLocal = fila;
    }

    @Override
    public void addFila(Trafego fila) {
        this.filaLocal.add(fila);
    }

}
