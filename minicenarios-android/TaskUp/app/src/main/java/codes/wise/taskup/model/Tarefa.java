package codes.wise.taskup.model;

import com.orm.SugarRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by rogermac on 20/02/17.
 */

public class Tarefa extends SugarRecord{

    private String descricao;
    private double prioridade;
    private Calendar dataLimite;
    private String detalhes;

    private List<Atividade> itens = new ArrayList<>();

    public Tarefa(){

    }

    public Tarefa(String descricao, double prioridade){
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
        atividade.setTarefa(this);
    }

    public List<Atividade> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public String getDescricao() {
        return descricao;
    }

    public Calendar getDataLimite() {
        return dataLimite;
    }

    //Método auxiliar devido a forma de persistencia de datas no SQLite
    public Long getPersistentDataLimite(){
        if (this.dataLimite != null){
            return  this.dataLimite.getTimeInMillis();
        }
        return null;
    }

    //Método auxiliar para gerar Datas já no formato String
    public String getStringDataLimite(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return (this.dataLimite != null) ? format.format(this.dataLimite.getTime()) : " - ";
    }

    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + this.getId() +
                ", descricao='" + descricao + '\'' +
                ", prioridade=" + prioridade +
                ", dataLimite = " + getStringDataLimite() +
                ", detalhes='" + detalhes + '\'' +
                '}';
    }
}
