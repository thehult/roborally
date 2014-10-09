package Client.Board;

import Client.Enums;
import Client.GameClient;
import Client.Resources;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Renderable;

public class Robot implements Renderable
{

    public static final int ROBOT_ANIM_TIME = 750;

    private Player player;

    private Image sprite;
    private Color color;
    private Card[] registers = new Card[5];

    private Enums.Direction lookDir = Enums.Direction.RIGHT;

    private boolean animating = false;
    private float addAngle = 0.0f;
    private float addX = 0.0f;
    private float addY = 0.0f;
    private float stopX = 0.0f;
    private float stopY = 0.0f;
    private int timeElapsed = 0;

    private float drawX;
    private float drawY;

    public Robot() {
	this(Color.gray);
    }

    public Robot(final Color color) {
	this.color = color;
	sprite = Resources.ROBOT_SPRITE;

    }

    public void executeCard(int register) {
	executeCard(registers[register]);
    }

    public void executeCard(Card card) {
	switch (card.getCardType()) {
	    case RIGHT:
		lookDir = lookDir.getRight();
		startRotating(90.0f);
		break;
	    case LEFT:
		lookDir = lookDir.getLeft();
		startRotating(-90.0f);
		break;
	    case UTURN:
		lookDir = lookDir.getOpposite();
		startRotating(180.0f);
		break;
	    case FORWARD1:
		startMoving(1);
		break;
	    case FORWARD2:
		startMoving(2);
		break;
	    case FORWARD3:
		startMoving(3);
		break;
	    case BACKUP:
		startMoving(-1);
		break;
	}
    }

    public void startRotating(float addAngle) {
	animating = true;
	timeElapsed = ROBOT_ANIM_TIME;
	if(addAngle == 180.0f)
	    timeElapsed = ROBOT_ANIM_TIME * 2;
	this.addAngle = addAngle / (float)timeElapsed;
    }

    public void startMoving(int tiles) {
	startMoving((int)(lookDir.getXMod() * tiles), (int)(lookDir.getYMod() * tiles));
    }

    public void startMoving(int x, int y) {
	animating = true;
	timeElapsed = ROBOT_ANIM_TIME * (int)Math.abs(Math.hypot((double)x, (double)y));
	this.addX = (float)x * GameClient.SPRITE_WIDTH / (float)timeElapsed;
	this.addY = (float)y * GameClient.SPRITE_HEIGHT / (float)timeElapsed;
	this.stopX = drawX + (float)x * GameClient.SPRITE_HEIGHT;
	this.stopY = drawY + (float)y * GameClient.SPRITE_HEIGHT;
    }
    public void update(int delta) {
	if(animating) {
	    timeElapsed -= delta;
	    sprite.setCenterOfRotation(GameClient.SPRITE_WIDTH / 2.0f, GameClient.SPRITE_HEIGHT / 2.0f);
	    sprite.rotate((float)delta * addAngle);
	    drawX += (float)delta * addX;
	    drawY += (float)delta * addY;
	    if(timeElapsed < 0) {
		stopAnimation();
	    }
	}
    }

    public void stopAnimation() {
	timeElapsed = 0;
	animating = false;
	addAngle = 0.0f;
	addX = 0.0f;
	addY = 0.0f;
	sprite.setRotation(lookDir.getAngle());
	drawX = stopX;
	drawY = stopY;
    }

    public boolean isAnimating() {
	return animating;
    }



    @Override public void draw(final float v, final float v2) {
	sprite.draw(v, v2, GameClient.SPRITE_WIDTH, GameClient.SPRITE_HEIGHT, color);
    }

    public void draw(Graphics g) {
	g.drawImage(sprite, drawX, drawY, color);
    }

    public float getDrawX() {
	return drawX;
    }

    public void setDrawX(final float drawX) {
	this.drawX = drawX;
    }

    public float getDrawY() {
	return drawY;
    }

    public void setDrawY(final float drawY) {
	this.drawY = drawY;
    }
}
