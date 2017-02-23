package codes.wise.taskup.model;

import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

    //Método auxiliar para gerar Datas já no formato String
    public String getStringData(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return (this.data != null) ? format.format(this.data.getTime()) : " - ";
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
                ", descricao='" + descricao + '\'' +
                ", percentual=" + percentual +
                ", data=" + getStringData() +
                '}';
    }
}
