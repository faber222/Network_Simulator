package engtelecom.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Network {
    private int ttl;
    private String mensagem;
    private boolean fim;
    private ArrayList<Switch> maquinaSwitch;
    private ArrayList<Computer> maquinaComputer;
    private Switch conexão;

    private Map<String, String> hosts;
    private Map<String, ArrayList<String>> switchs;

    public Network(Map<String, String> hosts, Map<String, ArrayList<String>> switchs) {
        this.ttl = 3;
        this.fim = false;
        this.hosts = hosts;
        this.switchs = switchs;
    }

    public boolean isFim() {
        return fim;
    }

}
