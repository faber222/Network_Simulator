package engtelecom.poo;

public class Trafego {
    private int ttl;
    private String conteudo;
    private int id;

    public Trafego(int ttl, String conteudo, int id) {
        this.ttl = ttl;
        this.conteudo = conteudo;
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
    
}
