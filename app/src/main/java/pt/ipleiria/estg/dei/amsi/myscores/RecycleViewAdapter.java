package pt.ipleiria.estg.dei.amsi.myscores;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.JogoViewHolder> {

    List<Jogo> jogos;
    /*private String[] jogoDataResultado;
    private String[] jogoDataResultadoJogo;
    private String[] jogoDataData;*/

    public class JogoViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView resultado, resultadoJogo, data;

        public JogoViewHolder(View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cardView);
            this.resultado = itemView.findViewById(R.id.resultado_Jogo);
            this.resultadoJogo = itemView.findViewById(R.id.resultadoJogo_Jogo);
            this.data = itemView.findViewById(R.id.data_jogo);
        }
    }

    public RecycleViewAdapter(List<Jogo> jogos){
        this.jogos = jogos;
    }

    /*public RecycleViewAdapter(String[] jogoData) {
        jogoDataResultado = jogoData;
        jogoDataResultadoJogo = jogoData;
        jogoDataData = jogoData;
    }*/


    @Override
    public int getItemCount() {
        return jogos.size();
        // return jogoDataResultado.length;
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
        jogoViewHolder.resultado.setText(jogos.get(position).getResultado());
        jogoViewHolder.resultadoJogo.setText(jogos.get(position).getResultadoJogo());
        jogoViewHolder.data.setText(jogos.get(position).getData());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }




}