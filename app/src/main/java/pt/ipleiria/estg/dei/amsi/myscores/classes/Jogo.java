package pt.ipleiria.estg.dei.amsi.myscores.classes;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Jogo implements Serializable {

    private int id;
    private String data;
    private String hora;
    private String local;

    public Jogo(int id, String data, String hora, String local) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.local = local;
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

}
