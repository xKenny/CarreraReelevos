/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerareelevos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Duvan Poveda
 * Clase que maneja el segundo grupo de corredores
 */
public class Carrera3 extends Thread{
    private JLabel eti;
    private FrameCarrera p;
    
    public Carrera3(JLabel eti, FrameCarrera p){
        this.eti = eti;
        this.p = p;
    }
     /**
    * Metodo para correr los hilos y aumentar de forma aleatoria la posicion de cada corredor
     */
    @Override
    public void run(){
        int c1 = 0, c2 = 0, c3=0;
        while(true){
            try {
                sleep((int)(Math.random()*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            c1 = p.getCorredorAC().getLocation().x;
            c2 = p.getCorredorBC().getLocation().x;
            c3 = p.getCorredorCC().getLocation().x;
            if(c1<p.getNivel3().getLocation().x-51&&c2<p.getNivel3().getLocation().x-51&&c3<p.getNivel3().getLocation().x-51){
                eti.setLocation(eti.getLocation().x+5,eti.getLocation().y);
                p.repaint();
            }
           if(eti.getLocation().x>=p.getNivel3().getLocation().x-51){
                if(c1>c2&&c1>c3){
                    JOptionPane.showMessageDialog(null, "Gano el equipo 1");
                }else if(c2>c1&&c2>c3){
                    JOptionPane.showMessageDialog(null, "Gano el equipo 2");
                }else if(c3>c2&&c3>c1){
                    JOptionPane.showMessageDialog(null, "Gano el equipo 3");
                }
            }
        }
    }
}
