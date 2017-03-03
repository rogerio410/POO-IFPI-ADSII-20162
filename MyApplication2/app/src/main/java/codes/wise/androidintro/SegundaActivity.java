package codes.wise.androidintro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView tvPacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tvPacote = (TextView) findViewById(R.id.pacote_recebido);

        Intent intent = getIntent();
        String pacote = intent.getStringExtra("pacote");

        tvPacote.setText(pacote);

    }
}
