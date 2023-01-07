import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Gra extends JFrame {
    static Mouse [] mouses = new Mouse[9];
    static int totalScore = 0;
    static int totalTime = 120;
    static long start = System.currentTimeMillis();
    Tlo background = new Tlo();
    JPanel menubar = new JPanel();
    JButton menu = new JButton("MENU");
    JLabel time = new JLabel("Czas: " + totalTime);
    JLabel score = new JLabel("Punkty: " + totalScore);
    JPanel contentPane = new JPanel();
    ImageIcon hole = new ImageIcon("res/hole.png");
    ImageIcon mouseOut = new ImageIcon("res/mouseout.png");
    private JPanel panel = new JPanel();
    private JLabel[] holes = new JLabel[9];
    JLayeredPane lp = new JLayeredPane();
   public Gra(){

        Font font = new Font ("Arial",Font.PLAIN,30);
        lp.setSize(1280,768);
        background.setSize(1280,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("SmashMath");
        setSize(1280, 768);

        menubar.setMinimumSize(new Dimension(1280, 40));
        menubar.setPreferredSize(new Dimension(1280, 40));
        menubar.setMaximumSize(new Dimension(1280, 40));
        menubar.setLayout(new GridLayout(1,3));
        menubar.setBackground(Color.WHITE);

        menu.setFont(font);
        menu.setVerticalTextPosition(SwingConstants.CENTER);
        menu.setBackground(Color.WHITE);
        menu.setFocusable(false);
        menu.setBorderPainted(false);

        menu.addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent evt) {
               menu.setBackground(Color.GREEN);
           }
           public void mouseExited(MouseEvent evt) {
               menu.setBackground(Color.WHITE);
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

        contentPane.setSize(1280,768);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setOpaque(false);

        panel.setMinimumSize(new Dimension(1280, 660));
        panel.setMaximumSize(new Dimension(1280, 660));
        panel.setPreferredSize(new Dimension(1280, 660));
        panel.setLayout(new GridLayout(3,3));
        panel.setOpaque(false);
        for (int i = 0; i < holes.length; i++) {
            holes[i] = new JLabel(hole);
            holes[i].setSize(420,220);
            holes[i].setOpaque(false);
            holes[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    boardUpdate();
                }});
            panel.add(holes[i]);
        }

        contentPane.add(panel);
        contentPane.add(Box.createRigidArea(new Dimension(1280, 32)));
        contentPane.add(menubar);

        lp.add(background,1);
        lp.add(contentPane,0);
        setContentPane(lp);

       Dzialanie [] dzialania = new Dzialanie[100];
       for(int i=0;i< dzialania.length;i++){
           dzialania[i] = new Dzialanie();
       }

       initBoard();
       drawBoard();
    } // koniec konstruktora
    private void initBoard() {

        for (int i = 0; i < mouses.length; i++) {
            mouses[i] = new Mouse(false);
        }
        int m1 = randomNumber();
        int m2 = randomNumber();
        while (m1 == m2) {
            m2 = randomNumber();
        }
        mouses[m1].setMouse(true);
        mouses[m2].setMouse(true);
    }
    private void boardUpdate() {
        initBoard();
        drawBoard();
        }

    private void drawBoard() {
       for (int i = 0; i < mouses.length; i++) {
            if(mouses[i].getMouse()){
                holes[i].setIcon(mouseOut);
            }
            else {
                holes[i].setIcon(hole);
            }
        }

    }
    public static int randomNumber() {
        Random rnd = new Random();
        int randomHole = rnd.nextInt(9);
        return randomHole;
    }

}// koniec klasy Gra