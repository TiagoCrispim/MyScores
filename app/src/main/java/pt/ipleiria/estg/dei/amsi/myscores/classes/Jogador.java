package pt.ipleiria.estg.dei.amsi.myscores.classes;

public class Jogador {
    private int fotoJogador;
    private String nomeJogador;

    public Jogador(String nomeJogador, int fotoJogador) {
        this.nomeJogador = nomeJogador;
        this.fotoJogador = fotoJogador;
    }

    public int getFotoJogador() {
        return fotoJogador;
    }

    public void setFotoJogador(int fotoJogador) {
        this.fotoJogador = fotoJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

}
