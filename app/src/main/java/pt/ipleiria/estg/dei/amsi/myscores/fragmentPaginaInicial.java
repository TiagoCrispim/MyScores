package pt.ipleiria.estg.dei.amsi.myscores;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPaginaInicial extends Fragment {
    List<Jogo> jogosList = new ArrayList<>();


    public fragmentPaginaInicial() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagina_inicial, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        initializeData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecycleViewAdapter adapter = new RecycleViewAdapter(jogos);
        recyclerView.setAdapter(adapter);


        FloatingActionButton btCriarJogo =  view.findViewById(R.id.fab);
        btCriarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirCriarJogo = new Intent(getActivity(), slide_layout.class);
                startActivity(abrirCriarJogo);
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

    private List<Jogo> jogos = new ArrayList<>();

    private void initializeData(){
        jogos.add(new Jogo("Vitória", "2-1", "6/12/2018"));
        jogos.add(new Jogo("Derrota", "1-2", "6/12/2018"));
        jogos.add(new Jogo("Empate", "5-5", "6/12/2018"));
        jogos.add(new Jogo("Vitória", "2-1", "6/12/2018"));
        jogos.add(new Jogo("Derrota", "1-2", "6/12/2018"));
        jogos.add(new Jogo("Empate", "5-5", "6/12/2018"));
        jogos.add(new Jogo("Vitória", "2-1", "6/12/2018"));
        jogos.add(new Jogo("Derrota", "1-2", "6/12/2018"));
        jogos.add(new Jogo("Empate", "5-5", "6/12/2018"));
    }

}
