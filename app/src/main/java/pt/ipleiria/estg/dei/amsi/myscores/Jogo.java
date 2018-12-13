package pt.ipleiria.estg.dei.amsi.myscores;

public class Jogo {

    String resultado;
    String resultadoJogo;
    String data;


    public Jogo(String resultado, String resultadoJogo, String data) {
        this.resultado = resultado;
        this.resultadoJogo = resultadoJogo;
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultadoJogo() {
        return resultadoJogo;
    }

    public void setResultadoJogo(String resultadoJogo) {
        this.resultadoJogo = resultadoJogo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
