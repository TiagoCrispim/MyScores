package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.activities.LoginActivity;
import pt.ipleiria.estg.dei.amsi.myscores.activities.MainActivity;
import pt.ipleiria.estg.dei.amsi.myscores.activities.Register;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonCriarjogo;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonEquipaA;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCriarDetalhesJogo extends Fragment {

    private EditText local, hora, data, jogador1A, jogador2A, jogador3A, jogador4A, jogador5A, jogador1B, jogador2B, jogador3B, jogador4B, jogador5B;

    private Button guaradarJogo;

    public fragmentCriarDetalhesJogo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_detalhes_jogo, container, false);

        guaradarJogo = (Button) view.findViewById(R.id.btGuardarJogo);
        hora = (EditText) view.findViewById(R.id.tiLayoutHora);
        data = (EditText) view.findViewById(R.id.tiLayoutData);
        local = (EditText) view.findViewById(R.id.tiLayoutLocal);
        jogador1A = (EditText) view.findViewById(R.id.tiLayoutGolosJ1A);
        jogador2A = (EditText) view.findViewById(R.id.tiLayoutGolosJ2A);
        jogador3A = (EditText) view.findViewById(R.id.tiLayoutGolosJ3A);
        jogador4A = (EditText) view.findViewById(R.id.tiLayoutGolosJ4A);
        jogador5A = (EditText) view.findViewById(R.id.tiLayoutGolosJ5A);
        jogador1B = (EditText) view.findViewById(R.id.tiLayoutGolosJ1B);
        jogador2B = (EditText) view.findViewById(R.id.tiLayoutGolosJ2B);
        jogador3B = (EditText) view.findViewById(R.id.tiLayoutGolosJ3B);
        jogador4B = (EditText) view.findViewById(R.id.tiLayoutGolosJ4B);
        jogador5B = (EditText) view.findViewById(R.id.tiLayoutGolosJ5B);

        guaradarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarEquipa();
            }
        });

        return view ;
    }

    public void criarEquipa() {

        SharedPreferences sharedPreferences = this.getContext().getSharedPreferences("userShared",Context.MODE_PRIVATE);
        int idUser = sharedPreferences.getInt("userid", 0);

        String local = this.local.getText().toString();
        String hora = this.hora.getText().toString();
        String data = this.data.getText().toString();
        String jogador1A = this.jogador1A.getText().toString();
        String jogador2A = this.jogador2A.getText().toString();
        String jogador3A = this.jogador3A.getText().toString();
        String jogador4A = this.jogador4A.getText().toString();
        String jogador5A = this.jogador5A.getText().toString();
        String jogador1B = this.jogador1B.getText().toString();
        String jogador2B = this.jogador2B.getText().toString();
        String jogador3B = this.jogador3B.getText().toString();
        String jogador4B = this.jogador4B.getText().toString();
        String jogador5B = this.jogador5B.getText().toString();


        SingletonCriarjogo.getInstance(getContext()).criarJogoAPI(idUser, hora, local, data, jogador1A, jogador2A, jogador3A, jogador4A, jogador5A, jogador1B, jogador2B, jogador3B, jogador4B, jogador5B, getContext());

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                checkCriarjogo();
            }
        },5000);

    }

    public void checkCriarjogo() {
        String dados = SingletonCriarjogo.getInstance(getContext()).returnDadosCriarjogo();

        if (dados == null) {
            Toast.makeText(getContext(), "Something's Wrong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Jogo was created", Toast.LENGTH_LONG).show();
            Intent mainActivity = new Intent(getActivity(), MainActivity.class);
            startActivity(mainActivity);
        }
    }

}
