package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.amsi.myscores.NavegationDrawerConstants;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.activities.MainActivity;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonUsers;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPaginaPerfil extends Fragment {
    private TextView tvNome, tvEmailUtilizador, tvTUserName, tvTDataNascimento, tvTNacionalidade;

    private ArrayList<User> user;

    public fragmentPaginaPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_pagina_perfil, container, false);

        user = SingletonUsers.getInstance(getContext()).getUser();

        Button btnEditarPerfil =  view.findViewById(R.id.btEditarPerfil);
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFragmento();
            }
        });

        tvNome = view.findViewById(R.id.tvNome);
        tvEmailUtilizador = view.findViewById(R.id.tvEmailUtilizador);
        tvTUserName = view.findViewById(R.id.tvTUserName);
        tvTDataNascimento = view.findViewById(R.id.tvTDataNascimento);
        tvTNacionalidade = view.findViewById(R.id.tvTNacionalidade);

        if ( user != null){
            tvNome.setText(user.get(0).getNome());
            tvEmailUtilizador.setText(user.get(0).getEmail());
            tvTUserName.setText(user.get(0).getUsername());
            tvTDataNascimento.setText(user.get(0).getDataNascimento());
            tvTNacionalidade.setText(user.get(0).getNacionalidade());
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
