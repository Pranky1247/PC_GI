import java.awt.*;

public class BACK_1 extends Canvas {
    @Override
    public void paint(Graphics g){
        Font F = new Font("Napoleon",Font.BOLD, 25);
        g.setFont(F);
        g.setColor(Color.PINK);
        g.drawString("Welcome to Got It world  ! ! ", 85, 50);
        g.drawString("Here, all lost items get back home  !", 20, 90);
        Font F1 = new Font("Napoleon",Font.BOLD, 35);
        g.setFont(F1);
        g.drawRect(27, 130, 450, 200);
        g.drawString("I WANT TO BECOME A", 50, 200);
    }
}
