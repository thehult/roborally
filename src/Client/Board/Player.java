package Client.Board;

import Client.Enums;
import Client.InputHandler;
import Client.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Renderable;

public class Player implements Renderable
{
    private int id;
    private int health = 2;
    private int damage = 4;
    private boolean powerDown = false;

    private Card[] programmedCards = new Card[5];
    private Card[] dealtCards = new Card[10];

    private Robot robot;

    private Image sprite;
    private Image damageSprite;
    private Image healthSprite;
    private Image powerDownSprite;

    public Player() {
	sprite = Resources.PLAYER_BOARD;
	damageSprite = Resources.PLAYER_DAMAGE;
	healthSprite = Resources.PLAYER_HEALTH;
	powerDownSprite = Resources.PLAYER_POWERDOWN;
    }

    private float drawX = 0.0f;
    private float drawY = 0.0f;

    private int selDealtId = -1;
    private int selProgId = -1;

    public void update(GameContainer gameContainer, int delta) {
	//POWER DOWN
    	if(InputHandler.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
	    if(InputHandler.getMouseX() >= 16 + drawX && InputHandler.getMouseX() < 270 + drawX && InputHandler.getMouseY() >= 16 + drawY && InputHandler.getMouseY() < 240 + drawY)
    	    	powerDown = !powerDown;
	    //DEALADE KORT
	    if(InputHandler.getMouseY() >= drawY + 800 && InputHandler.getMouseY() < drawY + 1184) {
		for(int i = 0; i < 10; i++) {
		    if (InputHandler.getMouseX() >= drawX + 16 + 272*i && InputHandler.getMouseX() < drawX + 16 + 272*i + 256) {
			if(dealtCards[i] == null && selProgId != -1) {
			    dealtCards[i] = programmedCards[selProgId];
			    programmedCards[selProgId] = null;
			    selProgId = -1;
			} else if(dealtCards[i] != null) {
			    selProgId = -1;
			    selDealtId = i;
			}
			break;
		    }
		}
	    }
		//PROGGADE KORT
	    if(InputHandler.getMouseY() >= drawY + 384 && InputHandler.getMouseY() < drawY + 762) {
		for(int i = 0; i < 5; i++) {
		    if (InputHandler.getMouseX() >= drawX + 16 + 272*i && InputHandler.getMouseX() < drawX + 16 + 272*i + 256) {
			if(programmedCards[i] == null && selDealtId != -1) {
			    programmedCards[i] = dealtCards[selDealtId];
			    dealtCards[selDealtId] = null;
			    selDealtId = -1;
			} else if(programmedCards[i] != null) {
			    selProgId = i;
			    selDealtId = -1;
			}
			break;
		    }
		}
	    }
	}
    }

    @Override public void draw(final float v, final float v2) {
	drawX = v;
	drawY = v2;
	sprite.draw(v, v2);
	for(int i = 8; i >= 9 - damage; i--) {
		damageSprite.draw(v + 80 + 272 * i, v2 + 256);
	}
	for(int i = 0; i < health; i++) {
	    healthSprite.draw(v + 464 + 272 * i,v2 + 40);
	}
	if (!powerDown)
		powerDownSprite.draw(v + 16, v2 + 16);
	for(int i=0;i < 10; i++) {
	    if(dealtCards[i] != null) {
		dealtCards[i].draw(v + 16 + 272*i, v2 + 800, selDealtId == i);
	    }
	}
	for(int i=0;i < 5; i++) {
	    if(programmedCards[i] != null) {
		programmedCards[i].draw(v + 16 + 272*i, v2 + 384, selProgId == i);
	    }
	}
    }

    public void dealCard(int slotId, Enums.CardType cardType, int speed) {
	dealtCards[slotId] = new Card(cardType, speed);
    }

    public void dealCard(int slotId, Card c) {
    	dealtCards[slotId] = new Card(c.getCardType(), c.getSpeed());
    }

    public void dealRandomCards() {

    }

}
