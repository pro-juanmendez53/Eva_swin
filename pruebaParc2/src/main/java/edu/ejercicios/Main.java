package edu.ejercicios;

import edu.ejercicios.formularios.frmPizza;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
    {

        JFrame frame = new JFrame("frmPizza");
        frame.setContentPane(new frmPizza().getJpanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.pack();
        frame.setVisible(true);







    }


}