package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BemVindoActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et_novoNome;
    Button bt_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        et_novoNome = (EditText) findViewById(R.id.et_novoNome);
        tv = (TextView) findViewById(R.id.tvNovaTela);


        Bundle args = getIntent().getExtras();
        String nome = args.getString("idNome");

        tv.setText(nome+", seja bem-vindo!");

        bt_voltar = findViewById(R.id.bt_ok);

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", et_novoNome.getText().toString());
                setResult(69,intent);
                finish();
            }
        });
    }
}