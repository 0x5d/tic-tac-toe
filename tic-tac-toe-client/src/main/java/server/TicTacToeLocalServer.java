package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TicTacToeLocalServer extends Thread{

	private int port;
	private ServerSocket server;
	
	public TicTacToeLocalServer(int port){
		this.port = port;
		
		try {
			server = new ServerSocket(port);
			System.out.println("esperando");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		TicTacToeSocketServer tss = null;
		try{
			Socket p1 = server.accept();
			Socket p2 = server.accept();
			tss = new TicTacToeSocketServer(p1,p2);
			tss.run();
		}
		catch(IOException ioe){
			
		}
	}
}
