package engtelecom.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Network extends Maquinas{
    private int ttl;
    private boolean fim;
    private ArrayList<Switch> maquinaSwitch;
    private ArrayList<Computer> maquinaComputer;
    private Switch conexao;

    public Network(Map<String, String> hosts, Map<String, ArrayList<String>> switchs) {
        super(hosts, switchs);
        this.ttl = 3;
        this.fim = false;
    }
   
    public boolean isFim() {
        return fim;
    }

}
