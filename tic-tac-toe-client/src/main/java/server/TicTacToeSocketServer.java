package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import client.TicTacToeClient;


public class TicTacToeSocketServer {
	
	Socket c1 = null;
	Socket c2 = null;
	boolean player1;
    DataInputStream dis1 = null;
    DataOutputStream dos1 = null;
    DataInputStream dis2 = null;
    DataOutputStream dos2 = null;
    TriquiGame triqui = null;
    String[] command = null;
	int endGame = 0;
    
	public TicTacToeSocketServer(Socket c1, Socket c2) {
		// TODO Auto-generated constructor stub
		this.c1 = c1;
		this.c2 = c2;
	    open();
        triqui = new TriquiGame();
	}
	//todo
	public void run() {
	    try {
	    	player1 = true;
	        String cmd = recvRequest();
	        String response;
	        while (!cmd.equals("QUIT")) {
	            if (cmd.equals("START")) {
	                triqui.Start();
	            } else if (cmd.equals("PLAY")) {
	            	try{
	            		int pos = Integer.parseInt(command[1])-1;
	                	int res = triqui.Play(pos);
	                	System.out.println(pos);
	                	response = ""+res;
	            	}catch(Exception e){
	            		response = "0";
	            	}
            		sendResponse(response);
	            } else if (cmd.equals("PLAYER")) {
	                response = triqui.Player();
	                sendResponse(response);
	            } else if (cmd.equals("BOARD")) {
	                response = triqui.Board();
	                sendResponse(response);
	            } else if (cmd.equals("TESTWINNER")) {
	                response = triqui.TestWinner();
	                sendResponse(response);
	                if (response.equals("N"))
	    	        player1 = !player1;
	            }else if(cmd.equals("YIELD")){
	            	player1 = !player1;
	            	endGame++;
	            	if(endGame == 2){
	            		break;
	            	}
	            }else if(cmd.equals("CANPLAY")){
	            	response = Boolean.toString(triqui.CanPlay());
	                sendResponse(response);
	            }
	            cmd = recvRequest();
	        }
	        c1.close();
	        c1 = null;
	        c2.close();
	        c2 = null;
	    } catch (IOException ex) {
        	Logger.getLogger(TicTacToeSocketServer.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
  private String recvRequest() {
        String msg = null;
        try {
        	if(player1){
        		msg = dis1.readUTF();
        	}else{
        		msg = dis2.readUTF();
        	}
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = msg.split(",");
        return command[0];
    }
	    
    private void sendResponse(String msg) {
	    try {
	    	if(player1){
	    		dos1.writeUTF(msg);
	    	}else{
	    		dos2.writeUTF(msg);
	    	}
	    } catch (IOException ex) {
	        Logger.getLogger(TicTacToeSocketServer.class.getName()).log(Level.SEVERE, null, ex);
	    }
    }
	
	private void open() {
        try {
            dis1 = new DataInputStream(c1.getInputStream());
            dos1 = new DataOutputStream(c1.getOutputStream());
            dos1.flush();
            dis2 = new DataInputStream(c2.getInputStream());
            dos2 = new DataOutputStream(c2.getOutputStream());
            dos2.flush();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TicTacToeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
