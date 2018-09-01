package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseView {

    JFrame frame;
    JPanel panel;
    JButton boton;
    //MiCanvas canvas;

    BaseView() {
        frame = new JFrame("Title del frame");
        panel = new JPanel();
        boton = new JButton("Nuevo");
        //canvas = new MiCanvas();
    }

    public void lanza() {
        //events
        boton.addActionListener(e -> {

        });
        //custom
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //canvas.setSize(new Dimension(600, 480));
        //frame.add(canvas, BorderLayout.CENTER);
        panel.add(boton);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(new Dimension(600, 500));
        frame.setLocationRelativeTo(null);
        createTabuladores(frame);
        frame.setVisible(true);
    }

    public void createTabuladores(JFrame frame) {
        JTabbedPane jTabbedPane = new JTabbedPane();

        ArrayList<FormModel> formDomicilio = new ArrayList<>(Arrays.asList(
                new FormModel("Calle", 10),
                new FormModel("Colonia", 10),
                new FormModel("Estado", 10),
                new FormModel("Codigo Postal", 10)
        ));

        JPanel jPDomicilio = new JPanel();
        JPanel jPActions = new JPanel();
        JButton button = new JButton("Agregar");
        jPActions.add(button, BorderLayout.SOUTH);

        formDomicilio.forEach(e -> {
            JPanel jPForm = new JPanel();
            jPForm.add(new JLabel(e.getName()), BorderLayout.CENTER);
            JTextField jTextField = new JTextField();
            jTextField.setColumns(e.getColumn());
            jPForm.add(jTextField, BorderLayout.CENTER);
            jPDomicilio.add(jPForm, BorderLayout.CENTER);
        });
        jPDomicilio.add(jPActions, BorderLayout.SOUTH);
        jTabbedPane.addTab("Domicilio", jPDomicilio);





        JPanel jPCliente = new JPanel();
        jPCliente.add(new JLabel("Estas en el panel 2"));
        jTabbedPane.addTab("Cliente", jPCliente);

        JPanel jPBanco = new JPanel();
        jPBanco.add(new JLabel("Estas en el panel 2"));
        jTabbedPane.addTab("Banco", jPBanco);

        frame.getContentPane().add(jTabbedPane);
    }

    public void centeredFrame(JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
    }

    public static void main(String[] args) {
        //BaseView baseView = new BaseView();
        //baseView.lanza();
    }
}
