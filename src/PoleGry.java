import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PoleGry {
    Tlo background = new Tlo();
    JFrame pole_gry = new JFrame();
    ImageIcon hole = new ImageIcon("res/hole.png");
    ImageIcon mysz = new ImageIcon("res/mouse.png");
    JLayeredPane lp = new JLayeredPane();
    JPanel holes = new JPanel();
    JPanel myszy = new JPanel();
    JPanel pasek = new JPanel();
    JPanel pasek2 = new JPanel();
    JLabel h1 = new JLabel(hole);
    JLabel h2 = new JLabel(hole);
    JLabel h3 = new JLabel(hole);
    JLabel h4 = new JLabel(hole);
    JLabel h5 = new JLabel(hole);

    JLabel m1 = new JLabel(mysz);
    JLabel m2 = new JLabel(mysz);
    JButton menu = new JButton("MENU");

    PoleGry(){
        Font font = new Font ("Arial",Font.PLAIN,40);
        background.setSize(1280,768);
        pole_gry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pole_gry.setResizable(false);
        pole_gry.setTitle("SmashMath");
        pole_gry.setSize(1280, 768);
        lp.setSize(1280,600);
        holes.setSize(1280,600);
        myszy.setSize(1280,600);
        pasek.setSize(1280,250);
        pasek.setLayout(new GridLayout(1,3));
        holes.setLayout(new GridLayout(6,3));
        myszy.setLayout(new GridLayout(2,3));

        h1.setPreferredSize(new Dimension(300,50));
        h2.setPreferredSize(new Dimension(300,50));
        h3.setPreferredSize(new Dimension(300,50));
        h4.setPreferredSize(new Dimension(300,50));
        h5.setPreferredSize(new Dimension(300,50));

        m1.setPreferredSize(new Dimension(200,200));
        m2.setPreferredSize(new Dimension(200,200));
        m1.setBorder(BorderFactory.createEmptyBorder());
        m2.setBorder(BorderFactory.createEmptyBorder());

        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(h1);
        holes.add(new JLabel());
        holes.add(h2);
        holes.add(new JLabel());
        holes.add(h3);
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(new JLabel());
        holes.add(h4);
        holes.add(new JLabel());
        holes.add(h5);
        holes.setOpaque(false);

        myszy.add(m1);
        myszy.add(new JLabel());
        myszy.add(m2);
        myszy.add(new JLabel());
        myszy.add(new JLabel());
        myszy.add(new JLabel());
        myszy.setOpaque(false);

        lp.add(holes,1);
        lp.add(myszy,0);
        pasek.add(new JLabel("Punkty: XX"));
        pasek.add(new JLabel("Czas: XXX s"));
        menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        pasek.add(menu);
        lp.setOpaque(false);
        pole_gry.add(lp);
        pole_gry.add(pasek, BorderLayout.SOUTH);
        pole_gry.add(background);
        pole_gry.setVisible(true);



    }
}

