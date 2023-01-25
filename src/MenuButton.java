import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(String text) {
        super(text);
        setOpaque(false);
        setFocusable(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("Impact", Font.PLAIN, 40));
        setPreferredSize(new Dimension(150, 55));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setForeground(Color.BLACK);
    }
}

