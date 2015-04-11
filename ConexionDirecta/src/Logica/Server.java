/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author root
 */
public class Server {
    
         public static void main(String[]args) {
                Server i = new Server();
         }
         private ServerSocket ssocket;
         private int puerto;
         public ArrayList<Socket> clientes;
         private int num_cli;
         
    
         public Server() {
                 puerto = 2015;
                 num_cli =0;
                 clientes = new ArrayList();
                 
                 initServer();
                 
                 
         }
         
         public void initServer() {
                 try {
                           ssocket = new ServerSocket(puerto);
                           for(;;) {
                                   clientes.add(ssocket.accept());
                                   ((HiloS) new HiloS(clientes.get(num_cli),clientes)).start();
                                   num_cli++;
                           }
                }catch(Exception e) { System.out.println("Error " +e); }
        }
    
}
