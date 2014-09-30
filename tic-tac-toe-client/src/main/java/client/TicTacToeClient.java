package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TicTacToeClient {
	
	private int localServerPort;
	private String localServerIp;
	private Socket con;

	public TicTacToeClient(int port, String ip){
		localServerPort = port;
		localServerIp = ip;
		System.out.println("puioyuo");
		
		try{
            con = new Socket(ip, port);
			System.out.println("Connection established.");
			ObjectOutputStream os = new ObjectOutputStream(con.getOutputStream());
			os.writeChar('p');
		}
		catch(IOException ioe){
			System.out.println("Client error.");
		}
	}
}
