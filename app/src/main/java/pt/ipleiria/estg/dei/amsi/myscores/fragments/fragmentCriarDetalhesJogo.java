package pt.ipleiria.estg.dei.amsi.myscores.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.activities.LoginActivity;
import pt.ipleiria.estg.dei.amsi.myscores.activities.MainActivity;
import pt.ipleiria.estg.dei.amsi.myscores.activities.Register;


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

        Button btnGuardarJogo =  view.findViewById(R.id.btGuardarJogo);
        btnGuardarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        return view ;
    }

}
