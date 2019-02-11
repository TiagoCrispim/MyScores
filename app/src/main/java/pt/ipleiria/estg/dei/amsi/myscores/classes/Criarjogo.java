package pt.ipleiria.estg.dei.amsi.myscores.classes;

public class Criarjogo {
    private int id_criador;
    private int gJogador1A;
    private int gJogador2A;
    private int gJogador3A;
    private int gJogador4A;
    private int gJogador5A;
    private int gJogador6A;
    private int gJogador7A;
    private int gJogador8A;
    private int gJogador9A;
    private int gJogador10A;
    private int gJogador1B;
    private int gJogador2B;
    private int gJogador3B;
    private int gJogador4B;
    private int gJogador5B;
    private int gJogador6B;
    private int gJogador7B;
    private int gJogador8B;
    private int gJogador9B;
    private int gJogador10B;
    private String local;
    private String data;
    private String hora;

    public Criarjogo(int id_criador, int gJogador1A, int gJogador2A, int gJogador3A, int gJogador4A, int gJogador5A, int gJogador6A, int gJogador7A, int gJogador8A, int gJogador9A, int gJogador10A, int gJogador1B, int gJogador2B, int gJogador3B, int gJogador4B, int gJogador5B, int gJogador6B, int gJogador7B, int gJogador8B, int gJogador9B, int gJogador10B, String local, String data, String hora) {
        this.id_criador = id_criador;
        this.gJogador1A = gJogador1A;
        this.gJogador2A = gJogador2A;
        this.gJogador3A = gJogador3A;
        this.gJogador4A = gJogador4A;
        this.gJogador5A = gJogador5A;
        this.gJogador6A = gJogador6A;
        this.gJogador7A = gJogador7A;
        this.gJogador8A = gJogador8A;
        this.gJogador9A = gJogador9A;
        this.gJogador10A = gJogador10A;
        this.gJogador1B = gJogador1B;
        this.gJogador2B = gJogador2B;
        this.gJogador3B = gJogador3B;
        this.gJogador4B = gJogador4B;
        this.gJogador5B = gJogador5B;
        this.gJogador6B = gJogador6B;
        this.gJogador7B = gJogador7B;
        this.gJogador8B = gJogador8B;
        this.gJogador9B = gJogador9B;
        this.gJogador10B = gJogador10B;
        this.local = local;
        this.data = data;
        this.hora = hora;
    }

    public int getId_criador() {
        return id_criador;
    }

    public void setId_criador(int id_criador) {
        this.id_criador = id_criador;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
