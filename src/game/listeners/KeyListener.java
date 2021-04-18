package game.listeners;

import game.characters.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private static final int MOVE_UP = 87;
    private static final int MOVE_RIGHT = 68;
    private static final int MOVE_DOWN = 83;
    private static final int MOVE_LEFT = 65;
    private static final int DROP_GIFT = 32;
    private Player player;

    public KeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()) {
            case MOVE_UP:
                player.moveUp();
                break;
            case MOVE_RIGHT:
                player.moveRight();
                break;
            case MOVE_DOWN:
                player.moveDown();
                break;
            case MOVE_LEFT:
                player.moveLeft();
                break;
            case DROP_GIFT:
                player.dropGift();
        }

    }
}
