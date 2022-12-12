import javax.swing.*;
import java.awt.*;
public class MenuStart {
    Tlo background = new Tlo();
    JFrame menu_start = new JFrame();
    JPanel przyciski = new JPanel();
    JButton start = new JButton("START");
    JButton tabwynikow = new JButton("TABLICA WYNIKÓW");
    JButton wyjscie = new JButton("WYJŚCIE");
    JLabel tytul = new JLabel("   SmashMath");

    MenuStart() {
        Font font = new Font ("Arial",Font.PLAIN,40);
        background.setSize(1280,768);
        menu_start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu_start.setResizable(false);
        menu_start.setTitle("SmashMath");
        menu_start.setSize(1280, 768);

        menu_start.add(background);
        tytul.setFont(new Font ("Arial",Font.PLAIN,60));


        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setFont(font);
        start.setSize(start.getWidth(), 70);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setForeground(Color.BLACK);
        tabwynikow.setForeground(Color.BLACK);
        wyjscie.setForeground(Color.BLACK);
        tytul.setForeground(Color.BLACK);
        tytul.setAlignmentX(Component.CENTER_ALIGNMENT);

        tabwynikow.setOpaque(false);
        tabwynikow.setContentAreaFilled(false);
        tabwynikow.setBorderPainted(false);
        tabwynikow.setFont(font);
        tabwynikow.setSize(tabwynikow.getWidth(), 70);
        tabwynikow.setAlignmentX(Component.CENTER_ALIGNMENT);

        wyjscie.setOpaque(false);
        wyjscie.setContentAreaFilled(false);
        wyjscie.setBorderPainted(false);
        wyjscie.setFont(font);
        wyjscie.setSize(wyjscie.getWidth(), 70);
        wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);

        przyciski.add(Box.createRigidArea(new Dimension(0, 30)));
        przyciski.add(tytul);
        przyciski.add(Box.createRigidArea(new Dimension(0, 100)));
        przyciski.add(start,BorderLayout.CENTER);
        przyciski.add(tabwynikow,BorderLayout.CENTER);
        przyciski.add(wyjscie,BorderLayout.CENTER);

        przyciski.setLayout(new GridLayout(6,1));
        przyciski.setOpaque(false);
        background.add(przyciski, BorderLayout.CENTER);
        menu_start.setVisible(true);
        background.repaint();
    }
}
