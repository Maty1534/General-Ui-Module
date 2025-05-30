package general;

import java.util.function.Consumer;

public class AccionTarea {
    private String nombre;
    private AccionConSalida accion;

    public AccionTarea(String nombre, AccionConSalida accion) {
        this.nombre = nombre;
        this.accion = accion;
    }

    public String getNombre() {
        return nombre;
    }

    public void ejecutar(Consumer<String> salida) {
        accion.ejecutar(salida);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
