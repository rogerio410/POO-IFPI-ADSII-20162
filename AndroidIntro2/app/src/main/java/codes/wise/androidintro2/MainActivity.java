package codes.wise.androidintro2;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codes.wise.androidintro2.models.Produto;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView lvProdutos;
    private Produto produtoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        lvProdutos = (ListView) findViewById(R.id.lv_produtos);

        //Listeners
        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Produto produto = (Produto) adapterView.getItemAtPosition(pos);
                Toast.makeText(getApplicationContext(), produto.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lvProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {

                produtoSelecionado = (Produto) adapterView.getItemAtPosition(pos);

                return false;
            }
        });

        //...
        registerForContextMenu(lvProdutos);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProdutos();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        Log.i(TAG, "Criacao do Context Menu");

        switch (v.getId()){
            case R.id.lv_produtos:
                MenuItem remover = menu.add("Remover");
                MenuItem estoque = menu.add("Ver Estoque");

                remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //Confirmar Remocao
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Remoção de Produto")
                                .setMessage("Desejar realmente remover: " + produtoSelecionado.getNome() + "?")
                                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        produtoSelecionado.delete();
                                        loadProdutos();
                                        Toast.makeText(MainActivity.this, "Removido", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton("NAO. Nao te pedi isso.", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this, "Desculpe-me", Toast.LENGTH_LONG).show();
                                    }
                                })
                                .show();

                        Toast.makeText(getApplicationContext(), "Remover item ..." + produtoSelecionado.getNome(), Toast.LENGTH_SHORT).show();

                        return false;
                    }
                });

                estoque.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(), "Estoque item ..." + produtoSelecionado.getNome(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                break;
        }

    }

    public void novoProduto(View view) {

        LayoutInflater inflater = getLayoutInflater();

        final View viewDialog = inflater.inflate(R.layout.form_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(viewDialog)
                .setTitle("Novo Produto")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edNome = (EditText) viewDialog.findViewById(R.id.ed_produto_nome);
                        EditText edPreco = (EditText) viewDialog.findViewById(R.id.ed_produto_preco);

                        String nome = edNome.getText().toString();
                        double preco = Double.valueOf(edPreco.getText().toString());

                        Produto produto = new Produto(nome, preco);

                        produto.save();

                        loadProdutos();

                        Toast.makeText(MainActivity.this, "Produto Salvo", Toast.LENGTH_LONG).show();

                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();


    }

    private void loadProdutos() {

        List<Produto> produtos = Produto.listAll(Produto.class);

        ArrayAdapter<Produto> adapter =
                new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);

        lvProdutos.setAdapter(adapter);

    }
}























