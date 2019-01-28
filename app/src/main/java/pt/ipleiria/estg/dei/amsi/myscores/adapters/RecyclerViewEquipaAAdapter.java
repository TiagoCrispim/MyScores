package pt.ipleiria.estg.dei.amsi.myscores.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogador;
import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentPaginaPerfil;
import pt.ipleiria.estg.dei.amsi.myscores.activities.slide_layout;

public class RecyclerViewEquipaAAdapter extends RecyclerView.Adapter<RecyclerViewEquipaAAdapter.JogadorViewHolder>{

    List<Jogador> jogadores;

    public class JogadorViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeJogador;
        public ImageView fotoJogador;
        public Button apagarJogador;

        public JogadorViewHolder(View itemView) {
            super(itemView);
            this.fotoJogador = itemView.findViewById(R.id.imageJogadorEquipaA);
            this.nomeJogador = itemView.findViewById(R.id.tvNomeJogador);
            this.apagarJogador = itemView.findViewById(R.id.btnDeleteJogador);

            //fazer quando terminar outras coisas importantes, abrir janela with perfil de outros jogador
            /*fotoJogador.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    slide_layout slideLayout = (slide_layout) view.getContext();
                    Fragment perfilJogador = new fragmentPaginaPerfil();
                    FragmentTransaction transaction = slideLayout.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameSlideLayout, perfilJogador);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            nomeJogador.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    slide_layout slideLayout = (slide_layout) view.getContext();
                    Fragment perfilJogador = new fragmentPaginaPerfil();
                    FragmentTransaction transaction = slideLayout.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameSlideLayout, perfilJogador);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });*/

        }
    }

    public RecyclerViewEquipaAAdapter(List<Jogador> jogadores){
        this.jogadores = jogadores;
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }

    @NonNull
    @Override
    public RecyclerViewEquipaAAdapter.JogadorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_jogador, viewGroup, false);
        RecyclerViewEquipaAAdapter.JogadorViewHolder jvh = new RecyclerViewEquipaAAdapter.JogadorViewHolder(view);
        return jvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewEquipaAAdapter.JogadorViewHolder jogadorViewHolder, int position) {
        jogadorViewHolder.nomeJogador.setText(jogadores.get(position).getNomeJogador());
        jogadorViewHolder.fotoJogador.setImageResource(jogadores.get(position).getFotoJogador());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
