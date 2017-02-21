package codes.wise.taskup.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import codes.wise.taskup.model.Tarefa;

/**
 * Created by rogermac on 20/02/17.
 */

public class TarefaDAO {

    private DBHelper dbHelper;

    public TarefaDAO(Context ctx) {
        DBHelper db = new DBHelper(ctx);
        this.dbHelper = db;
    }

    public void inserir(Tarefa f){
        ContentValues cv = new ContentValues();
        cv.put("descricao", f.getDescricao());
        cv.put("prioridade", f.getPrioridade());
        cv.put("dataLimite", f.getPersistentDataLimite());
        cv.put("detalhes", f.getDetalhes());

        dbHelper.getWritableDatabase().insert(dbHelper.TABELA_TAREFA, null, cv);

    }

    public List<Tarefa> todos(){
        String sql = "select * from " + dbHelper.TABELA_TAREFA +";";
        Cursor c = dbHelper.getReadableDatabase().rawQuery(sql, null);

        List<Tarefa> tarefas = new ArrayList<>();
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String descricao = c.getString(c.getColumnIndex("descricao"));
            double prioridade = c.getDouble(c.getColumnIndex("prioridade"));
            long dataLimite = c.getLong(c.getColumnIndex("dataLimite"));
            String detalhes = c.getString(c.getColumnIndex("detalhes"));

            Tarefa t = new Tarefa(descricao, prioridade);
            t.setId(id);

            if (dataLimite != 0){
                Calendar data = Calendar.getInstance();
                data.setTimeInMillis(dataLimite);
                t.setDataLimite(data);
            }

            t.setDetalhes(detalhes);
            tarefas.add(t);
        }

        return tarefas;
    }
}
