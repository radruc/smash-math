import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import java.util.List;

class ScoreTable extends JPanel {
    Tlo background = new Tlo("background1");
    JLayeredPane game_menu = new JLayeredPane();
    JPanel table = new JPanel();
    JPanel arrays = new JPanel();
    MenuButton exit_menu = new MenuButton("POWRÓT");
    JLabel title = new JLabel("Najlepsze wyniki");
    JLabel[] score = new JLabel[20];
    List<Score> sl = new ArrayList<Score>();

    ScoreTable() {
        background.setSize(1280, 768);
        game_menu.setMinimumSize(new Dimension(1280, 768));
        game_menu.setMaximumSize(new Dimension(1280, 768));
        game_menu.setPreferredSize(new Dimension(1280, 768));

        title.setFont(new Font("Arial", Font.PLAIN, 60));
        title.setPreferredSize(new Dimension(1200, 80));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        table.add(Box.createRigidArea(new Dimension(0, 50)));
        table.add(title);
        table.add(Box.createRigidArea(new Dimension(0, 30)));


        arrays.setLayout(new GridLayout(10, 2));
        arrays.setMinimumSize(new Dimension(800, 450));
        arrays.setMaximumSize(new Dimension(800, 450));
        arrays.setPreferredSize(new Dimension(800, 450));

        for (int i = 0; i < 20; i++) {
            score[i] = new JLabel();
            score[i].setFont(new Font("Arial", Font.PLAIN, 30));
            score[i].setMinimumSize(new Dimension(350, 35));
            score[i].setMaximumSize(new Dimension(350, 35));
            score[i].setPreferredSize(new Dimension(350, 35));
            score[i].setForeground(new Color(224, 219, 209));
            score[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            score[i].setOpaque(false);
            arrays.add(score[i]);
        }

        arrays.setBorder(BorderFactory.createLineBorder(new Color(205, 133, 63), 5));
        arrays.setBackground(new Color(0, 75, 73));
        table.add(arrays);

        table.add(Box.createRigidArea(new Dimension(0, 30)));

        exit_menu.setPreferredSize(new Dimension(700, 50));
        table.add(exit_menu);

        table.setBounds(0, 0, 1280, 768);
        table.setLayout(new BoxLayout(table, BoxLayout.Y_AXIS));
        table.setOpaque(false);
        table.setAlignmentX(Component.CENTER_ALIGNMENT);

        exit_menu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                exit_menu.setForeground(new Color(224, 219, 209));
            }

            public void mouseExited(MouseEvent evt) {
                exit_menu.setForeground(Color.BLACK);
            }
        });

        game_menu.add(background, 1);
        game_menu.add(table, 0);
        add(game_menu);
    }

    public void updateTable() {
        Scanner read;
        try {
            read = new Scanner(new File("res/scores.txt"));
            read.useDelimiter(";");
            String line, name, sc;

            while (read.hasNextLine()) {
                line = read.nextLine();
                String[] parts = line.split(";");
                name = parts[0];
                sc = parts[1];
                sl.add(new Score(name, Integer.parseInt(sc)));
            }
            read.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(sl);
        Collections.reverse(sl);
        for (int i = 0; i < 20; i++) {
            int x = i / 2;
            if (i % 2 == 0) score[i].setText((x + 1) + ". " + sl.get(x).getPlayerName());
            else score[i].setText("" + sl.get(x).getScore());
        }
        sl.clear();
    }
}