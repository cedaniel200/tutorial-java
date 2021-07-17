package com.cedaniel200.tutorial.genericos;

public class ContenedorConGenericos<T> {
    private T dato;

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
