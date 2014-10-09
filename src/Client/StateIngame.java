package Client;

import Client.Board.Deck;
import Client.Board.Map;
import Client.Board.Player;
import Client.Board.Robot;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateIngame extends BasicGameState
{

    private Map map;
    private Robot testRobot;
    private Robot[] robots = new Robot[8];
    private Player[] players = new Player[8];
    private int noRobots = 0;
    private Deck deck = new Deck();

    private Enums.Phase currentPhase = Enums.Phase.DEALING;

    @Override public int getID() {
	return GameClient.INGAMESTATE;
    }

    @Override public void init(final GameContainer gameContainer, final StateBasedGame stateBasedGame) throws SlickException {
	Resources.initResources();
	map = new Map(12, 16);
	robots[0] = new Robot(new Color(185, 185, 0));
	players[0] = new Player();
	noRobots = 1;
	robots[0].setDrawX(GameClient.SPRITE_WIDTH);
	robots[0].setDrawY(GameClient.SPRITE_HEIGHT * 4);
	deck.makeDeck();
	players[0].dealCard(0, deck.pickCard());
	players[0].dealCard(1, deck.pickCard());
	players[0].dealCard(2, deck.pickCard());
	players[0].dealCard(3, deck.pickCard());
	players[0].dealCard(4, deck.pickCard());
	players[0].dealCard(5, deck.pickCard());
	players[0].dealCard(6, deck.pickCard());
	players[0].dealCard(7, deck.pickCard());
	
    }

    @Override
    public void render(final GameContainer gameContainer, final StateBasedGame stateBasedGame, final Graphics graphics)
	    throws SlickException
    {

	graphics.scale(gameContainer.getWidth() / GameClient.BASE_WIDTH, gameContainer.getHeight() / GameClient.BASE_HEIGHT);
	map.draw(graphics, GameClient.SPRITE_WIDTH, GameClient.SPRITE_HEIGHT);
	robots[0].draw(graphics);
	players[0].draw(0, GameClient.SPRITE_HEIGHT * 18);
	graphics.scale(1, 1);
    }

    int testi = 0;
    @Override public void update(final GameContainer gameContainer, final StateBasedGame stateBasedGame, final int delta)
	    throws SlickException
    {
	InputHandler.update(gameContainer);
	for(int i=0; i < noRobots; i++) {
	    robots[i].update(delta);
	    players[i].update(gameContainer, delta);
	}
    }
}
