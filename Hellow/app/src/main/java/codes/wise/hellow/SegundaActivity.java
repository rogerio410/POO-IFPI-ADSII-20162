package codes.wise.hellow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView tvMensagem;
    private String pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Binding
        tvMensagem = (TextView) findViewById(R.id.mensagem);

        Intent intent = getIntent();

        pacote = intent.getStringExtra("mensagem");

        tvMensagem.setText(pacote);

    }

}
