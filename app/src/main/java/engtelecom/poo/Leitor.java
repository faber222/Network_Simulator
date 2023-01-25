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
                        ArrayList<String> primeiraTabela = super.getSwitchs().getOrDefault(segundaColuna,
                                new ArrayList<>());
                        primeiraTabela.add(primeiraColuna);
                        super.getSwitchs().put(segundaColuna, primeiraTabela);
                        break;
                    case 's':
                        ArrayList<String> tabela = super.getSwitchs().getOrDefault(primeiraColuna, new ArrayList<>());
                        tabela.add(segundaColuna);
                        super.getSwitchs().put(primeiraColuna, tabela);

                        switch (segundaColuna.charAt(0)) {
                            case 'h':
                                super.getHosts().put(segundaColuna, primeiraColuna);
                                break;
                            case 's':
                                ArrayList<String> segundaTabela = super.getSwitchs().getOrDefault(segundaColuna,
                                        new ArrayList<>());
                                segundaTabela.add(primeiraColuna);
                                super.getSwitchs().put(segundaColuna, segundaTabela);
                                break;
                            default:
                                break;
                        }
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
