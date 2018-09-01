package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseTemplate{

    public static void main(String[] args) {
        JFrame frame = new JFrame("BaseTemplate");
        frame.setContentPane(new BaseTemplate().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton verDatosButton;
    private JTable table1;
    private JScrollPane jScrollPane;
    private JTable jTDomicilio;

    public BaseTemplate() {
        verDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Code", "Name", "High", "Low",
                        "Close", "Volume", "Change","Change %"};

                Object[][] data = {
                        {"MBF", "CITYGROUP", 10.16, 10.16, 10.16, 200, 0.08,0.79},
                        {"MBL", "BANK OF AMERICA", 12.66, 12.66, 12.66, 6600, 0.13,1.04},
                        {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16}
                };


                table1 = new JTable(data, columns);
                 jScrollPane = new JScrollPane(table1);
                table1.setFillsViewportHeight(true);
                /*
                frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
                jTDomicilio = new JTable(data, columnNames);
                */

            }
        });
    }
}
