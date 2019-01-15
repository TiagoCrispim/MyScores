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
import pt.ipleiria.estg.dei.amsi.myscores.User;
import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;

public class SingletonUsers {
    private static SingletonUsers instance = null;
    /*private static LocalBaseDados localBaseDados = null;*/

    private static RequestQueue volleyQueue = null;

    private ArrayList<User> users;
    private String urlAPI = "http://localhost/MyScoresWebsite/api/web/v1/users";

    public static synchronized SingletonUsers getInstance(Context context){
        if (instance == null){
            instance = new SingletonUsers(context);
        }
        return instance;
    }

    private SingletonUsers(Context context){
        this.users = new ArrayList<>();
        volleyQueue = Volley.newRequestQueue(context);
    }

    /*public static void iniciarBD(Context context){
        if (localBaseDados == null){
            localBaseDados = new LocalBaseDados(context);
        }
    }*/

    // Métodos para a API
    public void getUsersAPI(Context context){
        if(hasInternet(context)){
            JsonObjectRequest req = new JsonObjectRequest(
                    Request.Method.GET, urlAPI, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray listaUsers = response.getJSONArray("users");
                                getUsers().clear();
                                for (int i = 0; i < listaUsers.length(); i++) {
                                    JSONObject user = listaUsers.getJSONObject(i);

                                    getUsers().add(new User(user.getInt("id"),
                                            user.getString("username"),
                                            user.getString("nome"),
                                            user.getString("password_hash"),
                                            user.getString("email"),
                                            user.getString("dataNascimento"),
                                            user.getString("nacionalidade"),
                                            user.getString("golosMaracados"),
                                            user.getString("jogosJogados")));
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

    public void addPessoaAPI(final User user, final Context context){
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
                    params.put("id", String.valueOf(user.getId()));
                    params.put("username", user.getUsername());
                    params.put("nome", user.getNome());
                    params.put("passqord_hash", user.getPasswordHash());
                    params.put("email", user.getEmail());
                    params.put("dataNascimento", user.getDataNascimento());
                    params.put("nacionalidade", user.getNacionalidade());
                    params.put("golosMarcados", user.getGolosMarcados());
                    params.put("jogosJogados", user.getJogosJogados());

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getUsersAPI(context);
    }

    public void removeUserAPI(final User user, Context context){
        if(hasInternet(context)) {
            StringRequest req = new StringRequest(
                    Request.Method.DELETE, urlAPI + "/" + user.getId(),
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
        getUsersAPI(context);
    }

    public void updateUserAPI(final int id, final User user, final Context context){
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
                    params.put("id", String.valueOf(user.getId()));
                    params.put("username", user.getUsername());
                    params.put("nome", user.getNome());
                    params.put("passqord_hash", user.getPasswordHash());
                    params.put("email", user.getEmail());
                    params.put("dataNascimento", user.getDataNascimento());
                    params.put("nacionalidade", user.getNacionalidade());
                    params.put("golosMarcados", user.getGolosMarcados());
                    params.put("jogosJogados", user.getJogosJogados());

                    return params;
                }
            };
            volleyQueue.add(req);
        }
        getUsersAPI(context);
    }


    // setters e getters
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
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
