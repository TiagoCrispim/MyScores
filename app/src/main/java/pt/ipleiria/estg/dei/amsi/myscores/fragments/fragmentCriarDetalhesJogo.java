package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.ipleiria.estg.dei.amsi.myscores.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCriarDetalhesJogo extends Fragment {


    public fragmentCriarDetalhesJogo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_detalhes_jogo, container, false);
        return view ;
    }

}