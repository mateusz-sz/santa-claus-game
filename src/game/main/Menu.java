package game.main;

import javax.swing.*;
import java.awt.*;

import static game.main.Game.WINDOW_HEIGHT;
import static game.main.Game.WINDOW_WIDTH;
import static game.main.Game.GRID_SCALE;

public class Menu extends JPanel {
    public Menu() {
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
