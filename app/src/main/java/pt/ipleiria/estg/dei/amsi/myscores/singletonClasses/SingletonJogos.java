package pt.ipleiria.estg.dei.amsi.myscores.singletonClasses;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;

public class SingletonJogos extends Application {
    private static RequestQueue volleyQueue = null;
    private static SingletonJogos INSTANCE = null;
    private LocalBaseDados localBD = null;

    private String urlAPIJogos = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/jogos";

    private ArrayList<Jogo> jogos;

    public static synchronized SingletonJogos getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SingletonJogos(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return INSTANCE;
    }

    private SingletonJogos(Context context) {
        jogos = new ArrayList<>();
        localBD = new LocalBaseDados(context);
    }


    public Jogo getJogo(long idJogo){
        for (Jogo jogo : jogos) {
            if (jogo.getId() == idJogo) {
                return jogo;
            }
        }
        return null;
    }

    /*JsonObjectRequest req = new JsonObjectRequest
            (Request.Method.GET, urlAPIJogos, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray listaJogos = response.getJSONArray("");
                        for (int i = 0; i < listaJogos.length(); i++) {

                            JSONObject pessoa = listaJogos.getJSONObject(i);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("Volley", "Error while calling REST API");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("--> ERRO: GETALLUSERSAPI: " + error.getMessage());
                }
            });
            volleyQueue.add(req);*/

    public void getAllJogosAPI(final Context context){
            JsonArrayRequest req = new JsonArrayRequest
                    (Request.Method.GET, urlAPIJogos, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jogoObj = response.getJSONObject(i);
                                    Log.d("TesteJsonLogin", jogoObj.toString());

                                    Jogo jogo = new Jogo(
                                            jogoObj.getInt("id"),
                                            jogoObj.getString("data"),
                                            jogoObj.getString("hora"),
                                            jogoObj.getString("local"));

                                    jogos.add(jogo);
                                    Log.d("testeJogo", jogos.toString());
                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("--> ERRO: GETALLUSERSAPI: " + error.getMessage());
                        }
                    });
            volleyQueue.add(req);
    }

    public ArrayList<Jogo> getJogo(){
        return jogos;
    }

}
