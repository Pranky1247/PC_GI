import java.awt.*;

public class BACK_0 extends Canvas {
    public void paint(Graphics g){
        Font F0 = new Font("Napoleon",Font.BOLD, 35);
        g.setFont(F0);
        g.setColor(Color.BLACK);
        g.drawString("GOT IT !!", 180, 125);
        Font F1 = new Font("Napoleon",Font.BOLD, 20);
        g.setFont(F1);
        g.drawString("GI_KEY", 95, 220);
        g.drawString("Pass", 100, 270);
    }
}
