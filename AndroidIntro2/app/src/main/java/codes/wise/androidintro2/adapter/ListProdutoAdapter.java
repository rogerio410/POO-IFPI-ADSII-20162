package codes.wise.androidintro2.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import codes.wise.androidintro2.R;
import codes.wise.androidintro2.models.Produto;

/**
 * Created by rogermac on 20/03/17.
 */

public class ListProdutoAdapter extends ArrayAdapter<Produto> {


    private int layoutId;
    private List<Produto> produtos;

    public ListProdutoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        this.layoutId = resource;
        this.produtos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(this.layoutId, parent, false);
        }

        TextView tvNome = (TextView) convertView.findViewById(R.id.tv_produto_nome);
        TextView tvPreco = (TextView) convertView.findViewById(R.id.tv_produto_preco);

        Produto produto = this.produtos.get(position);

        tvNome.setText(produto.getNome());
        tvPreco.setText("R$ " + produto.getPreco());

        return convertView;
    }
}
