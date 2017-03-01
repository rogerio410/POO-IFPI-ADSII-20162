package codes.wise.taskup.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codes.wise.taskup.R;
import codes.wise.taskup.model.Atividade;

/**
 * Created by rogermac on 01/03/17.
 */

public class ListTaskAtividadesAdapter extends RecyclerView.Adapter<ListTaskAtividadesAdapter.ViewHolder> {

    private List<Atividade> atividades;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvAtividadeDescricao;
        public TextView tvAtividadePercentual;

        public ViewHolder(View card){
            super(card);
            tvAtividadeDescricao = (TextView) card.findViewById(R.id.tv_atividade_descricao);
            tvAtividadePercentual = (TextView) card.findViewById(R.id.tv_atividade_percentual);
        }

    }

    public ListTaskAtividadesAdapter(List<Atividade> atividades){
        this.atividades = atividades;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View card = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_atividade_adapter, parent, false);

        ViewHolder vh = new ViewHolder(card);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Atividade atividade = atividades.get(position);

        holder.tvAtividadeDescricao.setText(atividade.getDescricao());
        holder.tvAtividadePercentual.setText(String.valueOf(atividade.getPercentual()));
    }

    @Override
    public int getItemCount() {
        return this.atividades.size();
    }
}
