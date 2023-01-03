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

    public void leTrafegoFila(ArrayList<Trafego> fila, int instante) {

        if (fila.get(0).getHostOrigem().equals("h" + getId())) {
            this.gerados += 1;
            getConexaoSwitch().get(0).addFila(fila.get(0));
            LoggerFile log = new LoggerFile(fila.get(0).getConteudo(), "s" + getConexaoSwitch().get(0).getId(),
                    fila.get(0).getHostOrigem(), instante);
            log.writeLog();
            fila.remove(0);
        }
    }

    public void leTrafegoFilaLocal(int instante) {
        int x = 0;
        while (x < getFilaLocalPc().size()) {
            if (getFilaLocalPc().get(x).getHostDestino().equals("h" + getId())) {
                LoggerFile log = new LoggerFile(getFilaLocalPc().get(0).getConteudo(), getFilaLocalPc().get(0).getHostDestino(),
                        getFilaLocalPc().get(0).getHostDestino(), instante);
                log.writeLog();
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
