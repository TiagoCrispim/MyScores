package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogador;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.adapters.RecyclerViewEquipaAAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCiriarEquipaA extends Fragment {
    public fragmentCiriarEquipaA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_equipa_a, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEquipaA);
        recyclerView.setHasFixedSize(true);

        initializeData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewEquipaAAdapter adapter = new RecyclerViewEquipaAAdapter(jogadores);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Jogador> jogadores = new ArrayList<>();

    private void initializeData(){
        jogadores.add(new Jogador("Rodrigo Gameiro", R.drawable.ic_launcher));
        jogadores.add(new Jogador("Tiago Crispim", R.drawable.ic_launcher));
        jogadores.add(new Jogador("Daniel Sarreira", R.drawable.ic_launcher));
        jogadores.add(new Jogador("Nuno Nunes", R.drawable.ic_launcher));
        jogadores.add(new Jogador("Rui Silva", R.drawable.ic_launcher));
    }


}
