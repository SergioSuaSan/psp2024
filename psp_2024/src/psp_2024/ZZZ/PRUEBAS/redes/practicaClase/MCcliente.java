package psp_2024.ZZZ.PRUEBAS.redes.practicaClase;

import java.io.*; 
import java.net.*;   
public class MCcliente { 
  public static void main(String args[]) throws Exception { 
    //Se crea el socket multicast 
    int Puerto = 12345;//Puerto multicast
    MulticastSocket ms = new MulticastSocket(Puerto);  
   
    ms.setNetworkInterface(NetworkInterface.getByInetAddress(InetAddress.getByName("172.19.185.1")));
    
   // InetAddress grupo = InetAddress.getByName("225.0.0.1");//Grupo
    InetAddress grupo = InetAddress.getByName("224.0.0.1");
    
    //Nos unimos al grupo
   // ms.joinGroup (grupo );
    
    int puerto = 12345;
    
    SocketAddress sa = new InetSocketAddress(grupo, puerto);

    ms.joinGroup(sa, null);

    String msg="";
    
    //
    while(!msg.trim().equals("*")) {  
      byte[] buf = new byte[1000];
      //Recibe el paquete del servidor multicast      
      DatagramPacket paquete = new DatagramPacket(buf, buf.length);
      ms.receive(paquete);

	msg = new String(paquete.getData());
	System.out.println ("Recibo: " + msg.trim());	
    }
    //ms.leaveGroup (grupo); //abandonamos grupo
    ms.leaveGroup (sa, null);
    ms.close (); //cierra socket
    System.out.println ("Socket cerrado...");
   } 
}  
