package com.example.atividade3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1;
    private EditText et1,et2;
    private Button bt1,bt2;
    private String name;

    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == 69){
                            Intent intent = result.getData();

                            if(intent != null){
                                String data = intent.getStringExtra("result");
                                tv1.setText(data);
                            }
                        }
                    }
                });

        if(savedInstanceState != null){
            name = savedInstanceState.getString("chaveNome");
        }else{
            name = "Za Warudo!";
        }
        tv1.setText(name);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }
    protected void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putString("chaveNome", name);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt1 && et1.getText().toString().equals("Eduardo") && et2.getText().toString().equals("123")){
            name = et1.getText().toString();
            tv1.setText(name);
            Intent intent = new Intent(this, BemVindoActivity.class);
            Bundle parametros = new Bundle();
            parametros.putString("idNome", name);
            intent.putExtras(parametros);
            startActivity(intent);
        }else if(view.getId() == R.id.bt2){
            Intent intent = new Intent(this, BemVindoActivity.class);
            Bundle parametros = new Bundle();
            parametros.putString("idNome", name);
            intent.putExtras(parametros);
            activityResultLauncher.launch(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Login ou senha errados!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}