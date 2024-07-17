import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Tlo extends JPanel {
    private BufferedImage tlo;

    public Tlo(String bgname) {

        try {
            tlo = ImageIO.read(new File("res/" + bgname + ".jpg"));
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
