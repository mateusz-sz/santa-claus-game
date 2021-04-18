package game.main;

import game.characters.MPC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    private Game game;

    private Main() {
        game = new Game();
        Timer timer = new Timer(1000 / 60, this);
        timer.start();

        Timer kidsTimer = new Timer(1000, actionEvent -> {
            for(MPC kid: Game.kids) {
                if(!kid.isSatisfied()) {
                    kid.move();
                }
            }
        });
        kidsTimer.start();
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        game.repaint();
    }
}
