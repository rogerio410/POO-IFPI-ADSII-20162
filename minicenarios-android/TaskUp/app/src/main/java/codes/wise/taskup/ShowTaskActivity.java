package codes.wise.taskup;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import codes.wise.taskup.model.Atividade;
import codes.wise.taskup.model.Tarefa;

public class ShowTaskActivity extends AppCompatActivity {

    private Tarefa tarefa;
    private TextView mTvTarefaDescricao;
    private TextView mTvTarefaDataLimite;
    private ListView mLvAtividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        //Obter o id da tarefa clicada
        Intent intent = getIntent();
        long tarefa_id = intent.getLongExtra("tarefa_id", 0);

        //Obter a tarefa no BD.
        tarefa = Tarefa.findById(Tarefa.class, tarefa_id);

        //Binding
        mTvTarefaDescricao = (TextView) findViewById(R.id.tv_task_descricao);
        mTvTarefaDataLimite = (TextView) findViewById(R.id.tv_task_dataLimite);
        mLvAtividades = (ListView) findViewById(R.id.lv_task_atividades);

        //Preencher dados
        mTvTarefaDescricao.setText(tarefa.getDescricao());
        mTvTarefaDataLimite.setText(tarefa.getStringDataLimite());

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarAtividades();

    }

    private void carregarAtividades() {
        List<Atividade> atividades = Atividade.find(Atividade.class, "tarefa = ?", String.valueOf(tarefa.getId()));
        ArrayAdapter<Atividade> adapter = new ArrayAdapter<Atividade>(this, android.R.layout.simple_list_item_1, atividades);

        mLvAtividades.setAdapter(adapter);
    }

    public void addAtividade(View view) {

        /*
        * Exibe um Formulario em uma Dialog.
        * Precisa carregar o Layout do Formulario e entao ao clickar no botao positivo
        * Salvar a Atividade (associando à tarefa atual e atualizar a lista de atividades.)
        * */

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialog_new_atividade, null);

        builder.setView(dialogView)
                .setTitle("Nova Atividade")
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText edAtividadeDescricao = (EditText) dialogView.findViewById(R.id.ed_atividade_descricao);
                        EditText edAtivdadePercentual = (EditText) dialogView.findViewById(R.id.ed_atividade_percentual);

                        String descricao = edAtividadeDescricao.getText().toString();
                        int percentual = Integer.valueOf(edAtivdadePercentual.getText().toString());

                        Atividade atividade = new Atividade(descricao, percentual);
                        tarefa.addItem(atividade);
                        atividade.save();

                        carregarAtividades();

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();


    }

}
