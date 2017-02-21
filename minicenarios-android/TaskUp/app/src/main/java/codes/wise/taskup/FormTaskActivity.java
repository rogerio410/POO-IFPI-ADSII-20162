package codes.wise.taskup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import codes.wise.taskup.dao.TarefaDAO;
import codes.wise.taskup.model.Tarefa;

public class FormTaskActivity extends AppCompatActivity {

    EditText edDescricao;
    Spinner spPrioridade;
    EditText edDetalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_task);

        edDescricao = (EditText) findViewById(R.id.ed_task_descricao);
        spPrioridade = (Spinner) findViewById(R.id.sp_task_prioridade);
        edDetalhes = (EditText) findViewById(R.id.ed_task_detalhes);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.formtask_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void saveTask(MenuItem item) {

        String descricao = edDescricao.getText().toString();
        double prioridade = Double.valueOf(spPrioridade.getSelectedItem().toString());
        String detalhes = edDetalhes.getText().toString();

        Tarefa tarefa = new Tarefa(descricao, prioridade);
        tarefa.setDetalhes(detalhes);

        TarefaDAO dao = new TarefaDAO(this);
        dao.inserir(tarefa);

        Toast.makeText(this, "Tarefa salva", Toast.LENGTH_LONG).show();
        finish();
    }
}
