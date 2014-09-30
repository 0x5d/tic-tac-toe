package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class TicTacToeLocalServer extends Thread{

	private int port;
	private ServerSocket server;
	
	public TicTacToeLocalServer(int port){
		this.port = port;
		
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		while(true){
			try{
				server.accept();
			}
			catch(IOException ioe){
				
			}
		}
	}
}
