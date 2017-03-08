package codes.wise.taskup.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        //Respresenta uma linha na lista. Faz o bind dos elementos.
        private TextView tvDescricao;
        private TextView tvPrioridade;
        private TextView tvDataLimite;
        private TextView tvPercentual;
        private View item;

        public ViewHolder(View itemView) {
            super(itemView);
            this.item = itemView;
            tvDescricao = (TextView) itemView.findViewById(R.id.tv_task_descricao);
            tvPrioridade = (TextView) itemView.findViewById(R.id.tv_task_prioridade);
            tvDataLimite = (TextView) itemView.findViewById(R.id.tv_task_dataLimite);
            tvPercentual = (TextView) itemView.findViewById(R.id.tv_task_percentual);
        }
    }

    @Override
    public RecyclerViewListTaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Responsavel por inflar o layout dos itens
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_adapter, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewListTaskAdapter.ViewHolder holder, int position) {
        //Resposanvel por settar os valores na View

        tarefa = this.tarefas.get(position);
        holder.tvPrioridade.setText(String.valueOf(tarefa.getPrioridade()));
        holder.tvDescricao.setText(tarefa.getDescricao());
        holder.tvDataLimite.setText(tarefa.getStringDataLimite());
        holder.tvPercentual.setText(String.valueOf(tarefa.getPercentualConclucao()));

        setupOnClickListener(holder, tarefa);

    }

    private void setupOnClickListener(ViewHolder holder, final Tarefa tarefa) {

        holder.item.setOnClickListener(new View.OnClickListener() {
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
