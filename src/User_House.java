import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class User_House implements Runnable{
    private final Socket s0;
    private final BufferedWriter bw0;
    private final BufferedReader br0;
    private static ArrayList<User> l0 = new ArrayList<User>();
    private static ArrayList<String> l1 = new ArrayList<String>();
    public User_House(Socket s0) throws IOException {
        for(String i: l1){
            System.out.println(i);
        }
        this.bw0 = new BufferedWriter(new OutputStreamWriter(s0.getOutputStream()));
        this.br0 = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        this.s0 = s0;
    }
    @Override
    public void run() {
        try {
            bw0.write("GOOD_7201.");
            bw0.newLine();
            bw0.flush();
            while(s0.isConnected()){
                Listen();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void Listen() throws IOException{
        String m0 = this.br0.readLine();
        String p0 = m0.substring(0, 3);

        if(p0.equals("LOG")){
            String info = m0.substring(4);
            for(String i : l1){
                if(i.equals(info)){
                    for(User p: l0){
                        if(p.getID().equals(m0.substring(4).split(",")[0])){
                            if(p.isDriver()){
                                this.bw0.write("LOG_1_D");
                                this.bw0.newLine();
                                this.bw0.flush();
                                return;
                            }else{
                                this.bw0.write("LOG_1_U");
                                this.bw0.newLine();
                                this.bw0.flush();
                                return;
                            }
                        }
                    }
                }
            }
            this.bw0.write("LOG_0");
            this.bw0.newLine();
            this.bw0.flush();
            // m0 = "LOG_Pranky1247,Pranky7421."
            // m0 = "SGU_Pranky1247,Pranky7421."
            // m0 = "SGD_Pranky1247,Pranky7421."
        }else if(p0.equals("SGU")){
            String info = m0.substring(4);
            l1.add(info);
            String[] l2 = info.split(",");
            User u = new User(l2[0],l2[1],false,this.s0);
            l0.add(u);
            System.out.println("A user is successfully added.");
        }
    }


}
