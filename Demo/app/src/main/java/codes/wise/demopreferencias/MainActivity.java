package codes.wise.demopreferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        edNome = (EditText) findViewById(R.id.ed_nome);
        edEmail = (EditText) findViewById(R.id.ed_email);

        preferences = getSharedPreferences("codes.wise.preferencias", Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showPreferences();
    }

    public void savePreferences(View view) {

        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("nome", nome);
        editor.putString("email", email);

        editor.commit();

        edNome.getText().clear();
        edEmail.getText().clear();

        showPreferences();

        Snackbar.make(view, "Salvo", Snackbar.LENGTH_LONG).show();

    }

    public void loadPreferences(View view){
        String nome = preferences.getString("nome", "N/A");
        String email = preferences.getString("email", "N/A");

        edNome.setText(nome);
        edEmail.setText(email);

    }

    public void showPreferences(){
        String nome = preferences.getString("nome", "N/A");
        String email = preferences.getString("email", "N/A");

        TextView tvNome = (TextView) findViewById(R.id.tv_nome);
        TextView tvEmail = (TextView) findViewById(R.id.tv_email);

        tvNome.setText(nome);
        tvEmail.setText(email);


    }

    public void clearPreferences(View view) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

        Snackbar.make(view, "Clear", Snackbar.LENGTH_LONG).show();

    }
}
