import javax.swing.*;
import java.awt.*;

public class Hole extends JLabel {
    private String innerText;
    private int ttl;

    public Hole() {
        super();
        setOpaque(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 30));
        setSize(420, 220);
        setIcon(new ImageIcon("res/hole.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(innerText, 170, 150);
    }

    public void setInnerText(String innerText) {
        this.innerText = innerText;
    }

}
