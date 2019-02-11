package pt.ipleiria.estg.dei.amsi.myscores.singletonClasses;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;
import pt.ipleiria.estg.dei.amsi.myscores.classes.Criarjogo;
import pt.ipleiria.estg.dei.amsi.myscores.classes.EquipaA;

public class SingletonCriarjogo {
    private static RequestQueue volleyQueue = null;
    private static SingletonCriarjogo INSTANCE = null;
    private LocalBaseDados localBD = null;

    private String dadosCriarjogo;

    private String urlAPIEquipa = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/equipas/criarequipa";

    private ArrayList<Criarjogo> criarJogo;

    public static synchronized SingletonCriarjogo getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SingletonCriarjogo(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return INSTANCE;
    }

    private SingletonCriarjogo(Context context) {
        criarJogo = new ArrayList<>();
        localBD = new LocalBaseDados(context);
    }

    public String returnDadosCriarjogo(){
        return dadosCriarjogo;
    }

    public void criarJogoAPI(final int id_criador, final String hora, final String local, final String data, final String gJ1A, final String gJ2A, final String gJ3A, final String gJ4A, final String gJ5A, final String gJ1B, final String gJ2B, final String gJ3B, final String gJ4B, final String gJ5B, final Context context){
        StringRequest req = new StringRequest
                (Request.Method.POST, urlAPIEquipa, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("--> DETALHES:: RESPOSTA DETALHES POST : " + response);
                        Log.d("TesteRegisto", response);

                        dadosCriarjogo = response;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dadosCriarjogo = null;

                        VolleyLog.d("CRIAR DETALHES:: Errorrr: " + error.getMessage());
                        Log.d("TesteEquipaA", error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_criador", String.valueOf(id_criador));
                params.put("hora", hora);
                params.put("local", local);
                params.put("data", data);
                params.put("jogadorA0", gJ1A);
                params.put("jogadorA1", gJ2A);
                params.put("jogadorA2", gJ3A);
                params.put("jogadorA3", gJ4A);
                params.put("jogadorA4", gJ5A);
                params.put("jogadorB0", gJ1B);
                params.put("jogadorB1", gJ2B);
                params.put("jogadorB2", gJ3B);
                params.put("jogadorB3", gJ4B);
                params.put("jogadorB4", gJ5B);

                return params;
            }

        };
        volleyQueue.add(req);
    }
}
