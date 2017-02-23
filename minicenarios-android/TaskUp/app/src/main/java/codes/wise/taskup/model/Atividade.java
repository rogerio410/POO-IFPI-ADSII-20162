package codes.wise.taskup.model;

import com.orm.SugarRecord;

import java.util.Calendar;

/**
 * Created by rogermac on 20/02/17.
 */

public class Atividade extends SugarRecord{

    private String descricao;
    private int percentual; //Qual fatia representa da Tarefa Mãe.
    private Calendar data;
    private Tarefa tarefa;

    public Atividade(){}

    public Atividade(String descricao, int percentual){
        this.descricao = descricao;
        this.percentual = percentual;
    }

    public void setConcluida(Calendar data){
        this.data = data;
    }

    public boolean isConcluida(){
        return this.data != null;
    }


    public Calendar getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPercentual() {
        return percentual;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "percentual=" + percentual +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
