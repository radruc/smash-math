import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MenuStart extends JPanel {
    Tlo background = new Tlo("background");
    JLayeredPane menu_start = new JLayeredPane();
    JPanel buttons = new JPanel();
    MenuButton start = new MenuButton("START");
    MenuButton scoreTable = new MenuButton("TABLICA WYNIKÓW");
    MenuButton exit = new MenuButton("WYJŚCIE");
    JLabel title = new JLabel("Smash Math");

    MenuStart() {
        background.setSize(1280, 728);
        menu_start.setMinimumSize(new Dimension(1280, 768));
        menu_start.setMaximumSize(new Dimension(1280, 768));
        menu_start.setPreferredSize(new Dimension(1280, 768));

        title.setFont(new Font("Ink Free", Font.BOLD, 80));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        start.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                start.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                start.setForeground(Color.BLACK);
            }
        });
        scoreTable.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                scoreTable.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                scoreTable.setForeground(Color.BLACK);
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                exit.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                exit.setForeground(Color.BLACK);
            }
        });

        buttons.add(Box.createRigidArea(new Dimension(0, 50)));
        buttons.add(title);
        buttons.add(Box.createRigidArea(new Dimension(0, 175)));
        buttons.add(start, BorderLayout.CENTER);
        buttons.add(Box.createRigidArea(new Dimension(0, 40)));
        buttons.add(scoreTable, BorderLayout.CENTER);
        buttons.add(Box.createRigidArea(new Dimension(0, 40)));
        buttons.add(exit, BorderLayout.CENTER);

        buttons.setBounds(0, 0, 1280, 768);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setOpaque(false);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu_start.add(background, 1);
        menu_start.add(buttons, 0);
        add(menu_start);
    }

}
