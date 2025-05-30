package general;

import javax.swing.*;
import java.util.function.Consumer;

public abstract class UiAccion {
    protected String titulo;
    protected String descripcion;

    public UiAccion(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public abstract JComponent construirComponente(Consumer<String> salida);

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

