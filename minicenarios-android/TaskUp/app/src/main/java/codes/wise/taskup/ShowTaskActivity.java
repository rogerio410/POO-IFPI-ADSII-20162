package codes.wise.taskup;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import codes.wise.taskup.adapter.CardViewAtividade;
import codes.wise.taskup.adapter.ListTaskAtividadesAdapter;
import codes.wise.taskup.model.Atividade;
import codes.wise.taskup.model.Tarefa;

public class ShowTaskActivity extends AppCompatActivity {

    private Tarefa mtarefa;
    private Atividade mSelectedAtividade;

    private TextView mTvTarefaDescricao;
    private TextView mTvTarefaDataLimite;
    //private ListView mLvAtividades;

    private RecyclerView mRecyclerAtividades;
    private RecyclerView.Adapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mRecyclerLayoutMananger;

    private FastItemAdapter<CardViewAtividade> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        //Obter o id da mtarefa clicada
        Intent intent = getIntent();
        long tarefa_id = intent.getLongExtra("tarefa_id", 0);

        //Obter a mtarefa no BD.
        mtarefa = Tarefa.findById(Tarefa.class, tarefa_id);

        //Binding
        mTvTarefaDescricao = (TextView) findViewById(R.id.tv_task_descricao);
        mTvTarefaDataLimite = (TextView) findViewById(R.id.tv_task_dataLimite);
        //mLvAtividades = (ListView) findViewById(R.id.lv_task_atividades);

        //Preencher dados
        mTvTarefaDescricao.setText(mtarefa.getDescricao());
        mTvTarefaDataLimite.setText(mtarefa.getStringDataLimite());

        //Selecionar Atividade
        /*mLvAtividades.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                mSelectedAtividade = (Atividade) adapterView.getItemAtPosition(pos);
                return false;
            }
        });

        //Registrar para Menu de Contexto
        registerForContextMenu(mLvAtividades);*/

        //For RecycleView/CardView
        mRecyclerAtividades = (RecyclerView) findViewById(R.id.rv_task_atividades);
        mRecyclerLayoutMananger = new LinearLayoutManager(this);
        mRecyclerAtividades.setLayoutManager(mRecyclerLayoutMananger);

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarAtividades();

    }

    public void carregarAtividades() {
        List<Atividade> atividades = Atividade.find(Atividade.class, "tarefa = ?", String.valueOf(mtarefa.getId()));
        //ArrayAdapter<Atividade> adapter = new ArrayAdapter<Atividade>(this, android.R.layout.simple_list_item_1, atividades);

        //mLvAtividades.setAdapter(adapter);

//        mRecyclerAdapter = new ListTaskAtividadesAdapter(atividades, null);
//        mRecyclerAtividades.setAdapter(mRecyclerAdapter);

        adapter = new FastItemAdapter<>();
        for (Atividade atividade : atividades) {
            adapter.add(new CardViewAtividade(atividade, this));
        }
        mRecyclerAtividades.setAdapter(adapter);
    }

    public void addAtividade(View view) {

        /*
        * Exibe um Formulario em uma Dialog.
        * Precisa carregar o Layout do Formulario e entao ao clickar no botao positivo
        * Salvar a Atividade (associando à mtarefa atual e atualizar a lista de atividades.)
        * */

        //Obtem um construtor de Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Infla o layout do formulario em um View que será settada na Dialog
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_new_atividade, null);

        //Settar a View(com o Layout) e demais propriedades
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
                        mtarefa.addItem(atividade);
                        atividade.save();

                        carregarAtividades();

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Adiciona dois itens no Menu de Contexto
        MenuItem remover = menu.add("Remover");
        MenuItem concluída = menu.add("Marcar como Concluída");

        //Se a Atividade já estiver concluída oculta a opção Concluída
        if (mSelectedAtividade.isConcluida())
            concluída.setVisible(false);

        //Remove a Atividade Selecionada (Antes pergunta por meio de uma Dialog)
        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ShowTaskActivity.this);

                builder.setTitle("TaskApp")
                        .setMessage("Desejar remover: " + mSelectedAtividade.getDescricao() + "? ")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mSelectedAtividade.delete();
                                onResume();
                            }
                        })
                        .setNegativeButton("NÃO", null)
                        .show();

                return false;
            }
        });

        //Marca como Concluída na Data atual.
        concluída.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ShowTaskActivity.this);

                builder.setTitle("TaskApp")
                        .setMessage("Concluiu esta Atividade?")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mSelectedAtividade.setConcluida(Calendar.getInstance(Locale.getDefault()));
                                mSelectedAtividade.save();
                                onResume();
                            }
                        })
                        .setNegativeButton("NÃO", null)
                        .show();

                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
