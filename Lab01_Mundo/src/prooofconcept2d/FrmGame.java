/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener{
    private Thread t;
    private CanvasDib c;
    public FrmGame(CanvasDib c){
       
        addKeyListener(this);
        this.c = c;
        add(c);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
        while (true){
            try {
                Thread.sleep(100);
                c.repaint();
               
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int tecla = ke.getKeyCode();
            //Arriba
            if(tecla==38){
                if(c.getpersonajeY()>0){
                    c.setpersonajeY(c.getpersonajeY()-5);
                }else{
                    c.setpersonajeY(0);
                }
            }
            //Abajo
            else if(tecla==40){                
                if(c.getpersonajeY()<320){
                    c.setpersonajeY(c.getpersonajeY()+5);
                }else{
                    c.setpersonajeY(/*this.getSize().height*/320);
                }
            }
            //Izquierda
            else if(tecla==37){
                if(c.getpersonajeX()>0){
                    c.setpersonajeX(c.getpersonajeX()-5);
                }else{
                    c.setpersonajeX(0);
                }
            }
            //Derecha
            else if(tecla==39){
                if(c.getpersonajeX()<650){
                    c.setpersonajeX(c.getpersonajeX()+5);
                }else{
                    c.setpersonajeX(650);
                }
            }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
