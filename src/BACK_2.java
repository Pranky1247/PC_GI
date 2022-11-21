import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class BACK_2 extends Canvas {
    private final JLayeredPane P;
    private final TextField T;
    private final JPasswordField T0;
    public final JButton Submit;
    private final BufferedWriter bw0;
    private final Socket s0;
    private final JFrame frame;
    public BACK_2(JLayeredPane P, BufferedWriter bw0, Socket s0, JFrame frame){
        this.frame = frame;
        this.s0 = s0;
        this.bw0 = bw0;
        this.Submit = new JButton("Submit");
        Submit.setBounds(230, 300, 100, 50);
        Submit.setOpaque(true);
        Submit.setBackground(Color.BLACK);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder pass = new StringBuilder();
                for(char i: T0.getPassword()){
                    pass.append(i);
                }
                String ID = T.getText();
                if(ID.length() < 5 || pass.length() < 5){
                    JFrame k0 = new JFrame("Error_01");
                    JButton b0 = new JButton("OK");
                    b0.setBounds(125, 70, 60, 30);
                    b0.setOpaque(true);
                    b0.setBackground(Color.WHITE);
                    BACK_5 BG = new BACK_5();
                    BG.setBounds(0, 0, 300, 170);
                    JLayeredPane m0 = new JLayeredPane();
                    k0.setSize(300, 170);
                    m0.setBounds(0, 0, 300, 170);
                    m0.add(b0,Integer.valueOf(0));
                    m0.add(BG, Integer.valueOf(0));
                    BG.setBackground(Color.WHITE);
                    k0.add(m0);
                    k0.setLocationRelativeTo(null);
                    b0.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            T.setText("");
                            T0.setText("");
                            k0.setVisible(false);
                        }
                    });
                    k0.setVisible(true);
                }
                try {
                    bw0.write("SGU_" + ID + "," + pass);
                    bw0.newLine();
                    bw0.flush();
                    frame.setVisible(false);
                    new LOG_WINDOW(s0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.P = P;
        this.T = new TextField();
        T.setBackground(Color.WHITE);
        T.setForeground(Color.BLACK);
        T.setBounds(190, 105, 200, 35);
        this.T0 = new JPasswordField();
        T0.setOpaque(true);
        T0.setBackground(Color.WHITE);
        T0.setForeground(Color.BLACK);
        T0.setBounds(190, 200, 200, 35);
        this.P.add(this.T, Integer.valueOf(0));
        this.P.add(this.T0, Integer.valueOf(0));
        this.P.add(this.Submit, Integer.valueOf(0));
    }
    @Override
    public void paint(Graphics g){
       g.setColor(Color.PINK);
       Font F0 = new Font("Napoleon",Font.BOLD, 25);
       g.setFont(F0);
       g.drawRect(25, 35, 450, 400);
       g.drawString("GI_KEY : ", 70, 130);
       g.drawString("Password :", 40, 225);
    }
    public void error_m(Graphics g){
        g.setColor(Color.PINK);
        Font F0 = new Font("Napoleon",Font.BOLD, 15);
        g.setFont(F0);
        g.drawString("KEY length can not be less than 5 charaters.", 40, 40);
    }
}
