package engtelecom.poo;

import java.util.ArrayList;
import java.util.Map;

public abstract class Maquinas {
    private Map<String, String> hosts;
    private Map<String, ArrayList<String>> switchs;

    public Maquinas(Map<String, String> hosts, Map<String, ArrayList<String>> switchs) {
        this.hosts = hosts;
        this.switchs = switchs;
    }

    public Map<String, String> getHosts() {
        return hosts;
    }

    public Map<String, ArrayList<String>> getSwitchs() {
        return switchs;
    }

  
}
