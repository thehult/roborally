package Client;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources
{
    public static Image TILE_SPRITE;
    public static Image ROBOT_SPRITE;
    public static Image PLAYER_BOARD;
    public static Image PLAYER_DAMAGE;
    public static Image PLAYER_HEALTH;
    public static Image PLAYER_POWERDOWN;
    public static Image CARD_FORWARD1;
    public static Image CARD_FORWARD2;
    public static Image CARD_FORWARD3;
    public static Image CARD_BACKUP;
    public static Image CARD_RIGHT;
    public static Image CARD_LEFT;
    public static Image CARD_UTURN;
    public static Image CARD_GLOW;

    public static void initResources() {
	try {
	    TILE_SPRITE = new Image("res/tile.png");
	    ROBOT_SPRITE = new Image("res/robot.png");
	    PLAYER_BOARD = new Image("res/playerboard.png");
	    PLAYER_DAMAGE = new Image("res/damagetoken.png");
	    PLAYER_HEALTH = new Image("res/lifetoken.png");
	    PLAYER_POWERDOWN = new Image("res/powerdown.png");
	    CARD_FORWARD1 = new Image("res/forward1.png");
	    CARD_FORWARD2 = new Image("res/forward2.png");
	    CARD_FORWARD3 = new Image("res/forward3.png");
	    CARD_BACKUP = new Image("res/backup.png");
	    CARD_RIGHT = new Image("res/right.png");
	    CARD_LEFT = new Image("res/left.png");
	    CARD_UTURN = new Image("res/uturn.png");
	    CARD_GLOW = new Image("res/cardglow.png");
	} catch (SlickException e) {
	    e.printStackTrace();
	}
    }
}
