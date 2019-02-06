package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonUsers;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCiriarEquipaA extends Fragment{

    public fragmentCiriarEquipaA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_criar_equipa_a, container, false);

        ArrayList<User> user = SingletonUsers.getInstance(getContext()).getUser();

        return view;
    }

}
