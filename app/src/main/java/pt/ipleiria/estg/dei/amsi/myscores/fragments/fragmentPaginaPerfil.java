package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pt.ipleiria.estg.dei.amsi.myscores.NavegationDrawerConstants;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPaginaPerfil extends Fragment {
    private EditText tvNome, tvEmailUtilizador, tvTUserName, tvTDataNascimento, tvTNacionalidade, tvNJogosJogados, tvNGolosMarcados;

    private User user;

    public fragmentPaginaPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_pagina_perfil, container, false);

        Button btnEditarPerfil =  view.findViewById(R.id.btEditarPerfil);
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFragmento();
            }
        });


        this.tvNome = view.findViewById(R.id.tvNome);
        this.tvEmailUtilizador = view.findViewById(R.id.tvEmailUtilizador);
        this.tvTUserName = view.findViewById(R.id.tvTUserName);
        this.tvTDataNascimento = view.findViewById(R.id.tvTDataNascimento);
        this.tvTNacionalidade = view.findViewById(R.id.tvNacionalidade);
        this.tvNJogosJogados = view.findViewById(R.id.tvNJogosJogados);
        this.tvNGolosMarcados = view.findViewById(R.id.tvNGolosMarcados);

        if(this.user !=  null){
            this.tvNome.setText(this.user.getNome());
            this.tvEmailUtilizador.setText(this.user.getEmail());
            this.tvTUserName.setText(this.user.getUsername());
            this.tvTDataNascimento.setText(this.user.getDataNascimento());
            this.tvTNacionalidade.setText(this.user.getNacionalidade());
            this.tvNJogosJogados.setText(this.user.getJogosJogados());
            this.tvNGolosMarcados.setText(this.user.getGolosMarcados());
        }

        return view;
    }

    public void mostrarFragmento(){
        Fragment editarPerfil = new fragmentEditarPerfil();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContent, editarPerfil);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavegationDrawerConstants.TAG_PPERFIL);
    }

    //metodo para guardar valores no bundle para que quando o ecra do telemovel for virado os dados anteriormente inseridos sejam guardados e reabertos igualmente
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
