package pt.ipleiria.estg.dei.amsi.myscores.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.activities.MainActivity;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.FragmentEstatisticasJogo;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonJogos;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.JogoViewHolder> {

    private ArrayList<Jogo> jogo;

    public class JogoViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView resultado, resultadoJogo, data;

        public JogoViewHolder(View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cardView);
            this.resultado = itemView.findViewById(R.id.resultado_Jogo);
            this.resultadoJogo = itemView.findViewById(R.id.resultadoJogo_Jogo);
            this.data = itemView.findViewById(R.id.data_jogo);

            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    MainActivity mainActivity = (MainActivity)view.getContext();
                    Fragment detalheJogo = new FragmentEstatisticasJogo();
                    FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, detalheJogo);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

        }
    }

    public RecycleViewAdapter(ArrayList<Jogo> jogo){
        this.jogo = jogo;
    }

    @Override
    public int getItemCount() {
        return jogo.size();
    }

    @NonNull
    @Override
    public RecycleViewAdapter.JogoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        JogoViewHolder jvh = new JogoViewHolder(view);
        return jvh;
    }

    @Override
    public void onBindViewHolder(@NonNull JogoViewHolder jogoViewHolder, int position) {
        jogoViewHolder.resultado.setText(jogo.get(position).getLocal());
        jogoViewHolder.resultadoJogo.setText(jogo.get(position).getHora());
        jogoViewHolder.data.setText(jogo.get(position).getData());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}