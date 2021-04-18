package game.characters;

import game.main.Game;

public class MPC {
    final int UP = 0;
    final int RIGHT = 1;
    final int DOWN = 2;
    final int LEFT = 3;

    private int posX;
    private int posY;
    private int stepCounter = 0;
    private int sleepTime = 0;
    private boolean isAwake = true;
    private boolean isSatisfied = false;
    public int giftDirection = -1;

    private Player player = Game.player;

    public MPC(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isAwake() {
        return isAwake;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private boolean isPlayerInDistance(int distance) {
        int distanceX = Math.abs(player.getPosX() - posX);
        int distanceY = Math.abs(player.getPosY() - posY);

        return distanceX <= distance && distanceY <= distance;
    }

    private void moveUp() {
        posY --;
        if(posY < 0) posY = Game.WINDOW_HEIGHT-1;
    }

    private void moveRight() {
        posX ++;
        if(posX+1 > Game.WINDOW_WIDTH) posX = 0;
    }

    private void moveDown() {
        posY ++;
        if(posY >= Game.WINDOW_HEIGHT) posY = 0;
    }

    private void moveLeft() {
        posX --;
        if(posX < 0) posX = Game.WINDOW_WIDTH - 1;
    }

    public void move() {
        if(isAwake){
            int direction;

            if(giftDirection != -1) {
                direction = giftDirection;
                isSatisfied = true;
            }
            else if(isPlayerInDistance(5)) {
                if(player.getPosX() > posX) {
                    direction = RIGHT;
                }
                else if(player.getPosX() < posX) {
                    direction = LEFT;
                }
                else if(player.getPosY() < posY) {
                    direction = UP;
                }
                else {
                    direction = DOWN;
                }
            }
            else {
                direction = (int)(Math.random() * 4);
            }

            switch (direction) {
                case UP:
                    moveUp();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
            }
            stepCounter++;

            if(isPlayerInDistance(0)) {
                Game.isRunnning = false;
            }

            if(stepCounter > Math.random()*14+2) {
                isAwake = false;
                sleepTime = (int) (Math.random() * 4) + 2;
                stepCounter = 0;
            }
        }
        else {
            sleepTime--;
            if(sleepTime < 0) {
                isAwake = true;
            }
        }
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }
}
