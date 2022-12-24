package engtelecom.poo;

import java.util.ArrayList;

public class Computer extends Fila {
    private int seq;
    private ArrayList<String> trafegoFila;
    private ArrayList<Trafego> fila;

    public Computer(int id) {
        super(id);
        this.seq = 0;
    }

    @Override
    public ArrayList<Trafego> leTrafegoFila() {
        String linha = getFila().get(0).getConteudo();
        String[] dispositivos = new String[3];
        int j = 0;
        int x = 0;
        String list[] = linha.split("|");
        for (int i = 0; i < linha.length(); i++) {
            if (x == 2) { // usado para separar a mensagem depois da segunda |
                dispositivos[x] = linha.substring(j); // pega os dados da string a partir da ultima |
            }
            if (list[i].equals("|")) { // verifica se a string atual é igual a |
                dispositivos[x] = linha.substring(j, i); // se for, pega do inicio até a barra e salva no vetor
                j = (i + 1);
                x++;
            }
        }
        if (dispositivos[0].equals("h" + getId())) {
            this.gerados += 1;
        } else if (dispositivos[1].equals("h" + getId())) {
            this.processados += 1;
        } else {
            this.descartados += 1;
        }

        setSeq(getSeq() + 1);

        imprimeFinal(getId());

        return this.fila;
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

    @Override
    public ArrayList<Trafego> getFila() {
        return fila;
    }

}
