package engtelecom.poo;

import java.util.ArrayList;
import java.util.Map;

public class Network extends Maquinas {
    private int ttl;
    private boolean fim;
    private ArrayList<Switch> maquinaSwitch;
    private ArrayList<Computer> maquinaComputer;
    private ArrayList<String> trafegoReal;

    public Network(Map<String, String> hosts, Map<String, ArrayList<String>> switchs, ArrayList<String> trafego) {
        super(hosts, switchs, trafego);
        this.ttl = 3;
        this.fim = false;
        this.maquinaComputer = new ArrayList<Computer>();
        this.maquinaSwitch = new ArrayList<Switch>();
        this.trafegoReal = trafego;

        for (int i = 1; i <= super.getHosts().size(); i++) {
            Computer pc = new Computer(getTrafego(), i);
            this.maquinaComputer.add(pc);
        }
        for (int i = 1; i <= super.getSwitchs().size(); i++) {
            Switch sw = new Switch(getTrafego(), i);
            this.maquinaSwitch.add(sw);
        }
        defineConexaoHost();
        defineConexaoSwitch();
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
                int idSwitch = 1;
                int posicao = getMaquinaSwitch().indexOf(sw);

                if (super.getSwitchs().containsKey("s" + id)) {
                    ArrayList<String> maquina = super.getSwitchs().get("s" + id);
                    ArrayList<Computer> pcAdd = new ArrayList<Computer>();
                    ArrayList<Switch> swAdd = new ArrayList<Switch>();

                    for (String swtArray : maquina) {
                        String list[] = swtArray.split("");
                        idSwitch = Integer.parseInt(list[1]);

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
        for (int i = 0; i < sizeHosts; i++) {
            getMaquinaComputer().get(i).leTrafegoFila();
        }
        for (int i = 0; i < sizeSwitchs; i++) {
            getMaquinaSwitch().get(i).leTrafegoFila();
        }
        System.out.println("|---------------------------------------------------|");
        setFim(true);
    }

    public ArrayList<String> getTrafego() {
        return trafegoReal;
    }

    public ArrayList<Switch> getMaquinaSwitch() {
        return maquinaSwitch;
    }

    public ArrayList<Computer> getMaquinaComputer() {
        return maquinaComputer;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

}
