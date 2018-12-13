package pt.ipleiria.estg.dei.amsi.myscores;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPaginaPerfil extends Fragment {


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
