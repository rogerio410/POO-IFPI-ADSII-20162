package codes.wise.taskup.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import codes.wise.taskup.R;
import codes.wise.taskup.ShowTaskActivity;
import codes.wise.taskup.databinding.CardviewAtividadeBinding;
import codes.wise.taskup.model.Atividade;

/**
 * Created by Gildaswise on 01/03/2017.
 */

public class CardViewAtividade extends AbstractItem<CardViewAtividade, CardViewAtividade.ViewHolder> {

    private final static String TAG = "CardViewAtividade";

    private Atividade atividade;
    private Activity activity;

    private final ViewHolderFactory<? extends CardViewAtividade.ViewHolder> FACTORY = new CardViewAtividade.ItemFactory();

    public CardViewAtividade(Atividade atividade, Activity activity) {
        this.activity = activity;
        this.atividade = atividade;
    }

    @Override
    public int getType() {
        return R.id.atividade_cardview;
    } //ID da RootView

    @Override
    public int getLayoutRes() {
        return R.layout.cardview_atividade;
    } //Layout

    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        holder.setAtividade(atividade);
        setupUpdateListener(holder.binding);
        setupDeleteListener(holder.binding);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.setAtividade(null);
    }

    private void setupDeleteListener(final CardviewAtividadeBinding binding) {
        binding.atividadeCardviewRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Atividade selecionada = binding.getAtividade();
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Desejar remover: " + selecionada.getDescricao() + "?")
                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               selecionada.delete();
                               ((ShowTaskActivity) activity).carregarAtividades();
                           }
                       })
                       .setNegativeButton(android.R.string.no, null)
                       .show();
            }
        });
    }

    private void setupUpdateListener(final CardviewAtividadeBinding binding) {
        binding.atividadeCardviewAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Atividade selecionada = binding.getAtividade();
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Concluir '" + selecionada.getDescricao() + "'?")
                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               selecionada.setConcluida(Calendar.getInstance(Locale.getDefault()));
                               selecionada.save();
                               ((ShowTaskActivity) activity).carregarAtividades();
                           }
                       })
                       .setNegativeButton(android.R.string.no, null)
                       .show();
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected Atividade atividade;
        protected CardviewAtividadeBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            this.binding = CardviewAtividadeBinding.bind(itemView);
        }

        public void setAtividade(Atividade atividade) {
            this.atividade = atividade;
            if(this.binding != null) this.binding.setAtividade(atividade);
        }
    }

    protected static class ItemFactory implements ViewHolderFactory<ViewHolder> {
        public CardViewAtividade.ViewHolder create(View v) {
            return new CardViewAtividade.ViewHolder(v);
        }
    }

    @Override
    public ViewHolderFactory<? extends CardViewAtividade.ViewHolder> getFactory() {
        return FACTORY;
    }

}
