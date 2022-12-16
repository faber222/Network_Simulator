package engtelecom.poo;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    public void lerTopologia(File arq) {
        // Hashtable<String, String> maquinas = new Hashtable<String, String>();

        Map<String, String> maquinas = new HashMap<String, String>();

        try (Scanner leitor = new Scanner(arq)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dispositivos = linha.split("--");
                // String key;
                // int value;
                maquinas.put(dispositivos[0], dispositivos[1]);
                // for (String nome : dispositivos) {
                //     key = nome.substring(0, 1);
                //     value = Integer.parseInt(nome.substring(1));
                //     maquinas.put(key, value);
                // }
                System.out.printf("Origem: %s -- Destino: %s\n", dispositivos[0],
                        dispositivos[1]);

                // System.out.println(leitor.nextLine());
            }
            System.out.println(maquinas.size());
            Set<String> keys = maquinas.keySet();
            for (String teste : keys) {
                System.out.println("o valor de " + teste + " é: " + maquinas.get(teste));
            }
        } catch (Exception e) {
            System.err.print("Não foi possivel criar o arquivo " + e);
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
            System.err.print("Não foi possivel criar o arquivo " + e);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        File arquivo = new File("topologia.txt");
        File arquivo2 = new File("trafego.txt");

        app.lerTopologia(arquivo);
        app.lerTrafego(arquivo2);

    }
}
