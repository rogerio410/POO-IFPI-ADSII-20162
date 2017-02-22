package codes.wise.taskup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import codes.wise.taskup.dao.TarefaDAO;
import codes.wise.taskup.model.Tarefa;

public class ListTaskActivity extends AppCompatActivity {

    ListView lstTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);

        lstTarefas = (ListView) findViewById(R.id.lst_tarefas);

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarTarefas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listtask_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_add_task:
                addTask(null);
                break;
            case R.id.item_configuracoes:
                Intent intentSettings = new Intent(this, SettingsActivity.class);
                startActivity(intentSettings);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addTask(View view) {
        Intent formTaskIntent = new Intent(this, FormTaskActivity.class);
        startActivity(formTaskIntent);
    }

    public void carregarTarefas(){
        //TarefaDAO dao = new TarefaDAO(this);

        List<Tarefa> tarefas = Tarefa.listAll(Tarefa.class);  //dao.todos();
        ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1, tarefas);

        lstTarefas.setAdapter(adapter);
    }
}
