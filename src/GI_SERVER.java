import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GI_SERVER {
    private final ServerSocket r0;
    public GI_SERVER(ServerSocket r0) throws IOException {
        this.r0 = r0;
        while(!r0.isClosed()){
            Socket s0 = r0.accept();
            new Thread(new User_House(s0)).start();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket r0 = new ServerSocket(7201);
        new GI_SERVER(r0);
    }
}
