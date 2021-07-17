package com.cedaniel200.tutorial.genericos;

public class Main {
    public static void main(String[] args) {
        ContendorSinGenericos contendorSinGenericos = new ContendorSinGenericos();
        contendorSinGenericos.setDato(new Circulo());

        if(contendorSinGenericos.getDato() instanceof Rectangulo){
            Rectangulo rectangulo = (Rectangulo) contendorSinGenericos.getDato();
            System.out.println("ENTRO SOY UN RECTANGULO");
        }

        ContenedorConGenericos<Rectangulo> contenedorConGenericos = new ContenedorConGenericos<>();
        contenedorConGenericos.setDato(new Rectangulo());
        Rectangulo rectangulo = contenedorConGenericos.getDato();
    }
}
