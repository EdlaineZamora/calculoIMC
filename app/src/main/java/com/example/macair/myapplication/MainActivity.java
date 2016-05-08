package com.example.macair.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.macair.myapplication.R.id.tResultado;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btCalcular).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double peso = Double.parseDouble(((EditText) findViewById(R.id.edPeso)).getText().toString());
        double altura = Double.parseDouble(((EditText) findViewById(R.id.edAltura)).getText().toString());
        EditText resultado = (EditText) findViewById(R.id.edResultadoImc);

        double resultadoImc = peso / (altura * altura);
        resultado.setText(String.valueOf(resultadoImc));

        calculaResultadoMulher(resultadoImc);
    }

    private void calculaResultadoMulher(double resultadoImc) {
        TextView resultado = (TextView) findViewById(tResultado);
        if (resultadoImc < 19.1) {
            resultado.setText("Abaixo do peso");
        }
        else if (resultadoImc >= 19.1 && resultadoImc < 25.8) {
            resultado.setText("No peso normal");
        }
        else if (resultadoImc >= 25.8 && resultadoImc < 27.3) {
            resultado.setText("Marginalmente acima do peso");
        }
        else if (resultadoImc >= 27.3 && resultadoImc < 32.3) {
            resultado.setText("Acima do peso ideal");
        } else {
            resultado.setText("Obeso");
        }
    }

}
