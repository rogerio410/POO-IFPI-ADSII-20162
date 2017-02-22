package codes.wise.taskup.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rogermac on 20/02/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TaskUp";
    private static final int VERSION = 1;
    public static final String TABELA_TAREFA = "Tarefa";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABELA_TAREFA + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descricao VARCHAR, " +
                "prioridade FLOAT, " +
                "dataLimite DATE, " +
                "detalhes VARCHAR);";


        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFA;
        db.execSQL(sql);
        onCreate(db);
    }
}
