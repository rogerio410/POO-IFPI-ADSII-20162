package codes.wise.taskup.model;

import java.util.Calendar;

/**
 * Created by rogermac on 20/02/17.
 */

public class Atividade {

    private String descricao;
    private int percentual; //Qual fatia representa da Tarefa Mãe.
    private Calendar data;

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
}
