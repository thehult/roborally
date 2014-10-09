package Client.Board;

import Client.GameClient;
import Client.Resources;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;

public class Tile
{

    private Image sprite = null;

    public Tile() {
	sprite = Resources.TILE_SPRITE;
    }

    public void draw(Graphics g, final float x, final float y) {
	g.drawImage(sprite, x, y);
    }
}
