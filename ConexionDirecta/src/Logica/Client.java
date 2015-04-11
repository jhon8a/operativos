/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Client {
    
            public static void main(String[]args) {
                  Client c = new Client();
            }
            private Socket socket;
            private DataOutputStream salida;
            private Scanner lea;
            
            public Client() {
                    lea = new Scanner(System.in);
                    initClient();
                    
                    for(;;) {
                            System.out.println("Mensaje a enviar : " );
                            String msn = lea.nextLine();
                            try {
                                salida.writeUTF(msn);
                            }catch(Exception e) { System.out.println("Error " +e); }   
                    }
            }
    
            private void initClient() {
                    try {
                        socket = new Socket("127.0.0.1", 2015);
                        salida = new DataOutputStream(socket.getOutputStream());
                        ((HiloC) new HiloC(socket)).start();
                    }catch(Exception e) { System.out.println("Error " +e); }
            }
    
}
