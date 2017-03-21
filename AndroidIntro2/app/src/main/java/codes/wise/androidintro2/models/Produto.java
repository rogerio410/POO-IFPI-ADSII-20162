package codes.wise.androidintro2.models;

import com.orm.SugarRecord;

/**
 * Created by rogermac on 15/03/17.
 */

public class Produto extends SugarRecord{

    private String nome;
    private double preco;

    private boolean removido;

    public Produto() {
    }

    public Produto( String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + getId() + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
