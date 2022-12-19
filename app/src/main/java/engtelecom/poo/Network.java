package engtelecom.poo;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {
    private HashMap<String, String> computador;
    private ArrayList switches;
    private int ttl;
    private ArrayList topologia;
    private String mensagem;

    public Network(ArrayList topologia) {
        this.computador = new HashMap<String, String>();
        this.switches = new ArrayList<>();
        this.ttl = 3;
    }


  
}
