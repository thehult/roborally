package Client.Board;

import Client.GameClient;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;

public class Map
{
    private int width;
    private int height;

    private Tile[][] tiles;

    public Map(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.tiles = new Tile[width][height];
	for(int y = 0; y < height; y++) {
	    for(int x = 0; x < width; x++) {
		this.tiles[x][y] = new Tile();
	    }
	}
    }

    public void draw(Graphics g, final float v, final float v2) {
	for(int y = 0; y < height; y++)
	    for(int x = 0; x < width; x++)
		this.tiles[x][y].draw(g, v + x * GameClient.SPRITE_WIDTH, v2 + y * GameClient.SPRITE_HEIGHT);
    }

    public Tile getTile(int x, int y) {
	return tiles[x][y];
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(final int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(final int height) {
	this.height = height;
    }


}
