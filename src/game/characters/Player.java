package game.characters;

import game.main.Game;

public class Player {
    private int posX;
    private int posY;

    public Player(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private boolean isKidNear(MPC kid) {
        int distanceX = Math.abs(posX - kid.getPosX());
        int distanceY = Math.abs(posY - kid.getPosY());
        return distanceX <= 1 && distanceY <= 1;
    }

    public void moveUp() {
        posY --;
        if(posY < 0) posY = Game.WINDOW_HEIGHT-1;
    }

    public void moveRight() {
        posX ++;
        if(posX+1 > Game.WINDOW_WIDTH) posX = 0;
    }

    public void moveDown() {
        posY ++;
        if(posY >= Game.WINDOW_HEIGHT) posY = 0;
    }

    public void moveLeft() {
        posX --;
        if(posX < 0) posX = Game.WINDOW_WIDTH - 1;
    }

    public void dropGift() {
        for(MPC kid : Game.kids) {
            if(isKidNear(kid)) {
                if(posX < kid.getPosX()) {
                    kid.giftDirection = kid.LEFT;
                }
                else if(posX > kid.getPosX()) {
                    kid.giftDirection = kid.RIGHT;
                }
                else if(posY < kid.getPosY()) {
                    kid.giftDirection = kid.UP;
                }
                else if(posY > kid.getPosY()) {
                    kid.giftDirection = kid.DOWN;
                }
                break;
            }
        }
    }
}
