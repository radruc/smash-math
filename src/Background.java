import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Background extends JPanel {
    private BufferedImage tlo;

    public Background(String bgname) {

        try {
            background = ImageIO.read(new File("res/" + bgname + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawImage(tlo, 0, 0, getWidth(), getHeight(), this);
    }
}
