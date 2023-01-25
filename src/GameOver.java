import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameOver extends JPanel {
    Tlo background = new Tlo("background1");
    JLayeredPane game_over = new JLayeredPane();
    JPanel sendScore = new JPanel();
    JPanel buttons = new JPanel();
    JPanel buttons2 = new JPanel();
    MenuButton restart = new MenuButton("NOWA GRA");
    MenuButton mainMenu = new MenuButton("MENU GŁÓWNE");
    JLabel title = new JLabel("KONIEC GRY! ");
    JLabel finalScore = new JLabel("Twój wynik to: ");
    JTextArea playerName = new JTextArea();
    MenuButton send = new MenuButton("Zapisz");

    GameOver() {
        background.setSize(1280, 768);
        game_over.setMinimumSize(new Dimension(1280, 768));
        game_over.setMaximumSize(new Dimension(1280, 768));
        game_over.setPreferredSize(new Dimension(1280, 768));
        sendScore.setBackground(Color.CYAN);

        title.setFont(new Font("Arial", Font.PLAIN, 60));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        finalScore.setFont(new Font("Arial", Font.PLAIN, 45));
        finalScore.setForeground(Color.BLACK);
        finalScore.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerName.setFont(new Font("Arial", Font.PLAIN, 45));
        playerName.setForeground(Color.BLACK);
        playerName.setAlignmentX(Component.TOP_ALIGNMENT);
        playerName.setMinimumSize(new Dimension(300, 55));
        playerName.setMaximumSize(new Dimension(300, 55));
        playerName.setPreferredSize(new Dimension(300, 55));

        send.setFont(new Font("Arial", Font.PLAIN, 30));
        send.setAlignmentX(Component.TOP_ALIGNMENT);
        send.setBorderPainted(true);
        send.setBackground(Color.WHITE);
        send.setOpaque(true);

        buttons.setMinimumSize(new Dimension(1280, 100));
        buttons.setMaximumSize(new Dimension(1280, 100));
        buttons.setPreferredSize(new Dimension(1280, 100));
        buttons.add(playerName);
        buttons.add(send);
        buttons.setOpaque(false);

        buttons2.setMinimumSize(new Dimension(1280, 100));
        buttons2.setMaximumSize(new Dimension(1280, 100));
        buttons2.setPreferredSize(new Dimension(1280, 100));
        buttons2.add(restart);
        buttons2.add(mainMenu);
        buttons2.setOpaque(false);

        restart.setPreferredSize(new Dimension(600, 55));
        restart.setMinimumSize(new Dimension(600, 55));
        restart.setMaximumSize(new Dimension(600, 55));
        restart.setVerticalTextPosition(SwingConstants.CENTER);

        mainMenu.setPreferredSize(new Dimension(600, 55));
        mainMenu.setMinimumSize(new Dimension(600, 55));
        mainMenu.setMaximumSize(new Dimension(600, 55));
        mainMenu.setVerticalTextPosition(SwingConstants.CENTER);

        restart.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                restart.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                restart.setForeground(Color.BLACK);
            }
        });

        mainMenu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                mainMenu.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                mainMenu.setForeground(Color.BLACK);
            }
        });

        sendScore.add(Box.createRigidArea(new Dimension(0, 90)));
        sendScore.add(title);
        sendScore.add(Box.createRigidArea(new Dimension(0, 50)));
        sendScore.add(finalScore, BorderLayout.CENTER);
        sendScore.add(Box.createRigidArea(new Dimension(0, 40)));
        sendScore.add(buttons, BorderLayout.CENTER);
        sendScore.add(Box.createRigidArea(new Dimension(0, 60)));
        sendScore.add(buttons2, BorderLayout.SOUTH);

        sendScore.setBounds(0, 0, 1280, 768);
        sendScore.setLayout(new BoxLayout(sendScore, BoxLayout.Y_AXIS));
        sendScore.setOpaque(false);
        sendScore.setAlignmentX(Component.RIGHT_ALIGNMENT);

        game_over.add(background, 1);
        game_over.add(sendScore, 0);
        add(game_over);
    }

}