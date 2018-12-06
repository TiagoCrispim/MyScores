package pt.ipleiria.estg.dei.amsi.myscores;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
        return inflater.inflate(R.layout.fragment_pagina_perfil, container, false);
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
