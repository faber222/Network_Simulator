package engtelecom.poo;

import java.util.ArrayList;
import java.util.Map;

public class Network extends Maquinas {

    private int ttl;
    private boolean fim;
    private ArrayList<Switch> maquinaSwitch;
    private ArrayList<Computer> maquinaComputer;

    public Network(Map<String, String> hosts, Map<String, ArrayList<String>> switchs, ArrayList<String> trafego) {
        super(hosts, switchs, trafego);
        this.ttl = 3;
        this.fim = false;
        this.maquinaComputer = new ArrayList<Computer>();
        this.maquinaSwitch = new ArrayList<Switch>();

        for (int i = 1; i <= super.getHosts().size(); i++) {
            Computer pc = new Computer(super.getTrafego(), i);
            this.maquinaComputer.add(pc);
        }
        for (int i = 1; i <= super.getSwitchs().size(); i++) {
            Switch sw = new Switch(super.getTrafego(), i);
            this.maquinaSwitch.add(sw);
        }
    }

    public void lerArq() {
        for (String linha : super.getTrafego()) {
            String[] dispositivos = new String[3];
            int j = 0;
            int x = 0;
            String teste[] = linha.split("|");
            for (int i = 0; i < linha.length(); i++) {
                if (x == 2) { // usado para separar a mensagem depois da segunda |
                    dispositivos[x] = linha.substring(j); // pega os dados da string a partir da ultima |
                }
                if (teste[i].equals("|")) { // verifica se a string atual é igual a |
                    dispositivos[x] = linha.substring(j, i); // se for, pega do inicio até a barra e salva no vetor
                    j = (i + 1);
                    x++;
                }
            }
            System.out.printf("Origem: %s -- Destino: %s -- Mensagem: %s\n", dispositivos[0],
                    dispositivos[1], dispositivos[2]);
        }
    }

    public boolean isFim() {
        return fim;
    }

}
