/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x = 0;
    private int y = 0;
    private int personaje_x = 10;
    private int personaje_y = 280;
    private BufferedImage sample;
    private BufferedImage mario;    
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
         g.setColor(Color.BLUE);     //Activa el color azul
         //g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
         //if(mario == null) mario = cargarImagen("./images/mario.png");
         //g.drawImage(mario, x, 80, this);
         
         if (sample == null) sample = cargarImagen("./images/fondo1.jpg");
         
         mario = cargarImagen("./images/mario.png");
         g.drawImage(sample, x, y, this); 
         g.drawImage(mario, personaje_x ,personaje_y, this);         
    }   

    @Override
    public void update(Graphics g)
    {
        super.update(g);
        paint(g);        
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public int getpersonajeX() {
        return personaje_x;
    }
    
    public void setpersonajeX(int personaje_x) {
        this.personaje_x = personaje_x;
    }
    
    public int getpersonajeY() {
        return personaje_y;
    }
    
    public void setpersonajeY(int personaje_y) {
        this.personaje_y = personaje_y;
    }
    
    public Clip getClip(String audiofile){
        Clip clip = null;
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(audiofile));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
       } catch (Exception ex) {
           ex.printStackTrace();
       }
        return clip;      
    }
}
