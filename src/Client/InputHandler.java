package Client;

import org.newdawn.slick.GameContainer;

public class InputHandler
{
    private static int mouseX;
    private static int mouseY;
    private static GameContainer gc;

    public static void update(GameContainer gameContainer) {
	gc = gameContainer;
	mouseX = (int)(gameContainer.getInput().getMouseX() / (gameContainer.getWidth() / GameClient.BASE_WIDTH));
	mouseY = (int)(gameContainer.getInput().getMouseY() / (gameContainer.getHeight() / GameClient.BASE_HEIGHT));
    }

    public static int getMouseX() {
	return mouseX;
    }

    public static int getMouseY() {
	return mouseY;
    }

    public static boolean isMousePressed(final int button) {
	return gc.getInput().isMousePressed(button);
    }
}
