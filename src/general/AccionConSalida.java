package general;

import java.util.function.Consumer;

@FunctionalInterface
public interface AccionConSalida {
    void ejecutar(Consumer<String> salida);
}
