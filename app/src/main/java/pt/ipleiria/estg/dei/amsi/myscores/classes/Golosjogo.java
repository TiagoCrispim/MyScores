package pt.ipleiria.estg.dei.amsi.myscores.classes;

public class Golosjogo {
    private String id;
    private String idJogador;
    private String golosMarcados;

    public Golosjogo(String id, String idJogador, String golosMarcados) {
        this.id = id;
        this.idJogador = idJogador;
        this.golosMarcados = golosMarcados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(String idJogador) {
        this.idJogador = idJogador;
    }

    public String getGolosMarcados() {
        return golosMarcados;
    }

    public void setGolosMarcados(String golosMarcados) {
        this.golosMarcados = golosMarcados;
    }
}
