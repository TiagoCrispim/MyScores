package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogador;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonEquipaA;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonEquipaB;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCriarEquipaB extends Fragment {

    private EditText nomeEquipa, jogador1, jogador2, jogador3, jogador4, jogador5, jogador6, jogador7, jogador8, jogador9, jogador10;

    private Button guaradarEquipa;

    public fragmentCriarEquipaB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_equipa_b, container, false);

        guaradarEquipa = (Button) view.findViewById(R.id.btGuardarEquipaB);
        nomeEquipa = (EditText) view.findViewById(R.id.tilNomeEquipaB);
        jogador1 = (EditText) view.findViewById(R.id.tilJogador1B);
        jogador2 = (EditText) view.findViewById(R.id.tilJogador2B);
        jogador3 = (EditText) view.findViewById(R.id.tilJogador3B);
        jogador4 = (EditText) view.findViewById(R.id.tilJogador4B);
        jogador5 = (EditText) view.findViewById(R.id.tilJogador5B);
        jogador6 = (EditText) view.findViewById(R.id.tilJogador6B);
        jogador7 = (EditText) view.findViewById(R.id.tilJogador7B);
        jogador8 = (EditText) view.findViewById(R.id.tilJogador8B);
        jogador9 = (EditText) view.findViewById(R.id.tilJogador9B);
        jogador10 = (EditText) view.findViewById(R.id.tilJogador10B);

        guaradarEquipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarEquipa();
            }
        });


        return view;
    }

    public void criarEquipa() {

        SharedPreferences sharedPreferences = this.getContext().getSharedPreferences("userShared",Context.MODE_PRIVATE);
        int idUser = sharedPreferences.getInt("userid", 0);

        String nomeEquipa = this.nomeEquipa.getText().toString();
        String jogador1 = this.jogador1.getText().toString();
        String jogador2 = this.jogador2.getText().toString();
        String jogador3 = this.jogador3.getText().toString();
        String jogador4 = this.jogador4.getText().toString();
        String jogador5 = this.jogador5.getText().toString();
        String jogador6 = this.jogador6.getText().toString();
        String jogador7 = this.jogador7.getText().toString();
        String jogador8 = this.jogador8.getText().toString();
        String jogador9 = this.jogador9.getText().toString();
        String jogador10 = this.jogador10.getText().toString();


        SingletonEquipaB.getInstance(getContext()).equipaBAPI(idUser, nomeEquipa, jogador1, jogador2, jogador3, jogador4, jogador5, jogador6, jogador7, jogador8, jogador9, jogador10, getContext());

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                checkEquipaB();
            }
        },5000);

    }

    public void checkEquipaB() {
        String dados = SingletonEquipaB.getInstance(getContext()).returnDadosEquipaB();

        if (dados == null) {
            Toast.makeText(getContext(), "Something's Wrong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Equipa A was created", Toast.LENGTH_LONG).show();
        }
    }

}
