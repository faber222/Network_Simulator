package engtelecom.poo;

import java.util.ArrayList;

public interface LeitorFila {
    public abstract boolean leTrafegoFila();
    
    public abstract int getGerados();

    public abstract int getProcessados();

    public abstract int getDescartados();

    public abstract void setGerados(int gerados);

    public abstract void setProcessados(int processados);

    public abstract void setDescartados(int descartados);

    public abstract ArrayList<String> getFila();

    public abstract ArrayList<Switch> getConexaoSwitch();

    public abstract ArrayList<Computer> getConexaoPc();

    public abstract int getId();

    public abstract void setConexaoSwitch(ArrayList<Switch> conexaoSwitch);

    public abstract void setConexaoPc(ArrayList<Computer> conexaoPc);

    public abstract void imprimeFinal(int x);
}
