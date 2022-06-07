package com.example.appexamenc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculosRectangulo extends AppCompatActivity {
    private TextView lblNombre, lblAltura, lblResultado, lblBase;
    private Button btnCalcular, btnRegresar;
    private RadioButton rbtnArea, rbtnPerimetro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos_rectangulo);

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        lblBase = (TextView) findViewById(R.id.lblBase);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        rbtnArea = (RadioButton) findViewById(R.id.rbtnArea);
        rbtnPerimetro = (RadioButton) findViewById(R.id.rbtnPerimetro);
        Bundle datosIntento = getIntent().getExtras();
        Rectangulo rect = (Rectangulo) datosIntento.getSerializable("rectangulo");

        lblNombre.setText(lblNombre.getText().toString()+datosIntento.getString("nombre"));
        lblBase.setText(lblBase.getText().toString()+rect.getBase());
        lblAltura.setText(lblAltura.getText().toString()+rect.getAltura());

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat formato = new DecimalFormat("0.000");
                if(rbtnArea.isChecked()){
                    lblResultado.setText("El resultado del área es: "+formato.format(rect.calcularArea()));
                }else if(rbtnPerimetro.isChecked()){
                    lblResultado.setText("El resultado del perímetro es: "+formato.format(rect.calcularPerimetro()));
                }else{
                    Toast.makeText(CalculosRectangulo.this, "Seleccioné un Calculo!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}