package engtelecom.poo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Logger{
    private String mensagem;
    private String hostDestino;
    private String hostOrigem;
    private String instante;

    public Logger (String mensagem, String hostDestino, String hostOrigem, int instante){
        this.mensagem = mensagem;
        this.hostDestino = hostDestino;
        this.hostOrigem = hostOrigem;
        this.instante = String.valueOf(instante);
    }

    public void writeLog() {
        File arquivo;
        try {
            arquivo = new File("../arquivo.txt");
            FileWriter fwArquivo = null;

            if (arquivo.exists() == true) {// Abre para adicionar dados
                fwArquivo = new FileWriter(arquivo, true);
            } else { // se n~ao existir, ent~ao cria o arquivo
                fwArquivo = new FileWriter(arquivo);
            }
            BufferedWriter bw = new BufferedWriter(fwArquivo);
            bw.write("Ol´a mundo\n");

             // fechando arquivo
            bw.close();
            fwArquivo.close();
        } catch (Exception e) {
            System.err.println("saindo");
        }
    }
}