package game.main;

import game.characters.MPC;
import game.characters.Player;
import game.listeners.KeyListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Game extends JPanel {
    public static boolean isRunnning = true;
    public static final int WINDOW_WIDTH = 27;
    public static final int WINDOW_HEIGHT= 20;
    public static final int GRID_SCALE = 32;

    public static Player player;
    public static List<MPC> kids = new ArrayList<>();

    Game() {
        setWindowProperties();

        player = new Player(0, 0);
        addKeyListener(new KeyListener(player));

        for(int i = 0; i < 12; i++) {
            kids.add(new MPC((int)(Math.random()*WINDOW_WIDTH), (int)(Math.random()*WINDOW_HEIGHT)));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(MPC kid: kids) {
            if(kid.isAwake()) {
                g.setColor(Color.CYAN);
            }
            else {
                g.setColor(Color.LIGHT_GRAY);
            }
            if(kid.isSatisfied()) {
                g.setColor(Color.GREEN.brighter());
            }
            g.fillRect(kid.getPosX()*GRID_SCALE, kid.getPosY()*GRID_SCALE, GRID_SCALE, GRID_SCALE);
        }

        g.setColor(Color.BLACK);
        g.fillRect(player.getPosX()*GRID_SCALE, player.getPosY()*GRID_SCALE, GRID_SCALE, GRID_SCALE);
    }

    private void setWindowProperties() {
        setMaximumSize(new Dimension(WINDOW_WIDTH*GRID_SCALE, WINDOW_HEIGHT*GRID_SCALE));
        setMinimumSize(new Dimension(WINDOW_WIDTH*GRID_SCALE, WINDOW_HEIGHT*GRID_SCALE));
        setPreferredSize(new Dimension(WINDOW_WIDTH*GRID_SCALE, WINDOW_HEIGHT*GRID_SCALE));
        JFrame frame = new JFrame("Santa & Kids");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setFocusable(true);
    }
}