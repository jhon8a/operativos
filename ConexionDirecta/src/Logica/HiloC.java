/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author root
 */
public class HiloC extends Thread{
    private DataInputStream entrada;
                
                public HiloC(Socket s) {
                            try {
                                    entrada = new DataInputStream(s.getInputStream());
                            }catch(Exception e) { System.out.print(e); }
                }
    
                public void run() {
                            try {
                                    for(;;) {
                                            String msn=entrada.readUTF();
                                            System.out.println("Server dice: " +msn);    
                                    }
                            }catch(Exception e) { System.out.print(e); } 
                }
                
}
