package codes.wise.taskup.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import codes.wise.taskup.ListTaskActivity;
import codes.wise.taskup.R;
import codes.wise.taskup.model.Tarefa;

/**
 * Created by rogermac on 07/03/17.
 */

public class RecyclerViewListTaskAdapter extends RecyclerView.Adapter<RecyclerViewListTaskAdapter.ViewHolder> {

    private Activity activity;
    private List<Tarefa> tarefas;
    private Tarefa tarefa;

    public RecyclerViewListTaskAdapter(Activity activity, List<Tarefa> tarefas){
        this.activity = activity;
        this.tarefas = tarefas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Representa uma linha na lista. Faz o bind dos elementos.
        private TextView tvDescricao;
        private TextView tvPrioridade;
        private TextView tvDataLimite;
        private TextView tvPercentual;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDescricao = (TextView) itemView.findViewById(R.id.tv_task_descricao);
            tvPrioridade = (TextView) itemView.findViewById(R.id.tv_task_prioridade);
            tvDataLimite = (TextView) itemView.findViewById(R.id.tv_task_dataLimite);
            tvPercentual = (TextView) itemView.findViewById(R.id.tv_task_percentual);
        }
    }

    @Override
    public RecyclerViewListTaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Responsavel por inflar o layout dos itens
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_rv_adapter, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewListTaskAdapter.ViewHolder holder, int position) {
        //Resposanvel por settar os valores na View

        tarefa = this.tarefas.get(position);
        holder.tvPrioridade.setText(String.valueOf(tarefa.getPrioridade()));
        holder.tvDescricao.setText(tarefa.getDescricao());
        holder.tvDataLimite.setText(tarefa.getStringDataLimite());
        holder.tvPercentual.setText(String.valueOf(tarefa.getPercentualConclucao()));

        //Click no card
        setupOnClickListener(holder, tarefa);

        //Long Click no Card
        setupOnLongClickListener(holder, tarefa);


    }

    private void setupOnLongClickListener(final ViewHolder holder, Tarefa tarefa) {

        holder.itemView.setLongClickable(true);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final Snackbar snack = Snackbar.make(holder.itemView, "Click Long no Card", Snackbar.LENGTH_INDEFINITE);

                snack.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snack.dismiss();
                    }
                });

                snack.show();

                return true;
            }
        });
    }

    private void setupOnClickListener(ViewHolder holder, final Tarefa tarefa) {

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListTaskActivity)activity).abrirAtividades(tarefa);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }


}
