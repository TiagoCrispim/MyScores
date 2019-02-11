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
import pt.ipleiria.estg.dei.amsi.myscores.classes.EquipaA;

public class SingletonEquipaB {

    private static RequestQueue volleyQueue = null;
    private static SingletonEquipaB INSTANCE = null;
    private LocalBaseDados localBD = null;

    private String dadosEquipaB;

    private String urlAPIEquipa = "http://6f453dab.ngrok.io/MyScoresWebsite/api/web/v1/equipas/criarequipa";

    private ArrayList<EquipaA> equipaA;

    public static synchronized SingletonEquipaB getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SingletonEquipaB(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return INSTANCE;
    }

    private SingletonEquipaB(Context context) {
        equipaA = new ArrayList<>();
        localBD = new LocalBaseDados(context);
    }

    public String returnDadosEquipaB(){
        return dadosEquipaB;
    }

    public void equipaBAPI(final int id_criador, final String nome, final String username1, final String username2, final String username3, final String username4, final String username5, final String username6, final String username7, final String username8, final String username9, final String username10,final Context context){
        StringRequest req = new StringRequest
                (Request.Method.POST, urlAPIEquipa, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("--> EQUIPA B:: RESPOSTA EQUIPA B POST : " + response);
                        Log.d("TesteRegisto", response);

                        dadosEquipaB = response;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dadosEquipaB = null;

                        VolleyLog.d("CRIAR EQUIPA B:: Errorrr: " + error.getMessage());
                        Log.d("TesteEquipaA", error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_criador", String.valueOf(id_criador));
                params.put("name", nome);
                params.put("username1", username1);
                params.put("username2", username2);
                params.put("username3", username3);
                params.put("username4", username4);
                params.put("username5", username5);
                params.put("username6", username6);
                params.put("username7", username7);
                params.put("username8", username8);
                params.put("username9", username9);
                params.put("username10", username10);

                return params;
            }

        };
        volleyQueue.add(req);
    }

}
