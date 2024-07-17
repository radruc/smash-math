import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Game extends JFrame {

    static int totalScore = 0;
    static int totalTime = 60;
    static int timeLeft = totalTime;
    static Random rnd = new Random(System.currentTimeMillis());
    static Mouse[] mouses = new Mouse[9];

    Background background = new Background("background1");
    JPanel menubar = new JPanel();
    JButton menu = new JButton("MENU");
    JLabel time = new JLabel("Czas: " + timeLeft);
    JLabel score = new JLabel("Punkty: " + totalScore);
    JPanel contentPane = new JPanel();
    ImageIcon hole = new ImageIcon("res/hole.png");
    ImageIcon mouseOut = new ImageIcon("res/mouseout.png");
    private JPanel panel = new JPanel();
    private Hole[] holes = new Hole[9];
    JLayeredPane lp = new JLayeredPane();
    MenuStart menuStart = new MenuStart();
    GameMenu gameMenu = new GameMenu();
    GameOver gameOver = new GameOver();
    ScoreTable scoreTable = new ScoreTable();
    Panel cards = new Panel(new CardLayout());

    public Game() {

        ActionListener taskPerformer = evt -> {
            timeLeft--;
            time.setText("Czas: " + timeLeft);
            for (int i = 0; i < 9; i++) {
                if (mouses[i].getMouse() && mouses[i].ttl <= 0) {
                    boardUpdate();
                    contentPane.repaint();
                }
            }

            if (timeLeft == 0) {
                ((Timer) evt.getSource()).stop();
                gameOver.finalScore.setText("Twój wynik to: " + totalScore);
                setView("GAME OVER");
                gameOver.playerName.requestFocusInWindow();
            }
            if (mouses[0].getTTL() < 48) {
                score.setForeground(Color.BLACK);
            }
        };

        ActionListener scoreColor = evt -> {
            for (int i = 0; i < 9; i++) {
                mouses[i].ttl--;
            }
        };

        Timer t = new Timer(1000, taskPerformer);
        Timer t2 = new Timer(100, scoreColor);


        Font font = new Font("Arial", Font.PLAIN, 30);
        lp.setSize(1280, 768);
        background.setSize(1280, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("SmashMath");
        setSize(1280, 768);

        menubar.setMinimumSize(new Dimension(1280, 40));
        menubar.setPreferredSize(new Dimension(1280, 40));
        menubar.setMaximumSize(new Dimension(1280, 40));
        menubar.setLayout(new GridLayout(1, 3));
        menubar.setBackground(Color.WHITE);

        menu.setFont(font);
        menu.setVerticalTextPosition(SwingConstants.CENTER);
        menu.setBackground(Color.WHITE);
        menu.setFocusable(false);
        menu.setBorderPainted(false);

        menu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                menu.setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                menu.setBackground(Color.WHITE);
            }

            public void mouseClicked(MouseEvent evt) {
                setView("GAME MENU");
                t.stop();
            }
        });

        time.setFont(font);
        time.setForeground(Color.BLACK);
        score.setForeground(Color.BLACK);
        score.setFont(font);
        menubar.add(time);
        menubar.add(score);
        menubar.add(menu);
        menubar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        contentPane.setSize(1280, 768);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setOpaque(false);

        panel.setMinimumSize(new Dimension(1280, 660));
        panel.setMaximumSize(new Dimension(1280, 660));
        panel.setPreferredSize(new Dimension(1280, 660));
        panel.setLayout(new GridLayout(3, 3));
        panel.setOpaque(false);
        for (int i = 0; i < holes.length; i++) {
            holes[i] = new Hole();
            holes[i].setOpaque(false);
            holes[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    for (int i = 0; i < holes.length; i++) {
                        if (e.getSource() == holes[i]) {
                            if (mouses[i].getMouse()) {
                                if (mouses[i].getPoints() == 1) {
                                    totalScore += mouses[i].getPoints();
                                    totalScore += mouses[i].getTTL()/10;
                                    score.setText("Punkty: " + totalScore);
                                    score.setForeground(Color.GREEN);
                                } else {
                                    score.setForeground(Color.RED);
                                }
                            }
                        }
                    }
                    boardUpdate();
                    contentPane.repaint();
                }
            });
            panel.add(holes[i]);
        }

        contentPane.add(panel);
        contentPane.add(Box.createRigidArea(new Dimension(1280, 32)));
        contentPane.add(menubar);

        lp.add(background, 1);
        lp.add(contentPane, 0);
        add(menuStart);
        add(cards);

        cards.add(menuStart, "MENU");
        cards.add(lp, "MAIN");
        cards.add(gameMenu, "GAME MENU");
        cards.add(scoreTable, "SCORE TABLE");
        cards.add(gameOver, "GAME OVER");

        menuStart.start.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                resetGame();
                setView("MAIN");
                t.restart();
                t2.restart();
            }
        });
        menuStart.exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                System.exit(0);
            }
        });
        menuStart.scoreTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                scoreTable.updateTable();
                setView("SCORE TABLE");
            }
        });

        gameMenu.resume.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                setView("MAIN");
                t.start();
            }
        });

        gameMenu.restart.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                resetGame();
                t.restart();
                setView("MAIN");
            }
        });

        gameMenu.exit_menu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                setView("MENU");
            }
        });

        gameOver.restart.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                resetGame();
                t.restart();
                setView("MAIN");
            }
        });

        gameOver.mainMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                setView("MENU");
            }
        });
        gameOver.send.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                if (gameOver.playerName.getText().length() > 0) {
                    try {
                        String name = gameOver.playerName.getText();
                        String score = String.valueOf(totalScore);
                        String data = name + ";" + score + "\n";
                        Files.write(Paths.get("res/scores.txt"), data.getBytes(), StandardOpenOption.APPEND);
                        gameOver.playerName.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        scoreTable.exit_menu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c) {
                setView("MENU");
            }
        });


        initBoard();
        boardUpdate();
        contentPane.repaint();
    } // koniec konstruktora

    private void initBoard() {

        for (int i = 0; i < mouses.length; i++) {
            mouses[i] = new Mouse(false);
        }
        int m1 = randomNumber(mouses.length);
        int m2 = randomNumber(mouses.length);
        while (m1 == m2) {
            m2 = randomNumber(mouses.length);
        }
        mouses[m1].setMouse(true);
        mouses[m2].setMouse(true);
    }

    private void boardUpdate() {
        for (int i = 0; i < mouses.length; i++) {
            mouses[i].setMouse(false);
            holes[i].setInnerText("");
        }
        int m1 = randomNumber(mouses.length);
        int m2 = randomNumber(mouses.length);
        Operation o1 = new Operation();
        Operation o2 = new Operation();
        while (o1.getResult() == o2.getResult() || m1 == m2) {
            m2 = randomNumber(mouses.length);
            o1 = new Operation();
            o2 = new Operation();
        }

        mouses[m1].setMouse(true);
        mouses[m2].setMouse(true);
        holes[m1].setInnerText(o1.getOperation());
        holes[m2].setInnerText(o2.getOperation());

        if (o1.getResult() > o2.getResult()) {
            mouses[m1].setPoints(1);
            mouses[m2].setPoints(0);
        } else {
            mouses[m1].setPoints(0);
            mouses[m2].setPoints(1);
        }

        for (int i = 0; i < mouses.length; i++) {
            if (mouses[i].getMouse()) {
                holes[i].setIcon(mouseOut);
            } else {
                holes[i].setIcon(hole);
                holes[i].setInnerText("");
            }
        }

    }

    public static int randomNumber(int x) {
        int randomHole = rnd.nextInt(x);
        return randomHole;
    }

    public void setView(String view) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "" + view);
        cards.revalidate();
    }

    public void resetGame() {
        totalScore = 0;
        timeLeft = totalTime;
        score.setText("Punkty: " + totalScore);
        time.setText("Czas: " + totalTime);
    }

}// koniec klasy Game
