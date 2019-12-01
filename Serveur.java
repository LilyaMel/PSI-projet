import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.*;
import java.security.Security;

public class Serveur{

    
    public static void main(String[] args){
        
		System.setProperty("javax.net.ssl.keyStore", "server.jsk");
		System.setProperty("javax.net.ssl.keyStorePassword" , "123456");
		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		
        try{
            
			SSLServerSocket server = (SSLServerSocket)factory.createServerSocket(1027);
            System.out.println("..... Bienvenue sur notre Serveur ....");   
            while(true){
            	System.out.println(server.getInetAddress().getLocalHost().getHostAddress());
                SSLSocket socket = (SSLSocket)server.accept();
                Fonctions serv = new Fonctions(socket);
                Thread t = new Thread(serv);
                t.start();  
                
            }
        }catch(Exception e){
            System.out.println("Serveur ne peut pas connecter");
        }       
    } 
     
}