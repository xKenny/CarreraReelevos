/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerareelevos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Duvan Poveda
 * Clase que maneja los primeros 3 corredores
 */
public class Carrera extends Thread{
    private JLabel eti;
    private FrameCarrera p;
    
    /**
    * Constructor principal, recibe el corredor y el frame de la carrera
    * 
     */
    public Carrera(JLabel eti, FrameCarrera p){
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
            c1 = p.getCorredorAA().getLocation().x;
            c2 = p.getCorredorBA().getLocation().x;
            c3 = p.getCorredorCA().getLocation().x;
            if(eti.getLocation().x < (p.getNivel1().getLocation().x-51)){
                eti.setLocation(eti.getLocation().x+5,eti.getLocation().y);
                p.repaint();
            }
           if(eti.getLocation().x>=p.getNivel1().getLocation().x-51){
                if(c1 >= p.getNivel1().getLocation().x-51){
                    Carrera2 hilo4 = new Carrera2(p.getcorredorAB(),p);
                    hilo4.start();
                }
                if(c2 >= p.getNivel1().getLocation().x-51){
                    Carrera2 hilo5 = new Carrera2(p.getcorredorBB(),p);
                    hilo5.start();
                }
                if(c3 >= p.getNivel1().getLocation().x-51){
                    Carrera2 hilo6 = new Carrera2(p.getcorredorCB(),p);
                    hilo6.start();
                }
            }
        }
    }
}
