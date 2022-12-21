package engtelecom.poo;

import java.util.ArrayList;

public class Switch extends Fila {
    private int seq;
    private ArrayList<String> trafegoFila;
    private int gerados;
    private int processados;
    private int descartados;

    public Switch(ArrayList<String> fila, int id) {
        super(fila, id);
        this.seq = 0;
    }

    @Override
    public boolean leTrafegoFila() {
        for (int y = 0; y < getFila().size(); y++) {
            String linha = getFila().get(getSeq());
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
            if (list[0].equals("s") && list[1].equals("" + getId())) {
                this.gerados += 1;
            } else if (list[3].equals("s") && list[4].equals("" + getId())) {
                this.processados += 1;
            } else {
                this.descartados += 1;
            }
            // System.out.print("Switch: " + getId());
            // // System.out.println("gerados: " + this.gerados + " processados: " +
            // this.processados + " descartados: "
            // // + this.descartados);
            // System.out.printf(" Origem: %s -- Destino: %s -- Mensagem: %s\n",
            // dispositivos[0],
            // dispositivos[1], dispositivos[2]);
            setSeq(getSeq() + 1);
        }
        imprimeFinal(getId());
        return false;
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

    @Override
    public void imprimeFinal(int x) {
        String s = String.format("| s%-10s | %7d | %11d | %11d |", x, this.gerados, this.processados,
                this.descartados);
        System.out.println(s);

    }

}
