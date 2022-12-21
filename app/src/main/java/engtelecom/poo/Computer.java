package engtelecom.poo;

import java.util.ArrayList;

public class Computer extends Fila {
    public Computer(ArrayList<String> fila, int id) {
        super(fila, id);
    }

    @Override
    public boolean leTrafegoFila() {
        return false;
    }

}
