package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DVM {

    JFrame frame;
    JPanel panel;
    JButton boton;
    MiCanvas canvas;

    DVM(){
        frame = new JFrame("Title del frame");
        panel = new JPanel();
        boton = new JButton("Button");
        canvas = new MiCanvas();
    }

    class MiCanvas extends Canvas{
        public void update(Graphics gg){
            paint(gg);
        }

        public void paint(Graphics gg){
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            Color color = new Color(r,g,b);
            int px = (int) (Math.random() * 580);
            int py = (int) (Math.random() * 400);
            gg.setColor(color);
            gg.fillOval(px, py, 50, 50);

        }
    }

    public void lanza(){
        //events
        boton.addActionListener(e -> {
            Thread t  = new Thread(() -> {
                while(true){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException ex){
                        System.out.println(Arrays.toString(ex.getStackTrace()));
                    }
                    canvas.repaint();
                }
            });
            t.start();
        });
        //custom
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setSize(new Dimension(600, 480));
        frame.add(canvas, BorderLayout.CENTER);
        panel.add(boton);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(new Dimension(600, 500));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DVM dvm = new DVM();
        dvm.lanza();
    }
}
