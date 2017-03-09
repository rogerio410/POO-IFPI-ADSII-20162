package codes.wise.taskup;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private EditText edUsuarioNome;
    private EditText edUsuarioEmail;
    private RadioGroup rgIdioms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        edUsuarioNome = (EditText) findViewById(R.id.ed_usuario_nome);
        edUsuarioEmail = (EditText) findViewById(R.id.ed_usuario_email);
        rgIdioms = (RadioGroup) findViewById(R.id.rg_idioms);

        loadSettings();

    }


    public void loadSettings(){
        SharedPreferences preferencias =
                getSharedPreferences("codes.wise.taskup.configuracoes", Context.MODE_PRIVATE);
        String nome = preferencias.getString("usuario_nome", "N/A");
        String email = preferencias.getString("usuario_email", "N/A");
        String idioma = preferencias.getString("idioma", "");

        edUsuarioNome.setText(nome);
        edUsuarioEmail.setText(email);

        Toast.makeText(this, idioma, Toast.LENGTH_SHORT).show();

        switch (idioma){
            case "pt":
                rgIdioms.check(R.id.portuguese);
                break;
            case "en":
                rgIdioms.check(R.id.english);
                break;
        }


    }

    public void saveSettings(View view) {

        String idiom = "";

        switch (rgIdioms.getCheckedRadioButtonId()){
            case R.id.portuguese:
                idiom = "pt";
                break;
            case R.id.english:
                idiom = "en";
        }


        SharedPreferences preferencias =
                getSharedPreferences("codes.wise.taskup.configuracoes", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario_nome", edUsuarioNome.getText().toString());
        editor.putString("usuario_email", edUsuarioEmail.getText().toString());
        editor.putString("idioma", idiom);
        editor.commit();

        changeLocale(idiom);

        Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();


    }

    private void changeLocale(String selectIdiom) {

        //TODO
        //Toast.makeText(this, "Idiom select - Unavaiable", Toast.LENGTH_SHORT).show();

    }

}
