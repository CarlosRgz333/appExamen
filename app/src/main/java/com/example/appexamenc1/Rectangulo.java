package com.example.appexamenc1;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Rectangulo implements Serializable {
    private float base;
    private float altura;

    public Rectangulo() {
    }

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calcularArea(){
        float resultado = 0;
        resultado = this.base * this.altura;
        return resultado;
    }

    public float calcularPerimetro(){
        float resultado = 0;
        resultado = (this.base+this.base)+(this.altura+this.altura);
        return resultado;
    }
}
