package Client.Board;

import Client.Enums;
import Client.Resources;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;

public class Card
{
    private Enums.CardType cardType;
    private int speed = 100;
    private Image sprite;

    public Card(final Enums.CardType cardType, final int speed) {
	this.cardType = cardType;
	this.speed = speed;
	switch (cardType) {
	    case FORWARD1:
		sprite = Resources.CARD_FORWARD1;
		break;
	    case FORWARD2:
		sprite = Resources.CARD_FORWARD2;
		break;
	    case FORWARD3:
		sprite = Resources.CARD_FORWARD3;
		break;
	    case BACKUP:
		sprite = Resources.CARD_BACKUP;
		break;
	    case RIGHT:
		sprite = Resources.CARD_RIGHT;
		break;
	    case LEFT:
		sprite = Resources.CARD_LEFT;
		break;
	    case UTURN:
		sprite = Resources.CARD_UTURN;
		break;

	}
    }

    public Card(final Enums.CardType cardType) {
	this(cardType, 100);
    }

    public Card() {
	this(Enums.CardType.FORWARD1);
    }

    public Enums.CardType getCardType() {
	return cardType;
    }

    public void setCardType(final Enums.CardType cardType) {
	this.cardType = cardType;
    }

    public int getSpeed() {
	return speed;
    }

    public void setSpeed(final int speed) {
	this.speed = speed;
    }

    public void draw(final float v, final float v2) {
	sprite.draw(v, v2);
    }

    public void draw(final float v, final float v2, boolean glow) {
   	sprite.draw(v, v2);
	if(glow)
	    Resources.CARD_GLOW.draw(v, v2);
    }
}
