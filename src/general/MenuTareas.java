package general;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuTareas extends JFrame {
    private final JTextArea textoSalida;

    public MenuTareas(List<Tarea> tareas) {
        List<Tarea> tareaXdefecto = new ArrayList<>();
        String limpiarTitulo = "Limpiar Salida.";

        // Diseño de la interfaz grafica de usuario
        setTitle("Dynamic Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // Header azul
        JLabel header = new JLabel("Menu Tareas", SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(new Color(33, 150, 243)); // Azul Material
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 18));
        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(header, BorderLayout.NORTH);

        // Área de salida
        textoSalida = new JTextArea();
        textoSalida.setEditable(false);
        textoSalida.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
        textoSalida.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textoSalida);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 2));
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotonesTareas = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotonesTareas.setBackground(Color.WHITE);

        for (Tarea t: tareas) {
            panelBotonesTareas.add(crearBoton(t));
        }

        // Contenedor final para todos los botones abajo
        JPanel panelBotonesDefecto = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotonesDefecto.setBackground(Color.WHITE);

        // Botones por defecto
        Tarea limpiar = new Tarea (limpiarTitulo, "Se limpiará la salida de texto.");
        limpiar.agregarMetodo("Limpiar", salida -> textoSalida.setText(""));
        tareaXdefecto.add(limpiar);

        Tarea salir = new Tarea("Salir del programa", "Finalizar ejecución.");
        salir.agregarMetodo("Salir",salida -> System.exit(0));
        tareaXdefecto.add(salir);

        for (Tarea t: tareaXdefecto) {
            panelBotonesDefecto.add(crearBoton(t));
        }

        // Panel contenedor inferior
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(Color.WHITE);
        panelInferior.add(panelBotonesTareas, BorderLayout.CENTER);
        panelInferior.add(panelBotonesDefecto, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton crearBoton(Tarea botonTarea) {
        JButton boton = new JButton(botonTarea.getTitulo());
        boton.setFocusPainted(false);
        boton.setBackground(Color.WHITE);
        boton.setForeground(new Color(33, 150, 243));
        boton.setBorder(new RoundedBorder(20));
        boton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(180, 40));
        boton.setToolTipText(botonTarea.getDescripcion());
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
        boton.addActionListener(e -> {
            Color original = boton.getBackground();
            boton.setBackground(new Color(200, 230, 255)); // Azul clarito animado

            // Timer para restaurar el color luego de 150 ms
            Timer timer = new Timer(150, evt -> boton.setBackground(original));
            timer.setRepeats(false);
            timer.start();

            textoSalida.append("\n>>> Tarea:  " + botonTarea.getTitulo() + "\n");
            botonTarea.ejecutar(texto -> {
                textoSalida.append(texto + "\n");
                textoSalida.setCaretPosition(textoSalida.getDocument().getLength());
            });
        });
        return boton;
    }

}
