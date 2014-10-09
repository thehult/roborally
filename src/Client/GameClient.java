package Client;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameClient extends StateBasedGame
{
    public static final int INGAMESTATE = 1;

    public static final float BASE_WIDTH = 2736.0f;
    public static final float BASE_HEIGHT = 3504.0f;

    public static final float SPRITE_WIDTH = 128.0f;
    public static final float SPRITE_HEIGHT = 128.0f;

    public static float CLIENT_HEIGHT = 900.0f;

    public GameClient(final String title) {
	super(title);
    }

    @Override public void initStatesList(final GameContainer gameContainer) throws SlickException {
	this.addState(new StateIngame());

    }

}
