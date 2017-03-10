package codes.wise.androidintro;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSend;
    private EditText edMessage;
    private AutoCompleteTextView acPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        btnSend = (Button) findViewById(R.id.botao_send);
        edMessage = (EditText) findViewById(R.id.ed_message);

        //Add um ClickListener
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edMessage.getText().toString();
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("pacote", txt);
                startActivity(intent);

            }
        });

        btnSend.setOnClickListener(this);

        //AutoComplete
        acPaises = (AutoCompleteTextView) findViewById(R.id.paises);
        String [] paises = {"Brasil", "Canadá", "Noruega", "Argentina", "EUA", "Chile"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, paises);
        acPaises.setAdapter(adapter);


    }

    public void abrirTela2(View pipoca){
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("pacote", "Guilherme");
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botao_send){

        }
    }

    public void openSimpleDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hello Android")
                .setPositiveButton("Olá.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast msg = Toast.makeText(MainActivity.this, "Tchau", Toast.LENGTH_SHORT);
                        msg.setGravity(Gravity.CENTER, 0, 0);
                        msg.show();
                    }
                })
                .show();
    }

    public void openMultipleChoiceDialog(View view) {
        AlertDialog.Builder buider = new AlertDialog.Builder(this);
        final String [] skills = {"Android", "Python", "Java", "Unity"};
        final List<String> selecionardos = new ArrayList<>();
        selecionardos.add("Android");
        selecionardos.add("Python");
        buider.setTitle("Select your Skills")
                .setMultiChoiceItems(skills, new boolean[]{true, true, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean checked) {
                        String msg = "Você ";
                        if (checked){
                            msg += "marcou ";
                            selecionardos.add(skills[which]);
                        }else{
                            msg += "desmarcou ";
                            selecionardos.remove(skills[which]);
                        }
                        msg += skills[which];
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msg = "Voce selecionou \n";
                        for (String item: selecionardos) {
                            msg += item + "\n";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                })
                .show();

    }
}
