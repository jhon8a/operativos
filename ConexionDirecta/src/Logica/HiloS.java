/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class HiloS extends Thread {
    
        private Socket scks;
        private ArrayList<Socket> clientes;
        private DataInputStream entrada;
        private DataOutputStream salida;
    
        public HiloS(Socket socket, ArrayList<Socket> clientes) {
                    this.clientes = clientes;
                    try {
                            entrada = new DataInputStream(socket.getInputStream());
                            salida = new DataOutputStream(socket.getOutputStream());
                    }catch(Exception e) { System.out.print(e); }
        }
        
        public void run() {
                try {
                        for(;;) {
                                String llegada = entrada.readUTF();
                                System.out.println("Cliente dice: " +llegada);
                                for(int a=0;a<clientes.size();a++) {
                                        try {
                                                salida = new DataOutputStream(clientes.get(a).getOutputStream());
                                                salida.writeUTF(llegada);
                                        }catch(IOException ex) { System.out.println("Error " +ex); }
                                }
                        }  
                }catch(Exception r) { System.out.print(r); } 
        }
    
}
