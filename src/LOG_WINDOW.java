import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class LOG_WINDOW extends JFrame implements ActionListener {
    private final JButton LOG_B;
    private final JButton SIGN_B;
    private final JButton Driver_B;
    private final JButton User_B;
    private final JLayeredPane LP;
    private final BACK_0 BG;
    private final TextField ID_T;
    private final JPasswordField PASS_T;
    private final Socket s0;
    private final BufferedWriter bw0;
    private final BufferedReader br0;

    public LOG_WINDOW(Socket s0) throws IOException {
        this.s0 = s0;
        this.bw0 = new BufferedWriter(new OutputStreamWriter(this.s0.getOutputStream()));
        this.br0 = new BufferedReader(new InputStreamReader(this.s0.getInputStream()));
        this.Driver_B = new JButton("Driver.");
        Driver_B.addActionListener(this);
        this.User_B = new JButton("User.");
        User_B.addActionListener(this);
        this.ID_T = new TextField();
        this.PASS_T = new JPasswordField();
        ID_T.setBounds(175,200,250,30);
        ID_T.setBackground(Color.BLACK);
        ID_T.setForeground(Color.WHITE);
        PASS_T.setBounds(175,250,250, 30);
        PASS_T.setOpaque(true);
        PASS_T.setBackground(Color.BLACK);
        PASS_T.setForeground(Color.WHITE);
        this.setSize(500, 500);
        this.BG = new BACK_0();
        this.LP = new JLayeredPane();
        this.LP.setBounds(0, 0, 500, 500);
        this.LP.setBackground(Color.pink);
//        this.LP.setBackground(Color.BLACK);
        this.BG.setBounds(0, 0, 500, 500);
        this.LOG_B = new JButton("LOG IN");
        LOG_B.addActionListener(this);
        LOG_B.setOpaque(true);
        LOG_B.setBackground(Color.PINK);
        LOG_B.setBounds(300, 350, 100, 50);
        this.SIGN_B = new JButton("SIGN UP");
        this.SIGN_B.addActionListener(this);
        SIGN_B.setOpaque(true);
        SIGN_B.setBackground(Color.PINK);
        SIGN_B.setBounds(150, 350, 100, 50);
        LP.add(ID_T, Integer.valueOf(0));
        LP.add(PASS_T, Integer.valueOf(0));
        LP.add(LOG_B, Integer.valueOf(0));
        LP.add(SIGN_B, Integer.valueOf(0));
        LP.add(BG, Integer.valueOf(0));
        this.add(LP);
        this.setTitle("LOG_WINDOW");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void C0(){
        this.LP.removeAll();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.SIGN_B){
                C0();
                BACK_1 B0 = new BACK_1();
                B0.setBounds(0 ,0, 500, 500);
                B0.setBackground(Color.BLACK);
                this.Driver_B.setBounds(280, 250, 100, 50);
                this.Driver_B.setOpaque(true);
                this.Driver_B.setBackground(Color.BLACK);
                this.User_B.setBounds(130,250, 100, 50);
                this.User_B.setOpaque(true);
                this.User_B.setBackground(Color.BLACK);
                this.LP.add(Driver_B, Integer.valueOf(0));
                this.LP.add(User_B, Integer.valueOf(0));
                this.LP.add(B0, Integer.valueOf(0));
        }else if (e.getSource() == this.User_B){
            C0();
            BACK_2 B2 = new BACK_2(this.LP, this.bw0, this.s0, this);
            B2.setBounds(0, 0, 500, 500);
            B2.setBackground(Color.BLACK);
            this.LP.add(B2,Integer.valueOf(0));
        } else if (e.getSource() == this.LOG_B){
            StringBuilder pass = new StringBuilder();
            for(char i: this.PASS_T.getPassword()){
                pass.append(i);
            }
            String info = "LOG_" + this.ID_T.getText() + "," + pass;
            try {
                this.bw0.write(info);
                this.bw0.newLine();
                this.bw0.flush();
                String h = br0.readLine();
                if (h.equals("LOG_0")){
                    JFrame J0 = new JFrame("Error_01");
                    JButton B0 = new JButton("OK");
                    JLayeredPane P0 = new JLayeredPane();
                    P0.setBounds(0, 0, 250, 180);
                    B0.setBounds(95, 80, 70, 45);
                    B0.setOpaque(true);
                    B0.setBackground(Color.WHITE);
                    J0.setLocation(750, 470);
                    J0.setResizable(false);
                    J0.setSize(250, 180);
                    BACK_4 C0 = new BACK_4();
                    P0.add(B0, Integer.valueOf(0));
                    P0.add(C0, Integer.valueOf(0));
                    P0.setBackground(Color.WHITE);
                    C0.setBounds(0, 0, 250, 180);
                    B0.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            J0.setVisible(false);
                            ID_T.setText("");
                            PASS_T.setText("");
                        }
                    });
                    J0.add(P0);
                    J0.setVisible(true);
                }else if(h.equals("LOG_1_U")){
                    this.setVisible(false);
                    new GI_WINDOW_U();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else if(e.getSource() == this.Driver_B){
            C0();
            BACK_6 BG_6 = new BACK_6();
            BG_6.setBounds(0, 0, 500, 500);
            BG_6.setBackground(Color.BLACK);
            this.LP.add(BG_6, Integer.valueOf(0));
        }
    }

}
