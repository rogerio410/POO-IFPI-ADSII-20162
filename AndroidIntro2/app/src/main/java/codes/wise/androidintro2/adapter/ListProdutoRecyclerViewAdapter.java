package codes.wise.androidintro2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import codes.wise.androidintro2.R;
import codes.wise.androidintro2.models.Produto;


/**
 * Created by rogermac on 22/03/17.
 */

public class ListProdutoRecyclerViewAdapter extends RecyclerView.Adapter<ListProdutoRecyclerViewAdapter.ViewHolder> {

    private final Context ctx;
    private final List<Produto> produtos;

    public class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvNome;
        protected TextView tvPreco;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView)itemView.findViewById(R.id.tv_produto_nome);
            tvPreco = (TextView)itemView.findViewById(R.id.tv_produto_preco);
        }
    }

    public ListProdutoRecyclerViewAdapter(Context ctx, List<Produto> produtos) {
        this.ctx = ctx;
        this.produtos = produtos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(ctx);

        View view = inflater.inflate(R.layout.produto_list_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Produto produto = produtos.get(position);

        holder.tvNome.setText(produto.getNome());
        holder.tvPreco.setText("R$ " + produto.getPreco());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
