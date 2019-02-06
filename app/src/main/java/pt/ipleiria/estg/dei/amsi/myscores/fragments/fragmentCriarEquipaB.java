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


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCriarEquipaB extends Fragment {
    List<Jogador> jogadoresList = new ArrayList<>();

    public fragmentCriarEquipaB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_equipa_b, container, false);

        return view;
    }

}
