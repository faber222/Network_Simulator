package engtelecom.poo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    private Map<String, String> hosts;
    private Map<String, ArrayList<String>> switchs;

    public App() {
        this.hosts = new HashMap<String, String>();
        this.switchs = new HashMap<String, ArrayList<String>>();
    }

    public Map<String, String> getHosts() {
        return hosts;
    }

    public Map<String, ArrayList<String>> getSwitchs() {
        return switchs;
    }

    public static void main(String[] args) {
        App app = new App();
        Leitor leitorArq = new Leitor(app.getHosts(), app.getSwitchs());
        File arquivo = new File(args[0]);
        // File arquivo = new File("topologia.txt");
        File arquivo2 = new File(args[1]);
        // File arquivo2 = new File("trafego.txt");

        leitorArq.lerTopologia(arquivo);
        leitorArq.lerTrafego(arquivo2);

        Network rede = new Network(app.getHosts(), app.getSwitchs());

        while (!rede.isFim()) {

        }
    }
}
