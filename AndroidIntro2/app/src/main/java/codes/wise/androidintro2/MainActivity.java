package codes.wise.androidintro2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codes.wise.androidintro2.models.Produto;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView lvProdutos;
    private TextView tvHello;
    private Produto produtoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        lvProdutos = (ListView) findViewById(R.id.lv_produtos);
        tvHello = (TextView) findViewById(R.id.tv_hello);

        List<Produto> produtos = new ArrayList<>();
            produtos.add(new Produto(1, "Leite", 13.99));
            produtos.add(new Produto(2, "Fralda", 30.99));
            produtos.add(new Produto(3, "Neston", 17.99));
            produtos.add(new Produto(4, "Anador", 1.99));
            produtos.add(new Produto(1, "Leite", 13.99));
            produtos.add(new Produto(2, "Fralda", 30.99));
            produtos.add(new Produto(3, "Neston", 17.99));
            produtos.add(new Produto(4, "Anador", 1.99));
            produtos.add(new Produto(1, "Leite", 13.99));
            produtos.add(new Produto(2, "Fralda", 30.99));
            produtos.add(new Produto(3, "Neston", 17.99));
            produtos.add(new Produto(4, "Anador", 1.99));
            produtos.add(new Produto(1, "Leite", 13.99));
            produtos.add(new Produto(2, "Fralda", 30.99));
            produtos.add(new Produto(3, "Neston", 17.99));
            produtos.add(new Produto(4, "Anador", 1.99));
            produtos.add(new Produto(1, "Leite", 13.99));
            produtos.add(new Produto(2, "Fralda", 30.99));
            produtos.add(new Produto(3, "Neston", 17.99));
            produtos.add(new Produto(4, "Anador", 1.99));

        ArrayAdapter<Produto> adapter =
                new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);

        lvProdutos.setAdapter(adapter);

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
        registerForContextMenu(tvHello);


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
            case R.id.tv_hello:
                MenuItem fechar = menu.add("Fechar App");
                fechar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        finish();
                        return false;
                    }
                });

                break;
        }



    }
}




