package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TicTacToePlayerSocket {
	TicTacToeClient triqui = null;
    
    public TicTacToePlayerSocket(String host, int port) {
        triqui = new TicTacToeClient(port,host);
    }
    
    private String keyboard() {
        String cadena = null;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            cadena = br.readLine();
        } catch (IOException ex) {
            //Logger.getLogger(TriquiPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    private void play(boolean main) {
    	if(main){
    		triqui.send("START,");
    	}
        String winner = "N";
        int contplay = 0;
        int valid = 0;
        String player = null;
        String board = null;

        while (winner.equals("N") && contplay < 5) {
            
            //triqui.send("PLAYER,");
            //player = triqui.recv();
            
            
            triqui.send("BOARD,");
            board = triqui.recv();
            

            System.out.println("\nSU TURNO: ");
            System.out.println(board);
            do {
            	triqui.send("CANPLAY");
            	boolean b = Boolean.parseBoolean(triqui.recv());
            	if(!b){
            		break;
            	}
                System.out.print("Posicion = ");
                String pos = keyboard();
                
                //valid = triqui.play(Integer.parseInt(pos)-1); // Standalone
                
                // comunicacion socket - inicio
                
                triqui.send("PLAY,"+pos);
                //valid = Boolean.parseBoolean(triqui.recv());
                valid = Integer.parseInt(triqui.recv());
                // comunicacion socket - fin
                if (valid==0){
                    System.out.println(">>> Jugada invalida");
                 }else if(valid == 2){
                	 break;
                 }
            } while (valid==0);
            if(valid==2){
            	System.out.println("break");
            	break;
            }
            triqui.send("BOARD");
            board = triqui.recv();
            System.out.println(board);
            triqui.send("TESTWINNER,");
            winner = triqui.recv();
            if(winner.equals("N")){
            	System.out.println("esperando jugada");
            }
            contplay++;
        }
        
        triqui.send("BOARD,");
        board = triqui.recv();
        
        System.out.println(board);
        System.out.println("Ganador: " + winner);
        triqui.send("YIELD");

    }
    
    public void run(boolean main) {
        //String input = "y";
        //while (input.equals("y")) {
        play(main);
          //  System.out.print("Continuar? (y/n) = ");
         //   input = keyboard();
        //}
    }
        
}
