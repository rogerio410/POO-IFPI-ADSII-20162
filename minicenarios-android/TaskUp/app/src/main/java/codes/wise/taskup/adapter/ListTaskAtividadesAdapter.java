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
    private View.OnClickListener onClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvAtividadeDescricao;
        public TextView tvAtividadePercentual;

        public ViewHolder(View card){
            super(card);
            tvAtividadeDescricao = (TextView) card.findViewById(R.id.tv_atividade_descricao);
            tvAtividadePercentual = (TextView) card.findViewById(R.id.tv_atividade_percentual);
        }

    }

    public ListTaskAtividadesAdapter(List<Atividade> atividades, View.OnClickListener clickListener){
        this.atividades = atividades;
        this.onClickListener = clickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_atividade_adapter, parent, false);
        card.findViewById(R.id.tv_atividade_percentual).setOnClickListener(getOnClickListener());
        ViewHolder vh = new ViewHolder(card);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Atividade atividade = atividades.get(position);
        setupDescricao(holder.tvAtividadeDescricao, atividade);
        holder.tvAtividadePercentual.setText(String.valueOf(atividade.getPercentual()));
    }

    private void setupDescricao(TextView tvAtividadeDescricao, Atividade atividade) {
        tvAtividadeDescricao.setOnClickListener(getOnClickListener());
        tvAtividadeDescricao.setText(atividade.getDescricao());
    }

    @Override
    public int getItemCount() {
        return this.atividades.size();
    }
}
