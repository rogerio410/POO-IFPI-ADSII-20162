package codes.wise.androidintro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSend;
    private EditText edMessage;

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
}
