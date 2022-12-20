package engtelecom.poo;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Leitor extends Maquinas {
    // private Map<String, String> hosts;
    // private Map<String, ArrayList<String>> switchs;

    public Leitor(Map<String, String> hosts, Map<String, ArrayList<String>> switchs) {
        super(hosts, switchs);
    }

    public void lerTopologia(File arq) {
        try (Scanner leitor = new Scanner(arq)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dispositivos = linha.split("--");
                String[] primeiraColuna = dispositivos[0].split("");
                String[] segundaColuna = dispositivos[1].split("");

                if (primeiraColuna[0].equals("h")) {
                    super.getHosts().put(dispositivos[0], dispositivos[1]);
                } else if (segundaColuna[0].equals("h")) {
                    super.getHosts().put(dispositivos[1], dispositivos[0]);
                }  else {
                    ArrayList<String> tabela = new ArrayList<String>();
                    if (super.getSwitchs().containsKey(dispositivos[0])) {
                        tabela = (super.getSwitchs().get(dispositivos[0]));
                    }
                    tabela.add(dispositivos[1]);
                    super.getSwitchs().put(dispositivos[0], tabela);
                }
            }
            super.getHosts().forEach((key, value) -> System.out.println("o valor de " + key + " eh: " + value));

            super.getSwitchs().forEach(
                    (key, value) -> value.forEach(lista -> System.out.println("o valor de " + key
                            + " eh: " + lista)));

        } catch (Exception e) {
            System.err.print("Nao foi possivel criar o arquivo " + e);
        }
    }

    public void lerTrafego(File arq) {

        try (Scanner leitor = new Scanner(arq)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dispositivos = new String[3];
                int j = 0;
                int x = 0;
                String teste[] = linha.split("|");
                for (int i = 0; i < linha.length(); i++) {
                    if (x == 2) { // usado para separar a mensagem depois da segunda |
                        dispositivos[x] = linha.substring(j); // pega os dados da string a partir da ultima |
                    }
                    if (teste[i].equals("|")) { // verifica se a string atual é igual a |
                        dispositivos[x] = linha.substring(j, i); // se for, pega do inicio até a barra e salva no vetor
                        j = (i + 1);
                        x++;
                    }
                }
                System.out.printf("Origem: %s -- Destino: %s -- Mensagem: %s\n", dispositivos[0],
                        dispositivos[1], dispositivos[2]);
            }
        } catch (Exception e) {
            System.err.print("Nao foi possivel criar o arquivo " + e);
        }
    }

}
