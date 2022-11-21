import java.awt.*;

public class BACK_3 extends Canvas {
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Napoleon", Font.BOLD, 30));
        g.drawString("Server IP Address", 110, 100);
        g.drawRect(70, 60, 350, 270);
        g.drawString("Port Number", 150, 190);
    }
}
