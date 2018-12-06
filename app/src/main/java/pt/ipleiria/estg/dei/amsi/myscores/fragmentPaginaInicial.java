package pt.ipleiria.estg.dei.amsi.myscores;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.NavegationDrawerConstants;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPaginaInicial extends Fragment {

    public fragmentPaginaInicial() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagina_inicial, container, false);
        FloatingActionButton btCriarJogo =  view.findViewById(R.id.fab);

        btCriarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCriarJogo = new Intent(getActivity(), slide_layout.class);
                startActivity(abrirCriarJogo);
                //Intent openCriarJogo = new Intent(MainActivity.this, slide_layout.class);
                //startActivity(activity_slide_layout);
            }
        });
        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavegationDrawerConstants.TAG_PINICIAL);

    }

    public void mostrarFragmento(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();
    }

}
