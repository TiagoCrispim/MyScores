package pt.ipleiria.estg.dei.amsi.myscores.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogador;
import pt.ipleiria.estg.dei.amsi.myscores.R;

public class RecyclerViewEquipaBAdapter extends RecyclerView.Adapter<RecyclerViewEquipaBAdapter.JogadorEBViewHolder>{

        List<Jogador> jogadores;

public class JogadorEBViewHolder extends RecyclerView.ViewHolder {
    public TextView nomeJogador;
    public ImageView fotoJogador;

    public JogadorEBViewHolder(View itemView) {
        super(itemView);
        this.fotoJogador = itemView.findViewById(R.id.imageJogadorEquipaA);
        this.nomeJogador = itemView.findViewById(R.id.tvNomeJogador);
    }
}

    public RecyclerViewEquipaBAdapter(List<Jogador> jogadores){
        this.jogadores = jogadores;
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }

    @NonNull
    @Override
    public RecyclerViewEquipaBAdapter.JogadorEBViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_jogador, viewGroup, false);
        RecyclerViewEquipaBAdapter.JogadorEBViewHolder jvh = new RecyclerViewEquipaBAdapter.JogadorEBViewHolder(view);
        return jvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewEquipaBAdapter.JogadorEBViewHolder jogadorEBViewHolder, int position) {
        jogadorEBViewHolder.nomeJogador.setText(jogadores.get(position).getNomeJogador());
        jogadorEBViewHolder.fotoJogador.setImageResource(jogadores.get(position).getFotoJogador());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
