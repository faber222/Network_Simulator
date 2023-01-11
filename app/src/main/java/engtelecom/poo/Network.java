package engtelecom.poo;

import java.util.ArrayList;
import java.util.Map;

public class Network extends Maquinas {
    private int ttl;
    private boolean fim;
    private ArrayList<Switch> maquinaSwitch;
    private ArrayList<Computer> maquinaComputer;
    private ArrayList<Trafego> trafegoComTtl;
    private String logFile;

    public Network(Map<String, String> hosts, Map<String, ArrayList<String>> switchs, ArrayList<String> trafego, String logFile) {
        super(hosts, switchs, trafego);
        this.ttl = 3;
        this.fim = false;
        this.maquinaComputer = new ArrayList<Computer>();
        this.maquinaSwitch = new ArrayList<Switch>();
        this.trafegoComTtl = new ArrayList<Trafego>();
        this.logFile = logFile;

        for (int i = 1; i <= super.getHosts().size(); i++) {
            Computer pc = new Computer(i, getLogFile());
            this.maquinaComputer.add(pc);
        }
        for (int i = 1; i <= super.getSwitchs().size(); i++) {
            Switch sw = new Switch(i, getLogFile());
            this.maquinaSwitch.add(sw);
        }
        defineConexaoHost();
        defineConexaoSwitch();
        trataTrafego(trafego);
    }

    private void defineConexaoHost() {
        int id = 1;
        for (Computer pc : getMaquinaComputer()) {
            if (pc.getId() == id) {
                int idSwitch = 1;
                int posicao = getMaquinaComputer().indexOf(pc);

                if (super.getHosts().containsKey("h" + id)) {
                    String swt = super.getHosts().get("h" + id);
                    String swtArray[] = swt.split("");
                    idSwitch = Integer.parseInt(swtArray[1]);

                    for (Switch sw : getMaquinaSwitch()) {
                        if (sw.getId() == idSwitch) {
                            ArrayList<Switch> swAdd = new ArrayList<Switch>();
                            swAdd.add(sw);
                            pc.setConexaoSwitch(swAdd);
                        }
                    }
                    getMaquinaComputer().set(posicao, pc);
                }
            }
            id++;
        }
    }

    private void defineConexaoSwitch() {
        int id = 1;
        for (Switch sw : getMaquinaSwitch()) {
            if (sw.getId() == id) {
                int idSwitch;
                int posicao = getMaquinaSwitch().indexOf(sw);

                if (super.getSwitchs().containsKey("s" + id)) {
                    ArrayList<String> maquina = super.getSwitchs().get("s" + id);
                    ArrayList<Computer> pcAdd = new ArrayList<Computer>();
                    ArrayList<Switch> swAdd = new ArrayList<Switch>();

                    for (String swtArray : maquina) {
                        String idString = swtArray.substring(1);
                        idSwitch = Integer.parseInt(idString);
                        String list[] = swtArray.split("");

                        for (Computer pcConectado : getMaquinaComputer()) {
                            if (pcConectado.getId() == idSwitch && list[0].equals("h")) {
                                pcAdd.add(pcConectado);
                                sw.setConexaoPc(pcAdd);
                            }
                        }
                        for (Switch swConectado : getMaquinaSwitch()) {
                            if (swConectado.getId() == idSwitch && list[0].equals("s")) {
                                swAdd.add(swConectado);
                                sw.setConexaoSwitch(swAdd);
                            }
                        }
                    }
                    getMaquinaSwitch().set(posicao, sw);
                }
            }
            id++;
        }
    }

    public void processaDados(int sizeHosts, int sizeSwitchs) {
        System.out.println("|---------------------------------------------------|");
        System.out.println("| Dispositivo |             Pacotes                 |");
        System.out.println("|             | gerados | processados | descartados |");
        System.out.println("|---------------------------------------------------|");

        int instante = 1;
        while (!getTrafegoComTtl().isEmpty()) {
            for (int i = 0; i < sizeHosts; i++) {
                if (getTrafegoComTtl().isEmpty()) {
                    break;
                }
                getMaquinaComputer().get(i).leTrafegoFila(getTrafegoComTtl(), instante);
            }
            for (int i = 0; i < sizeSwitchs; i++) {
                getMaquinaSwitch().get(i).leTrafegoFilaSwitch(instante);
            }
            for (int i = 0; i < sizeHosts; i++) {
                getMaquinaComputer().get(i).leTrafegoFilaLocal(instante);
            }
            instante++;
        }

        // for (int i = 0; i < sizeSwitchs; i++) {
        // getMaquinaSwitch().get(i).leTrafegoFilaSwitch();
        // }
        // for (int i = 0; i < sizeSwitchs; i++) {
        // getMaquinaSwitch().get(i).leTrafegoFilaSwitch();
        // }
        // for (int i = 0; i < sizeSwitchs; i++) {
        // getMaquinaSwitch().get(i).leTrafegoFilaSwitch();
        // }

        // for (int i = 0; i < sizeHosts; i++) {
        // getMaquinaComputer().get(i).leTrafegoFilaLocal();
        // }

        for (int i = 0; i < sizeHosts; i++) {
            getMaquinaComputer().get(i).imprimeFinal(i + 1);
        }
        for (int i = 0; i < sizeSwitchs; i++) {
            getMaquinaSwitch().get(i).imprimeFinal(i + 1);
        }
        System.out.println("|---------------------------------------------------|");
        setFim(true);
    }

    private void trataTrafego(ArrayList<String> dados) {
        int i = 0;
        for (String trafego : dados) {
            String[] dispositivos = new String[3];
            int j = 0;
            int x = 0;
            String list[] = trafego.split("|");
            for (int k = 0; k < trafego.length(); k++) {
                if (x == 2) { // usado para separar a mensagem depois da segunda |
                    dispositivos[x] = trafego.substring(j); // pega os dados da string a partir da ultima |
                }
                if (list[k].equals("|")) { // verifica se a string atual é igual a |
                    dispositivos[x] = trafego.substring(j, k); // se for, pega do inicio até a barra e salva no vetor
                    j = (k + 1);
                    x++;
                }
            }
            Trafego mensagem = new Trafego(getTtl(), dispositivos[2], dispositivos[0], dispositivos[1], i);
            this.trafegoComTtl.add(mensagem);
            i++;
        }
    }

    public ArrayList<Switch> getMaquinaSwitch() {
        return maquinaSwitch;
    }

    public ArrayList<Computer> getMaquinaComputer() {
        return maquinaComputer;
    }

    public int getTtl() {
        return ttl;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public ArrayList<Trafego> getTrafegoComTtl() {
        return trafegoComTtl;
    }

    public void setTrafegoComTtl(ArrayList<Trafego> trafegoComTtl) {
        this.trafegoComTtl = trafegoComTtl;
    }

    public String getLogFile() {
        return logFile;
    }

}
