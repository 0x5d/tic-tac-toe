package client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class Application {

    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
    	String ip = "";
    	String port = "9998";
    	if(args.length >= 1){
    		port = args[0];
    	}
    	RestTemplate restTemplate = new RestTemplate();
    	try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
    	Match match = restTemplate.getForObject("http://127.0.0.1:8080/GameMatching?ip="+ip+"&port="+port, Match.class);
    	if(match==null){
        	/*
        	int serverPort = Integer.parseInt(port);
        	String serverIp = "127.0.0.1";
        	System.out.println("init");
        	TicTacToeLocalServer localServer = new TicTacToeLocalServer(serverPort);
        	localServer.start();
        	TicTacToeClient client = new TicTacToeClient(serverPort, serverIp);
        	*/
    		System.out.println("Priemro");
    	}else{
    		System.out.println("ip = "+match.getIp()+" port = "+match.getPort());
    	}
    	/*
    	int serverPort = 9998;
    	String serverIp = "127.0.0.1";
    	System.out.println("init");
    	TicTacToeLocalServer localServer = new TicTacToeLocalServer(serverPort);
    	localServer.start();
    	TicTacToeClient client = new TicTacToeClient(serverPort, serverIp);
    	*/
//        RestTemplate restTemplate = new RestTemplate();
//        Page page = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
//        System.out.println("Name:    " + page.getName());
//        System.out.println("About:   " + page.getAbout());
//        System.out.println("Phone:   " + page.getPhone());
//        System.out.println("Website: " + page.getWebsite());
    }

}