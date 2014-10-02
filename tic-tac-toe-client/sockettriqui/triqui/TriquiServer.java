package triqui;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriquiServer {

    ServerSocket ss = null;
    Socket c = null;
    int port = 0;

    public TriquiServer() {
        init(5555);
    }

    public TriquiServer(int port) {
        init(port);
    }

    private void init(int port) {
        try {
            this.port = port;
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(TriquiServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        TriquiSocketServer tss = null;
        System.out.println("TriquiServer.run().listening..." + port);
        while (true) {
            try {
                c = ss.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            tss = new TriquiSocketServer(c);
            tss.run();
        }
    }

//    public static void main(String[] args) {
//        TriquiServer ts = null;
//        if (args.length < 1)
//            ts = new TriquiServer();
//        else
//            ts = new TriquiServer(Integer.parseInt(args[0]));
//        ts.run();
//    }
}