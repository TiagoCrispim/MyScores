package pt.ipleiria.estg.dei.amsi.myscores;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Jogo implements Serializable {

    private int id;
    private String data;
    private String hora;
    private String local;
    private String idEquipa1;
    private String idEquipa2;
    private String golosEquipa1;
    private String golosEquipa2;

    public Jogo(int id, String data, String hora, String local, String idEquipa1, String idEquipa2, String golosEquipa1, String golosEquipa2) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.idEquipa1 = idEquipa1;
        this.idEquipa2 = idEquipa2;
        this.golosEquipa1 = golosEquipa1;
        this.golosEquipa2 = golosEquipa2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getIdEquipa1() {
        return idEquipa1;
    }

    public void setIdEquipa1(String idEquipa1) {
        this.idEquipa1 = idEquipa1;
    }

    public String getIdEquipa2() {
        return idEquipa2;
    }

    public void setIdEquipa2(String idEquipa2) {
        this.idEquipa2 = idEquipa2;
    }

    public String getGolosEquipa1() {
        return golosEquipa1;
    }

    public void setGolosEquipa1(String golosEquipa1) {
        this.golosEquipa1 = golosEquipa1;
    }

    public String getGolosEquipa2() {
        return golosEquipa2;
    }

    public void setGolosEquipa2(String golosEquipa2) {
        this.golosEquipa2 = golosEquipa2;
    }
}
