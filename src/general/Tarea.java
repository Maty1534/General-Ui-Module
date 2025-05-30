package general;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Tarea {
    private String titulo;
    private String descripcion;
    private List<AccionTarea> listaMetodos;

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.listaMetodos = new ArrayList<>();
    }

    public String getTitulo() { return titulo; }

    public String getDescripcion() { return descripcion; }

    public void agregarMetodo (String nombre, AccionConSalida accion) {
        listaMetodos.add(new AccionTarea(nombre, accion));
    }

    public void ejecutar (Consumer<String> salida) {
        for (AccionTarea accion: listaMetodos) {
            salida.accept("Ejecutando: " + accion.getNombre());
            accion.ejecutar(salida);
        }
    }

    @Override
    public String toString() {
        return titulo + ": " + descripcion +
                "\nLista de metodos: " + listaMetodos;
    }
}
