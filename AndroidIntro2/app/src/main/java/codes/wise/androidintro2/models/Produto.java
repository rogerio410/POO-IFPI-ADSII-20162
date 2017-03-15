package codes.wise.androidintro2.models;

/**
 * Created by rogermac on 15/03/17.
 */

public class Produto {

    private long id;
    private String nome;
    private double preco;

    public Produto(long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
