# Genéricos en Java

Ejemplo práctico de **genéricos** en Java: por qué existen, qué problema resuelven y cómo cambia el
código cuando se usan. Es material de nivel básico, pensado para acompañar los tutoriales de Java del
canal.

## El problema: un contenedor sin genéricos

`ContendorSinGenericos` guarda un `Object`. Eso permite meter cualquier cosa, pero el compilador deja
de saber qué hay dentro:

```java
ContendorSinGenericos contenedor = new ContendorSinGenericos();
contenedor.setDato(new Circulo());

if (contenedor.getDato() instanceof Rectangulo) {
    Rectangulo rectangulo = (Rectangulo) contenedor.getDato();
    System.out.println("ENTRO SOY UN RECTANGULO");
}
```

- El tipo real solo se descubre en ejecución.
- Hay que comprobar con `instanceof` y hacer un cast.
- Si el cast es incorrecto, el programa falla con `ClassCastException`.

En `Main`, el contenedor guarda un `Circulo` y se comprueba si es un `Rectangulo`; la condición es
falsa y no imprime nada. Si cambias el valor por `new Rectangulo()`, verás el mensaje. El ejemplo
muestra el problema: sin genéricos, el tipo no está garantizado.

## La solución: un contenedor genérico

`ContenedorConGenericos<T>` declara el tipo en la clase y lo conserva en todos sus métodos:

```java
ContenedorConGenericos<Rectangulo> contenedor = new ContenedorConGenericos<>();
contenedor.setDato(new Rectangulo());
Rectangulo rectangulo = contenedor.getDato(); // sin cast
```

- El tipo se elige al crear el contenedor.
- El compilador rechaza `contenedor.setDato(new Circulo())`.
- Ya no hacen falta `instanceof` ni casts.

## Estructura

| Archivo | Para qué sirve |
|---|---|
| `ContendorSinGenericos.java` | Contenedor con `Object`: el problema |
| `ContenedorConGenericos.java` | Contenedor con `<T>`: la solución |
| `Circulo.java`, `Rectangulo.java`, `Triangulo.java` | Tipos de ejemplo; no tienen comportamiento |
| `Main.java` | Compara los dos contenedores |

## Cómo ejecutarlo

No hay wrapper de Gradle, así que se compila con el JDK:

```bash
javac -d out $(find src/main/java -name '*.java')
java -cp out com.cedaniel200.tutorial.genericos.Main
```

También puedes abrir el proyecto en IntelliJ IDEA o VS Code y ejecutar `Main`.

## Qué aprenderás

- Qué problema resuelve un genérico frente a usar `Object`.
- Cómo el compilador detecta errores de tipo antes de ejecutar.
- Por qué `instanceof` y los casts son una señal de que falta tipado.
- Cómo instanciar un contenedor con un tipo concreto (`ContenedorConGenericos<Rectangulo>`).

## Siguientes pasos

- Tipos acotados: `<T extends Number>`.
- Comodines: `? extends T` y `? super T`.
- Borrado de tipos (*type erasure*) y sus consecuencias.

---

[Volver al README](../README.md)
