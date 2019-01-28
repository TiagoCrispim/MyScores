package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.NavegationDrawerConstants;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.adapters.RecycleViewAdapter;
import pt.ipleiria.estg.dei.amsi.myscores.activities.slide_layout;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonJogos;


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

        ArrayList<Jogo> jogo = SingletonJogos.getInstance(getContext()).getJogo();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecycleViewAdapter adapter = new RecycleViewAdapter(jogo);
        recyclerView.setAdapter(adapter);


        FloatingActionButton btCriarJogo =  view.findViewById(R.id.fab);
        btCriarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCriarJogo = new Intent(getActivity(), slide_layout.class);
                startActivity(abrirCriarJogo);
            }
        });

        /*if (savedInstanceState == null){
            SingletonJogos.getInstance().lerJogos(this);
            this.jogos = SingletonJogos.getInstance().getJogos();
        }*/

        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavegationDrawerConstants.TAG_PINICIAL);

    }

}
