package engtelecom.poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Leitor extends Maquinas {
    public Leitor(Map<String, String> hosts, Map<String, ArrayList<String>> switchs, ArrayList<String> trafego) {
        super(hosts, switchs, trafego);
    }

    // public void teste(File arq) {
    //     try (Scanner leitor = new Scanner(arq)) {
    //         while (leitor.hasNextLine()) {
    //             String linha = leitor.nextLine();
    //             String[] dispositivos = linha.split("--");
    //             String[] primeiraColuna = dispositivos[0].split("");
    //             String[] segundaColuna = dispositivos[1].split("");

    //             // captura os hosts e suas ligacoes
    //             if (primeiraColuna[0].equals("h")) {
    //                 super.getHosts().put(dispositivos[0], dispositivos[1]);
    //             }
    //             if (segundaColuna[0].equals("h") && !primeiraColuna[0].equals("h")) {
    //                 super.getHosts().put(dispositivos[1], dispositivos[0]);
    //             }

    //             // captura todas as conexoes dos switchs
    //             if (primeiraColuna[0].equals("h") && segundaColuna[0].equals("s")) {
    //                 ArrayList<String> tabela = new ArrayList<String>();
    //                 if (super.getSwitchs().containsKey(dispositivos[1])) {
    //                     tabela = (super.getSwitchs().get(dispositivos[1]));
    //                 }
    //                 tabela.add(dispositivos[0]);
    //                 super.getSwitchs().put(dispositivos[1], tabela);
    //             }
    //             if (primeiraColuna[0].equals("s") && segundaColuna[0].equals("h")) {
    //                 ArrayList<String> tabela = new ArrayList<String>();
    //                 if (super.getSwitchs().containsKey(dispositivos[0])) {
    //                     tabela = (super.getSwitchs().get(dispositivos[0]));
    //                 }
    //                 tabela.add(dispositivos[1]);
    //                 super.getSwitchs().put(dispositivos[0], tabela);
    //             }
    //             if (primeiraColuna[0].equals("s") && segundaColuna[0].equals("s")) {
    //                 ArrayList<String> tabela = new ArrayList<String>();
    //                 if (super.getSwitchs().containsKey(dispositivos[0])) {
    //                     tabela = (super.getSwitchs().get(dispositivos[0]));
    //                 }
    //                 tabela.add(dispositivos[1]);
    //                 super.getSwitchs().put(dispositivos[0], tabela);

    //                 if (super.getSwitchs().containsKey(dispositivos[1])) {
    //                     tabela = (super.getSwitchs().get(dispositivos[1]));
    //                 }
    //                 tabela.add(dispositivos[0]);
    //                 super.getSwitchs().put(dispositivos[1], tabela);
    //             }

    //         }
    //     } catch (Exception e) {
    //         System.err.print("Nao foi possivel criar o arquivo " + e);
    //     }
    // }

    public void lerTopologia(File arq) {
        try (Scanner leitor = new Scanner(arq)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine().trim();
                String[] dispositivos = linha.split("--");
                String primeiraColuna = dispositivos[0].trim();
                String segundaColuna = dispositivos[1].trim();

                switch (primeiraColuna.charAt(0)) {
                    case 'h':
                        super.getHosts().put(primeiraColuna, segundaColuna);
                        break;
                    case 's':
                        ArrayList<String> tabela = super.getSwitchs().getOrDefault(primeiraColuna, new ArrayList<>());
                        tabela.add(segundaColuna);
                        super.getSwitchs().put(primeiraColuna, tabela);
                        break;
                    default:
                        break;
                }
                switch (segundaColuna.charAt(0)) {
                    case 'h':
                        super.getHosts().put(segundaColuna, primeiraColuna);
                        break;
                    case 's':
                        ArrayList<String> tabela = super.getSwitchs().getOrDefault(segundaColuna, new ArrayList<>());
                        tabela.add(primeiraColuna);
                        super.getSwitchs().put(segundaColuna, tabela);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.print("Não foi possível encontrar o arquivo: " + e.getMessage());
        }
    }

    public void capturaTrafego(File arq) {
        try (Scanner leitor = new Scanner(arq)) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                super.getTrafego().add(linha);
            }
        } catch (Exception e) {
            System.err.print("Nao foi possivel criar o arquivo captura trafego " + e);
        }
    }
}
