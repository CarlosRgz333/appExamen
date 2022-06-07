package com.example.appexamenc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtBase, txtAltura;
    private Button btnLimpiar, btnSiguiente, btnSalir;
    private Rectangulo rectangulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtBase = (EditText) findViewById(R.id.txtBase);

        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtAltura.setText("");
                txtBase.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((txtAltura.getText().toString().matches(""))||(txtNombre.getText().toString().matches(""))||(txtBase.getText().toString().matches(""))){
                    Toast.makeText(MainActivity.this, "Rellene todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    rectangulo = new Rectangulo(Float.parseFloat(txtBase.getText().toString()), Float.parseFloat(txtAltura.getText().toString()));
                    Intent intento = new Intent(MainActivity.this, CalculosRectangulo.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("rectangulo", rectangulo);
                    bundle.putString("nombre", txtNombre.getText().toString());

                    intento.putExtras(bundle);
                    startActivity(intento);

                }

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}