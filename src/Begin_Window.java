import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Begin_Window extends JFrame implements ActionListener {
    private final BACK_3 BG;
    private final JLayeredPane LP;
    private final TextField T0;
    private final TextField T1;
    private final JButton Button_0;
//    private final Socket s0;
    public Begin_Window(){
        this.Button_0 = new JButton("Submit");
        Button_0.setBounds(170, 270, 160, 40);
        Button_0.setOpaque(true);
        Button_0.setBackground(Color.BLACK);
        Button_0.addActionListener(this);
        this.T0 = new TextField();
        T0.setBounds(150, 120, 200, 25);
        T0.setBackground(Color.WHITE);
        this.T1 = new TextField();
        T1.setBounds(150, 210, 200, 25);
        T1.setBackground(Color.WHITE);
        this.LP = new JLayeredPane();
        LP.setBounds(0, 0 , 500, 500);
        this.BG = new BACK_3();
        BG.setBounds(0, 0, 500, 500);
        BG.setBackground(Color.BLACK);
        LP.add(Button_0, Integer.valueOf(0));
        LP.add(T0, Integer.valueOf(0));
        LP.add(T1, Integer.valueOf(0));
        LP.add(BG, Integer.valueOf(0));
        this.add(LP);
        this.setLocation(700,300);
        this.setVisible(true);
        this.setSize(500, 500);
    }

    public static void main(String[] args) {
        new Begin_Window();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.Button_0){
            String IP = this.T0.getText();
            int Port = Integer.parseInt(this.T1.getText());
            // 192.168.0.67
            try {
                Socket s0 = new Socket(IP, Port);
                BufferedReader br0 = new BufferedReader(new InputStreamReader(s0.getInputStream()));
                if(br0.readLine().equals("GOOD_7201.")){
                    this.setVisible(false);
                    new LOG_WINDOW(s0);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
