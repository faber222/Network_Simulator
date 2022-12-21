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
