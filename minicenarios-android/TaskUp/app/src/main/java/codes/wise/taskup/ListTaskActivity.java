package codes.wise.taskup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import codes.wise.taskup.adapter.RecyclerViewListTaskAdapter;
import codes.wise.taskup.dao.TarefaRepository;
import codes.wise.taskup.model.Tarefa;

public class ListTaskActivity extends AppCompatActivity {

    private RecyclerView rvTarefas;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private TarefaRepository tarefaRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);

        rvTarefas = (RecyclerView) findViewById(R.id.lst_tarefas);

        tarefaRepo = new TarefaRepository(Tarefa.class);

    }

    @Override
    protected void onResume() {
        super.onResume();

        loadTasks();
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

    public void loadTasks(){

        List<Tarefa> tarefas = tarefaRepo.all();

        rvTarefas.setHasFixedSize(true);

        //Get a Layout for the RecyclerView
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rvTarefas.setLayoutManager(layout);

        rvAdapter = new RecyclerViewListTaskAdapter(this, tarefas, tarefaRepo);
        rvTarefas.setAdapter(rvAdapter);
    }
}
