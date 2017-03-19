package codes.wise.hellow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        edMensagem = (EditText) findViewById(R.id.caixa_mensagem);
    }

    public void enviarMensagem(View view) {
        //Abrir outra tela e mandar a mensagem digitado.

        String texto = edMensagem.getText().toString();

        if (!"".equals(texto)){

            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("mensagem", texto);

            startActivity(intent);

        }else {
            Toast tip = Toast.makeText(this, "Informe uma msg.", Toast.LENGTH_LONG);
            tip.setGravity(Gravity.CENTER, 0, 0);
            tip.show();
        }



    }
}
