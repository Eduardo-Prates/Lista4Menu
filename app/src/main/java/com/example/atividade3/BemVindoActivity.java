package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BemVindoActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        tv = (TextView) findViewById(R.id.tvNovaTela);

        Bundle args = getIntent().getExtras();
        String nome = args.getString("idNome");

        tv.setText(nome+", seja bem-vindo!");
    }
}