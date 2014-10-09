import Client.GameClient;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    public static void main(String[] args) {
	startClient();
    }


    private static void startClient() {
	try
	    {
		AppGameContainer appgc;
		appgc = new AppGameContainer(new GameClient("RoboRally Client"));
		appgc.setDisplayMode((int)(GameClient.CLIENT_HEIGHT * (GameClient.BASE_WIDTH / GameClient.BASE_HEIGHT)), (int)GameClient.CLIENT_HEIGHT, false);
		appgc.start();
	    }
	    catch (SlickException ex)
	    {
		Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
	    }
    }
}
