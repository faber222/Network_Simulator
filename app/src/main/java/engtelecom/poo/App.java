package engtelecom.poo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    private Map<String, String> hosts;
    private Map<String, ArrayList<String>> switchs;
    private ArrayList<String> trafego;

    public App() {
        this.hosts = new HashMap<String, String>();
        this.switchs = new HashMap<String, ArrayList<String>>();
        this.trafego = new ArrayList<String>();
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

    public static void main(String[] args) {
        App app = new App();
        Leitor leitorArq = new Leitor(app.getHosts(), app.getSwitchs(), app.getTrafego());
        // File arquivo = new File(args[0]);
        File arquivo = new File("topologia.txt");
        // File arquivo2 = new File(args[1]);
        File arquivo2 = new File("trafego.txt");

        leitorArq.lerTopologia(arquivo);
        leitorArq.capturaTrafego(arquivo2);

        Network rede = new Network(app.getHosts(), app.getSwitchs(), app.getTrafego());

        while (!rede.isFim()) {
            System.out.println("|---------------------------------------------------|");
            System.out.println("| Dispositivo |             Pacotes                 |");
            System.out.println("|             | gerados | processados | descartados |");
            System.out.println("|---------------------------------------------------|");
            for (int i = 0; i < app.getHosts().size(); i++) {
                rede.getMaquinaComputer().get(i).leTrafegoFila();
            }
            for (int i = 0; i < app.getSwitchs().size(); i++) {
                rede.getMaquinaSwitch().get(i).leTrafegoFila();
            }
            System.out.println("|---------------------------------------------------|");
            rede.setFim(true);
        }
    }

}
