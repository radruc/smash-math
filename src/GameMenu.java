import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameMenu extends JPanel {
    Tlo background = new Tlo("background1");
    JLayeredPane game_menu = new JLayeredPane();
    JPanel buttons = new JPanel();
    MenuButton resume = new MenuButton("WZNÓW  GRĘ");
    MenuButton restart = new MenuButton("NOWA GRA");
    MenuButton exit_menu = new MenuButton("WYJŚCIE");
    JLabel title = new JLabel("SmashMath");

    GameMenu() {
        background.setSize(1280, 768);
        game_menu.setMinimumSize(new Dimension(1280, 768));
        game_menu.setMaximumSize(new Dimension(1280, 768));
        game_menu.setPreferredSize(new Dimension(1280, 768));

        title.setFont(new Font("Arial", Font.PLAIN, 60));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        resume.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                resume.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                resume.setForeground(Color.BLACK);
            }
        });

        restart.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                restart.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                restart.setForeground(Color.BLACK);
            }
        });

        exit_menu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                exit_menu.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                exit_menu.setForeground(Color.BLACK);
            }
        });

        buttons.add(Box.createRigidArea(new Dimension(0, 90)));
        buttons.add(title);
        buttons.add(Box.createRigidArea(new Dimension(0, 100)));
        buttons.add(resume, BorderLayout.CENTER);
        buttons.add(Box.createRigidArea(new Dimension(0, 40)));
        buttons.add(restart, BorderLayout.CENTER);
        buttons.add(Box.createRigidArea(new Dimension(0, 40)));
        buttons.add(exit_menu, BorderLayout.CENTER);

        buttons.setBounds(0, 0, 1280, 768);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setOpaque(false);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        game_menu.add(background, 1);
        game_menu.add(buttons, 0);
        add(game_menu);
    }

}