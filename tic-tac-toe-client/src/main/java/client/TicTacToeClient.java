package client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TicTacToeClient {
	
	private Socket s;
    DataInputStream dis = null;
    DataOutputStream dos = null;

	public TicTacToeClient(int port, String ip){	
		try{
            s = new Socket(ip, port);
			dos = new DataOutputStream(s.getOutputStream());
			dos.flush();
			dis = new DataInputStream(s.getInputStream());
		}
		catch(IOException ioe){
			System.out.println("Client error.");
		}
	}
	    
    public void close() {
        try {
            send("QUIT");
            s.close();
            s = null;
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String recv(){
        String msg = null;
        try {
            
            msg = dis.readUTF();

        } catch (IOException ex) {
            Logger.getLogger(TicTacToeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    } 
}
