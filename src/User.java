import java.net.Socket;

public class User {
    private final String ID;
    private final String PASS;
    private final boolean Driver;
    private final Socket s0;
    public User(String x, String y, boolean z, Socket s0){
        this.ID = x;
        this.PASS = y;
        this.Driver = z;
        this.s0 = s0;
    }
    public boolean isDriver(){
        return this.Driver;
    }
    public String getID(){
        return this.ID;
    }
    public String getPASS(){
        return this.PASS;
    }
}
