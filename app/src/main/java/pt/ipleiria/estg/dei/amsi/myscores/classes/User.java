package pt.ipleiria.estg.dei.amsi.myscores.classes;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private String nome;
    private String passwordHash;
    private String email;
    private String dataNascimento;
    private String nacionalidade;
    private String auth_key;

    public User(int id, String username, String nome, String passwordHash, String email, String dataNascimento, String nacionalidade, String auth_key) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.passwordHash = passwordHash;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.auth_key = auth_key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public User(){

    }

    @Override
    public String toString() {
        return username + nome + email + dataNascimento + nacionalidade;
    }



}
