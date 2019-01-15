package pt.ipleiria.estg.dei.amsi.myscores.singletonClasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pt.ipleiria.estg.dei.amsi.myscores.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;

public class SingletonJogos {
    private static SingletonJogos instance = null;
    private static LocalBaseDados localBaseDados = null;

    private static RequestQueue volleyQueue = null;

    private ArrayList<Jogo> jogos;
    private String urlAPI = "http://localhost/MyScoresWebsite/api/web/v1/jogos";

    public static synchronized SingletonJogos getInstance(Context context){
        if (instance == null){
            instance = new SingletonJogos(context);
        }
        return instance;
    }

    private SingletonJogos(Context context){
        this.jogos = new ArrayList<>();
        volleyQueue = Volley.newRequestQueue(context);
    }

    public static void iniciarBD(Context context){
        if (localBaseDados == null){
            localBaseDados = new LocalBaseDados(context);
        }
    }

    // Métodos para a API
    public void getJogosAPI(Context context){
        if(hasInternet(context)){
            JsonObjectRequest req = new JsonObjectRequest(
                    Request.Method.GET, urlAPI, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray listaJogos = response.getJSONArray("users");
                                getJogos().clear();
                                for (int i = 0; i < listaJogos.length(); i++) {
                                    JSONObject jogo = listaJogos.getJSONObject(i);

                                    /*getJogos().add(new Jogo(jogo.getInt("id"),
                                            jogo.getString("name"),
                                            jogo.getString("profession")));*/
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("Volley", "Error while calling REST API");
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Volley", error.toString());
                        }
                    });
            volleyQueue.add(req);
        }
    }

    public void addPessoaAPI(final Jogo jogo, final Context context){
        if(hasInternet(context)) {
            StringRequest req = new StringRequest(
                    Request.Method.PUT, urlAPI,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("Volley", response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley", "ERRO ADD: " + error.getMessage());
                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("id", String.valueOf(jogo.getId()));
                    /*params.put("name", jogo.getNome());*/
                    /*params.put("profession", jogo.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getJogosAPI(context);
    }

    public void removePessoaAPI(final Jogo jogo, Context contexto){
        if(hasInternet(contexto)) {
            StringRequest req = new StringRequest(
                    Request.Method.DELETE, urlAPI + "/" + jogo.getId(),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("Volley", response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley", "ERRO REMOVE: " + error.getMessage());
                }
            });
            volleyQueue.add(req);
        }
        getJogosAPI(contexto);
    }

    public void updatePessoaAPI(final int idPessoa, final Jogo jogo, final Context contexto){
        if(hasInternet(contexto)) {
            StringRequest req = new StringRequest(
                    Request.Method.POST, urlAPI + "/" + idPessoa,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("Volley", response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley", "ERRO UPDATE: " + error.getMessage());
                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("id", String.valueOf(jogo.getId()));
                    /*params.put("name", jogo.getNome());*/
                   /* params.put("profession", jogo.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getJogosAPI(contexto);
    }


    // setters e getters
    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setPessoas(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }


    // teste de ligação à internet
    private static boolean hasInternet(Context contexto){
        ConnectivityManager cm =
                (ConnectivityManager)contexto.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}
