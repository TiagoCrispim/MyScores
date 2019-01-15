package pt.ipleiria.estg.dei.amsi.myscores;

public class User {
    private int id;
    private String username;
    private String nome;
    private String passwordHash;
    private String email;
    private String dataNascimento;
    private String nacionalidade;
    private String golosMarcados;
    private String jogosJogados;

    public User(int id, String username, String nome, String passwordHash, String email, String dataNascimento, String nacionalidade, String golosMarcados, String jogosJogados) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.passwordHash = passwordHash;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.golosMarcados = golosMarcados;
        this.jogosJogados = jogosJogados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGolosMarcados() {
        return golosMarcados;
    }

    public void setGolosMarcados(String golosMarcados) {
        this.golosMarcados = golosMarcados;
    }

    public String getJogosJogados() {
        return jogosJogados;
    }

    public void setJogosJogados(String jogosJogados) {
        this.jogosJogados = jogosJogados;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
