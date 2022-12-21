package engtelecom.poo;

import java.util.ArrayList;

public class Switch extends Fila {
    public Switch(ArrayList<String> fila, int id) {
        super(fila, id);
    }

    @Override
    public boolean leTrafegoFila() {
        return false;
    }

}
