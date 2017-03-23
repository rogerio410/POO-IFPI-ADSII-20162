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

    public class ViewHolder{

        protected TextView tvNome;
        protected TextView tvPreco;

        public ViewHolder(View view) {
            tvNome = (TextView) view.findViewById(R.id.tv_produto_nome);
            tvPreco = (TextView) view.findViewById(R.id.tv_produto_preco);
        }
    }

    public ListProdutoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        this.layoutId = resource;
        this.produtos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder vh;

        Produto produto = this.produtos.get(position);

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(this.layoutId, parent, false);

            vh = new ViewHolder(convertView);
            convertView.setTag(vh);

        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        vh.tvNome.setText(produto.getNome());
        vh.tvPreco.setText("R$ " + produto.getPreco());

        return convertView;
    }

}
