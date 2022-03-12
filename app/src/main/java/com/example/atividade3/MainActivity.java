package com.example.atividade3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView tv1,tv2;
    private EditText et1;
    private Button bt1;
    private String name,name2;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        bt1 = (Button) findViewById(R.id.bt1);

        spn = findViewById(R.id.spinner1);

        String[] moedas = getResources().getStringArray(R.array.names);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, moedas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                double valorReal = Double.parseDouble(et1.getText().toString());
                double valorPeso = valorReal * 8.4;
                double valorDolar = valorReal * 5.10;

                name = "Peso: " + String.valueOf(valorPeso);
                name2 = "Dolar: " + String.valueOf(valorDolar);
                tv1.setText(name);
                tv2.setText(name2);
            }
        });

        if(savedInstanceState != null){
            name = savedInstanceState.getString("chaveNome");
        }else{
            name = "Conversor de Moedas";
        }

    }
    protected void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putString("chaveNome", name);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinner1) {
            Toast.makeText(this, "TESTEE", Toast.LENGTH_SHORT).show();
            String valueFromSpinner = adapterView.getItemAtPosition(i).toString();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}