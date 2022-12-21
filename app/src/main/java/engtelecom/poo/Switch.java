package engtelecom.poo;

import java.util.ArrayList;

public class Switch extends Fila {
    private int seq;

    public Switch(ArrayList<String> fila, int id) {
        super(fila, id);
        this.seq = 0;
    }

    @Override
    public boolean leTrafegoFila() {
        for (int y = 0; y < super.getFila().size(); y++) {
            String linha = super.getFila().get(getSeq());
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
            System.out.print("Switch: " + super.getId());
            System.out.printf(" Origem: %s -- Destino: %s -- Mensagem: %s\n", dispositivos[0],
                    dispositivos[1], dispositivos[2]);
            setSeq(getSeq() + 1);
        }
        return false;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
