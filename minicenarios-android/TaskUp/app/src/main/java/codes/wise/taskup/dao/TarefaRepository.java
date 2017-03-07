package codes.wise.taskup.dao;

import java.util.List;

import codes.wise.taskup.model.Atividade;
import codes.wise.taskup.model.Tarefa;

/**
 * Created by rogermac on 02/03/17.
 */

public class TarefaRepository extends SugarAbstractRepository<Tarefa> {

    public TarefaRepository(Class<Tarefa> type) {
        super(type);
    }

    @Override
    public List<Tarefa> all() {
        List<Tarefa> tarefas = super.all();

        for (Tarefa t : tarefas){
            List<Atividade> atividades = Atividade.find(Atividade.class, "tarefa = ?", String.valueOf(t.getId()));
            for (Atividade a: atividades) {
                t.addItem(a);
            }
        }

        return tarefas;
    }
}
