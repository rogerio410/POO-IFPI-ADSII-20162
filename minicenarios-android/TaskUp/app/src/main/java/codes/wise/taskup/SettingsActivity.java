package codes.wise.taskup;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private EditText edUsuarioNome;
    private EditText edUsuarioEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        edUsuarioNome = (EditText) findViewById(R.id.ed_usuario_nome);
        edUsuarioEmail = (EditText) findViewById(R.id.ed_usuario_email);

        loadSettings();
    }


    public void loadSettings(){
        SharedPreferences preferencias =
                getSharedPreferences("codes.wise.taskup.configuracoes", Context.MODE_PRIVATE);
        String nome = preferencias.getString("usuario_nome", "N/A");
        String email = preferencias.getString("usuario_email", "N/A");

        edUsuarioNome.setText(nome);
        edUsuarioEmail.setText(email);
    }

    public void saveSettings(View view) {

        SharedPreferences preferencias =
                getSharedPreferences("codes.wise.taskup.configuracoes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario_nome", edUsuarioNome.getText().toString());
        editor.putString("usuario_email", edUsuarioEmail.getText().toString());
        editor.commit();

        Toast.makeText(this, "Salvo", Toast.LENGTH_LONG).show();

    }

}
