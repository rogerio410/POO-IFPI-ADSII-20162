package codes.wise.taskup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import codes.wise.taskup.R;
import codes.wise.taskup.model.Tarefa;

/**
 * Created by rogermac on 01/03/17.
 */

public class ListTaskAdapter extends ArrayAdapter<Tarefa> {


    private final Context context;
    private final int resource;
    private final List<Tarefa> tarefas;

    public ListTaskAdapter(Context context, int resource, List<Tarefa> tarefas) {
        super(context, resource, tarefas);
        this.context = context;
        this.resource = resource;
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final TextView tvDescricao;
        final TextView tvPrioridade;
        final TextView tvDataLimite;
        final TextView tvPercentual;
        final Tarefa tarefa;

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(this.resource, parent, false);

            tvDescricao = (TextView) convertView.findViewById(R.id.tv_task_descricao);
            tvDataLimite = (TextView) convertView.findViewById(R.id.tv_task_dataLimite);
            tvPrioridade = (TextView) convertView.findViewById(R.id.tv_task_prioridade);
            tvPercentual = (TextView) convertView.findViewById(R.id.tv_task_percentual);

            convertView.setTag(R.id.tv_task_descricao, tvDescricao);
            convertView.setTag(R.id.tv_task_dataLimite, tvDataLimite);
            convertView.setTag(R.id.tv_task_prioridade, tvPrioridade);
            convertView.setTag(R.id.tv_task_percentual, tvPercentual);
        }else{
            tvDescricao = (TextView) convertView.getTag(R.id.tv_task_descricao);
            tvPrioridade = (TextView) convertView.getTag(R.id.tv_task_prioridade);
            tvDataLimite = (TextView) convertView.getTag(R.id.tv_task_dataLimite);
            tvPercentual = (TextView) convertView.getTag(R.id.tv_task_percentual);
        }

        tarefa = this.tarefas.get(position);

        tvDescricao.setText(tarefa.getDescricao());
        tvDataLimite.setText(tarefa.getStringDataLimite());
        tvPrioridade.setText(String.valueOf(tarefa.getPrioridade()));
        tvPercentual.setText(String.valueOf(tarefa.getPercentualConclucao()) + "%");

        return convertView;
    }
}
