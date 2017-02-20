package codes.wise.taskup.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by rogermac on 20/02/17.
 */

public class Tarefa {

    private String descricao;
    private double prioridade;
    private Calendar dataLimite;

    private String detalhes;

    private List<Atividade> itens;

    public Tarefa(String descricao, int prioridade){
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public double getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(double prioridade) {
        this.prioridade = prioridade;
    }

    public int getPercentualConclucao(){
        int percentual = 0;

        for (Atividade a: this.itens)
            percentual += a.getPercentual();

        return percentual;
    }

    public void addItem(Atividade atividade){

        if (getPercentualConclucao() + atividade.getPercentual() > 100)
            throw new RuntimeException("Limite 100% da Tarefa ultrapassado");

        this.itens.add(atividade);
    }

    public List<Atividade> getItens() {
        return Collections.unmodifiableList(itens);
    }


}
