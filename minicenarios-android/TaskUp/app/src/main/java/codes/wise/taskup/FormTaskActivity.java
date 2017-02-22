package codes.wise.taskup;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import codes.wise.taskup.dao.TarefaDAO;
import codes.wise.taskup.model.Tarefa;

public class FormTaskActivity extends AppCompatActivity {

    private EditText edDescricao;
    private Spinner spPrioridade;
    private EditText edDetalhes;
    private EditText edDataLimite;
    private Calendar dataLimite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_task);

        edDescricao = (EditText) findViewById(R.id.ed_task_descricao);
        spPrioridade = (Spinner) findViewById(R.id.sp_task_prioridade);
        edDetalhes = (EditText) findViewById(R.id.ed_task_detalhes);
        edDataLimite = (EditText) findViewById(R.id.ed_task_data_limite);

        edDataLimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obter data Corrente.
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                // Criar uma Dialog para Data e Definir o Comportamento ao selecionar uma data.
                DatePickerDialog datePickerDialog = new DatePickerDialog(FormTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                        //Definindo formtador de Data para String
                        String formato = "dd/MM/yyyy";
                        SimpleDateFormat format = new SimpleDateFormat(formato, Locale.getDefault());

                        //Obtem um instancia Nova de Calender
                        dataLimite = Calendar.getInstance();
                        dataLimite.set(Calendar.YEAR, ano);
                        dataLimite.set(Calendar.MONTH, mes);
                        dataLimite.set(Calendar.DAY_OF_MONTH, dia);

                        //Aplica a Formatação
                        edDataLimite.setText(format.format(dataLimite.getTime()));
                    }
                }, mYear, mMonth, mDay);

                //Exibe a dialog.
                datePickerDialog.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.formtask_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void saveTask(MenuItem item) {

        String descricao = edDescricao.getText().toString();
        double prioridade = Double.valueOf(spPrioridade.getSelectedItem().toString());
        String detalhes = edDetalhes.getText().toString();

        Tarefa tarefa = new Tarefa(descricao, prioridade);
        tarefa.setDetalhes(detalhes);
        tarefa.setDataLimite(dataLimite);

        //TarefaDAO dao = new TarefaDAO(this);
        //dao.inserir(tarefa);
        tarefa.save();

        Toast.makeText(this, "Tarefa salva", Toast.LENGTH_LONG).show();
        finish();
    }
}
