package general;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class UiBoton extends UiAccion {
    private final Consumer<Consumer<String>> accion;

    public UiBoton (String titulo, String descripcion, Consumer<Consumer<String>> accion) {
        super(titulo, descripcion);
        this.accion = accion;
    }

    @Override
    public JComponent construirComponente(Consumer<String> salida) {
        JButton boton = new JButton(titulo);
        boton.setToolTipText(descripcion);
        boton.setBackground(Color.WHITE);
        boton.setForeground(new Color(33, 150, 243));
        boton.setBorder(BorderFactory.createLineBorder(new Color(33, 150, 243)));
        boton.setFont(new Font("SansSerif",Font.PLAIN, 14));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(180, 40));
        boton.addActionListener(e -> accion.accept(salida));
        return boton;
    }
}
