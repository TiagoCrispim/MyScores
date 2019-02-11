package pt.ipleiria.estg.dei.amsi.myscores.singletonClasses;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;
import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;

public class SingletonUsers extends Application {
    private static RequestQueue volleyQueue = null;
    private static SingletonUsers INSTANCE = null;
    private LocalBaseDados localBD = null;


    private String urlAPIUsers = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/users";
    private String urlAPIUsersLogin = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/users/login";
    private String urlAPIUsersRegisto = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/users/registo";

    private ArrayList<User> users;
    private String dadosLogin;
    private String dadosRegisto;

    public static synchronized SingletonUsers getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SingletonUsers(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return INSTANCE;
    }

    private SingletonUsers(Context context) {
        users = new ArrayList<>();
        localBD = new LocalBaseDados(context);
    }

    public void getAllUsersAPI(final Context context){
        JsonArrayRequest req = new JsonArrayRequest
                (Request.Method.GET, urlAPIUsers, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject userObj = response.getJSONObject(i);
                                Log.d("TesteJsonLogin", userObj.toString());

                                User user = new User(
                                        userObj.getInt("id"),
                                        userObj.getString("username"),
                                        userObj.getString("nome"),
                                        userObj.getString("password_hash"),
                                        userObj.getString("email"),
                                        userObj.getString("dataNascimento"),
                                        userObj.getString("nacionalidade"),
                                        userObj.getString("auth_key"));

                                users.add(user);
                                /*Log.d("testeUser", users.toString());
                                Log.d("testeUser", String.valueOf(users.size()));*/
                                if (!SingletonUsers.getInstance(context).localBD.CheckUser((int)user.getId())) {
                                    SingletonUsers.getInstance(context).localBD.InsertUser(user);
                                }
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

    public void loginAPI(final String username, final String password, final Context context){
        StringRequest req = new StringRequest
                (Request.Method.POST, urlAPIUsersLogin, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("--> LOGIN:: RESPOSTA LOGIN POST : " + response);
                        try {
                            users.clear();
                            JSONObject userObj = new JSONObject(response);
                            Log.d("TesteJsonLogin", userObj.toString());

                            User user = new User(
                                    userObj.getInt("id"),
                                    userObj.getString("username"),
                                    userObj.getString("nome"),
                                    userObj.getString("password_hash"),
                                    userObj.getString("email"),
                                    userObj.getString("dataNascimento"),
                                    userObj.getString("nacionalidade"),
                                    userObj.getString("auth_key"));

                            users.add(user);
                                    /*if (!SingletonUsers.getInstance(context).localBD.CheckUser((int)user.getId())) {
                                        SingletonUsers.getInstance(context).localBD.InsertUser(user);
                                    }*/
                                   dadosLogin = response;


                            Log.d("TesteUser", users.toString());

                        } catch (Throwable e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dadosLogin = null;
                        VolleyLog.d("LOGIN:: Errorrr: " + error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);

                return params;
            }

        };
        volleyQueue.add(req);
    }

    public ArrayList<User> getUser(){
        /*users.clear();*/
        return users;
    }

    public String returnDadosLogin(){
        return dadosLogin;
    }

    public String returnDadosRegisto(){
        return dadosRegisto;
    }

    public void registoAPI(final String username, final String nome, final String dataNascimento, final String email, final String nacionalidade, final String password, final Context context){
        StringRequest req = new StringRequest
                (Request.Method.POST, urlAPIUsersRegisto, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("--> REGISTO:: RESPOSTA RREGISTO POST : " + response);
                        Log.d("TesteRegisto", response);

                        dadosRegisto = response;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dadosLogin = null;
                        VolleyLog.d("REGISTO:: Errorrr: " + error.getMessage());
                        Log.d("TesteRegisto", error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("nome", nome);
                params.put("dataNascimento", dataNascimento);
                params.put("email", email);
                params.put("nacionalidade", nacionalidade);
                params.put("password", password);

                return params;
            }

        };
        volleyQueue.add(req);
    }

    /*public void editarUserAPI(final long idUser, final User user, final String username, final String nome, final String dataNascimento, final String email, final String nacionalidade, final String password, final Context context){
        StringRequest req = new StringRequest
                (Request.Method.PUT, urlAPIUsers +'/'+idUser, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("--> RESPOSTA PUT : " + response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("--> ERROR: RESPOSTA PUT : "+error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("nome", nome);
                params.put("dataNascimento", dataNascimento);
                params.put("email", email);
                params.put("nacionalidade", nacionalidade);
                params.put("password", password);


                return params;
            }
        };
        volleyQueue.add(req);
    }*/

}
