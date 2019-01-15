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

import pt.ipleiria.estg.dei.amsi.myscores.Equipa;
import pt.ipleiria.estg.dei.amsi.myscores.User;
import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;

public class SingletonEquipas {
    private static SingletonEquipas instance = null;
    /*private static LocalBaseDados localBaseDados = null;*/

    private static RequestQueue volleyQueue = null;

    private ArrayList<Equipa> equipas;
    private String urlAPI = "http://localhost/MyScoresWebsite/api/web/v1/equipas";

    public static synchronized SingletonEquipas getInstance(Context context){
        if (instance == null){
            instance = new SingletonEquipas(context);
        }
        return instance;
    }

    private SingletonEquipas(Context context){
        this.equipas = new ArrayList<>();
        volleyQueue = Volley.newRequestQueue(context);
    }

    /*public static void iniciarBD(Context context){
        if (localBaseDados == null){
            localBaseDados = new LocalBaseDados(context);
        }
    }*/

    // Métodos para a API
    public void getEquipasAPI(Context context){
        if(hasInternet(context)){
            JsonObjectRequest req = new JsonObjectRequest(
                    Request.Method.GET, urlAPI, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray listaEquipas = response.getJSONArray("equipas");
                                getEquipas().clear();
                                for (int i = 0; i < listaEquipas.length(); i++) {
                                    JSONObject equipa = listaEquipas.getJSONObject(i);

                                    /*getEquipas().add(new Equipa(equipa.getInt("id"),
                                            equipa.getString("name"),
                                            equipa.getString("profession")));*/
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

    public void addEquipasAPI(final Equipa equipa, final Context context){
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
                    params.put("id", String.valueOf(equipa.getId()));
                    /*params.put("name", equipa.getNome());*/
                    /*params.put("profession", equipa.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getEquipasAPI(context);
    }

    public void removeEquipaAPI(final Equipa equipa, Context context){
        if(hasInternet(context)) {
            StringRequest req = new StringRequest(
                    Request.Method.DELETE, urlAPI + "/" + equipa.getId(),
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
        getEquipasAPI(context);
    }

    public void updateEquipaAPI(final int id, final Equipa equipa, final Context context){
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
                    params.put("id", String.valueOf(equipa.getId()));
                    /*params.put("name", equipa.getEquipa());*/
                    /* params.put("profession", equipa.getProfissao());*/

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getEquipasAPI(context);
    }


    // setters e getters
    public ArrayList<Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(ArrayList<Equipa> equipas) {
        this.equipas = equipas;
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
