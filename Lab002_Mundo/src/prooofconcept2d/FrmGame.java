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
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener{
    private Thread t;
    private CanvasDib c;
    
    public int disX;
    public int disY;
    public int altraX;
    public int my;
    public int velocidad = 10;
    public int vel = 0;
    public int acelerar = 30;
    public int salto = 20;
    public String sonidoSaltar;
    public String sonidoStage;
    
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
        
        setFocusable(true);
        Clip sonidoStage = c.getClip("./sonidos/stage.mid");
        sonidoStage.start();
        sonidoStage.loop(500);
     
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
    public void keyTyped(KeyEvent ke) {
            }    
   
    @Override
    public void keyPressed(KeyEvent ke) {
        disX = c.getpersonajeX();
        disY = c.getpersonajeY();
        altraX = c.getX();                
       
        //Sinistra =)
        if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println(altraX);
            
            //c.setpersonajeX(disX -30);
            
            if(disX /*<=250 && disX */> 0){                                
                    c.setpersonajeX(disX-5);
            }else{
                c.setpersonajeX(0);
            }
                //c.getX();
                //c.setX(mx +50);
                //c.setpersonajeX(150);
            //}
        }
        else if (ke.getKeyCode()== KeyEvent.VK_RIGHT ){
            c.setpersonajeX(disX + 3);
                        
            //System.out.println(altraX);
            //System.out.println(disY);
            
            if (disX < 650){
                c.setpersonajeX(disX+5);
            }else{
                c.setpersonajeX(650);                
                c.getX();
                c.setX(altraX -50);                
            }
        }
        else if (ke.getKeyCode() == KeyEvent.VK_UP){
            c.setpersonajeY(200);
            Clip sonidoStage = c.getClip("./sonidos/saltar.wav");
            sonidoStage.start();
            int avanza = disX;
            c.setpersonajeX(avanza + 100);
        }
        else if (ke.getKeyCode() == KeyEvent.VK_SPACE){
            c.setpersonajeX(disX + velocidad);
            if (disX >= 350){
                c.getX();
                c.setX(altraX -250);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke){
        if (ke.getKeyCode() == KeyEvent.VK_UP){
            c.setpersonajeY(280);
            int cadere = disX;
            c.setpersonajeX(cadere + 100);
        }        
    }
    
    /*@Override
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
                    c.setpersonajeY(320);
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
    }*/
}
