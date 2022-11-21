import java.awt.*;

public class BACK_4 extends Canvas {
    @Override
    public void paint(Graphics g){
        g.setFont(new Font("Napoleon", Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString("Invalid Info.", 40, 60);
    }
}
