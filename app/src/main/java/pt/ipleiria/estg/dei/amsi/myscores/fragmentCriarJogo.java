package pt.ipleiria.estg.dei.amsi.myscores;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentCriarJogo extends Fragment {


    public fragmentCriarJogo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup View = (ViewGroup) inflater.inflate(R.layout.fragment_criar_jogo, container, false);
        return View;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavegationDrawerConstants.TAG_NOVOJOGO);
    }


}
