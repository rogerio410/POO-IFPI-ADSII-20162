package codes.wise.taskup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import codes.wise.taskup.adapter.ListTaskAdapter;
import codes.wise.taskup.adapter.RecyclerViewListTaskAdapter;
import codes.wise.taskup.dao.TarefaRepository;
import codes.wise.taskup.model.Tarefa;

public class ListTaskActivity extends AppCompatActivity {

    private RecyclerView rvTarefas;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);

        rvTarefas = (RecyclerView) findViewById(R.id.lst_tarefas);

   /*     mlvTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Tarefa tarefa = (Tarefa) adapterView.getItemAtPosition(pos);

                Intent intent = new Intent(ListTaskActivity.this, ShowTaskActivity.class);
                intent.putExtra("tarefa_id", tarefa.getId());
                startActivity(intent);

            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarTarefas();
    }

    public void abrirAtividades(Tarefa tarefa){
        Intent intent = new Intent(this , ShowTaskActivity.class);
        intent.putExtra("tarefa_id", tarefa.getId());
        startActivity(intent);
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

        //List<Tarefa> tarefas = Tarefa.listAll(Tarefa.class);  //dao.todos();

        /*for (Tarefa t : tarefas){
            List<Atividade> atividades = Atividade.find(Atividade.class, "tarefa = ?", String.valueOf(t.getId()));
            for (Atividade a: atividades) {
                t.addItem(a);
            }
        }*/

        TarefaRepository dao = new TarefaRepository(Tarefa.class);
        List<Tarefa> tarefas = dao.all();
        /*ArrayAdapter<Tarefa> adapter = new ListTaskAdapter(this, R.layout.item_task_adapter, tarefas); //new ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1, tarefas);

        mlvTarefas.setAdapter(adapter);*/
        rvTarefas.setHasFixedSize(true);

        //Get a Layout for the RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rvTarefas.setLayoutManager(layout);

        rvAdapter = new RecyclerViewListTaskAdapter(this, tarefas);
        rvTarefas.setAdapter(rvAdapter);


    }
}
