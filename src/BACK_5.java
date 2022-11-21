import java.awt.*;

public class BACK_5 extends Canvas {
    @Override
    public void paint(Graphics g){
        g.setFont(new Font("Napoleon", Font.BOLD, 15));
        g.setColor(Color.BLACK);
        g.drawString("INFO length can not be less than 8.", 20, 40);
    }
}
