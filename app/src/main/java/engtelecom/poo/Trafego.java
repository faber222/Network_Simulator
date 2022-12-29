package engtelecom.poo;

public class Trafego {
    private int ttl;
    private String conteudo;
    private String hostOrigem;
    private String hostDestino;
    private int id;

    public Trafego(int ttl, String conteudo, String hostOrigem, String hostDestino, int id) {
        this.ttl = ttl;
        this.conteudo = conteudo;
        this.hostOrigem = hostOrigem;
        this.hostDestino = hostDestino;
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public String getHostOrigem() {
        return hostOrigem;
    }

    public void setHostOrigem(String hostOrigem) {
        this.hostOrigem = hostOrigem;
    }

    public String getHostDestino() {
        return hostDestino;
    }

    public void setHostDestino(String hostDestino) {
        this.hostDestino = hostDestino;
    }
    
}
