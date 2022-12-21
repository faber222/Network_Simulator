package engtelecom.poo;

import java.util.ArrayList;
import java.util.Map;

public abstract class Maquinas extends App{
    private Map<String, String> hosts;
    private Map<String, ArrayList<String>> switchs;
    private ArrayList<String> trafego;

    public Maquinas(Map<String, String> hosts, Map<String, ArrayList<String>> switchs, ArrayList<String> trafego) {
        this.hosts = hosts;
        this.switchs = switchs;
        this.trafego = trafego;
    }

    public Map<String, String> getHosts() {
        return hosts;
    }

    public Map<String, ArrayList<String>> getSwitchs() {
        return switchs;
    }

    public ArrayList<String> getTrafego() {
        return trafego;
    }
}
