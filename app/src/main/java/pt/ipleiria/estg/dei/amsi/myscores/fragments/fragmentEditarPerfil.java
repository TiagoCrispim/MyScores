package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pt.ipleiria.estg.dei.amsi.myscores.NavegationDrawerConstants;
import pt.ipleiria.estg.dei.amsi.myscores.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentEditarPerfil extends Fragment {


    public fragmentEditarPerfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_editar_perfil, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavegationDrawerConstants.TAG_EDITARPERFIL);
    }

}
