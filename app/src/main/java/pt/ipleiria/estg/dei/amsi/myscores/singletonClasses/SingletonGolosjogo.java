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

import pt.ipleiria.estg.dei.amsi.myscores.classes.Golosjogo;

public class SingletonGolosjogo {
    private static SingletonGolosjogo instance = null;
    /*private static LocalBaseDados localBaseDados = null;*/

    private static RequestQueue volleyQueue = null;

    private ArrayList<Golosjogo> golosjogos;
    private String urlAPI = "http://localhost/MyScoresWebsite/api/web/v1/";

    public static synchronized SingletonGolosjogo getInstance(Context context){
        if (instance == null){
            instance = new SingletonGolosjogo(context);
        }
        return instance;
    }

    private SingletonGolosjogo(Context context){
        this.golosjogos = new ArrayList<>();
        volleyQueue = Volley.newRequestQueue(context);
    }

    /*public static void iniciarBD(Context context){
        if (localBaseDados == null){
            localBaseDados = new LocalBaseDados(context);
        }
    }*/

    // Métodos para a API
    public void getGolosjogoAPI(Context context){
        if(hasInternet(context)){
            JsonObjectRequest req = new JsonObjectRequest(
                    Request.Method.GET, urlAPI, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray listaGolosjogo = response.getJSONArray("equipas");
                                getGolosjogo().clear();
                                for (int i = 0; i < listaGolosjogo.length(); i++) {
                                    JSONObject golosjogo = listaGolosjogo.getJSONObject(i);

                                    /*getGolosjogo().add(new Equipa(golosjogo.getInt("id"),
                                            golosjogo.getString("name"),
                                            golosjogo.getString("profession")));*/
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

    public void addGolosjogoAPI(final Golosjogo golosjogo, final Context context){
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
                    params.put("id", String.valueOf(golosjogo.getId()));
                    /*params.put("name", golosjogo.getNome());*/
                    /*params.put("profession", golosjogo.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getGolosjogoAPI(context);
    }

    public void removeGolosjogoAPI(final Golosjogo golosjogo, Context context){
        if(hasInternet(context)) {
            StringRequest req = new StringRequest(
                    Request.Method.DELETE, urlAPI + "/" + golosjogo.getId(),
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
        getGolosjogoAPI(context);
    }

    public void updateGolosjogoAPI(final int id, final Golosjogo golosjogo, final Context context){
        if(hasInternet(context)) {
            StringRequest req = new StringRequest(
                    Request.Method.POST, urlAPI + "/" + id,
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
                    params.put("id", String.valueOf(golosjogo.getId()));
                    /*params.put("name", golosjogo.getGolosjogo());*/
                    /* params.put("profession", golosjogoa.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getGolosjogoAPI(context);
    }


    // setters e getters
    public ArrayList<Golosjogo> getGolosjogo() {
        return golosjogos;
    }

    public void setGolosjogos(ArrayList<Golosjogo> golosjogos) {
        this.golosjogos = golosjogos;
    }


    // teste de ligação à internet
    private static boolean hasInternet(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}
