package Client;

import Client.Board.Card;

public class Enums
{
    public enum Direction
    {
        UP(0.0f, 0, -1),
        RIGHT(90.0f, 1, 0),
        DOWN(180.0f, 0, 1),
        LEFT(270.0f, -1, 0);

	private float angle;
	private float xMod;
	private float yMod;
	private Direction left;
	private Direction right;
	private Direction opposite;
	Direction(float angle, float xMod, float yMod) {
	    this.angle = angle;
	    this.xMod = xMod;
	    this.yMod =  yMod;
	}

	static {
	    UP.left = LEFT;
	    RIGHT.left = UP;
	    DOWN.left = RIGHT;
	    LEFT.left = DOWN;

	    UP.right = RIGHT;
	    RIGHT.right = DOWN;
	    DOWN.right = LEFT;
	    LEFT.right = UP;

	    UP.opposite = DOWN;
	    DOWN.opposite = UP;
	    RIGHT.opposite = LEFT;
	    LEFT.opposite = RIGHT;
	}

	public float getAngle() {
	    return this.angle;
	}

	public float getXMod() {
	    return this.xMod;
	}

	public float getYMod() {
	    return this.yMod;
	}

	public Direction getLeft() {
	    return left;
	}
	public Direction getRight() {
		return right;
	}
	public Direction getOpposite() {
		    return opposite;
		}
    }

    public enum CardType
    {
	FORWARD1,
	FORWARD2,
	FORWARD3,
	RIGHT,
	LEFT,
	BACKUP,
	UTURN;
    }

    public enum Phase {
	DEALING,
	PROGRAMMING,
	STARTREGISTER,
	MOVING,
	CONVEYOR,
	EXPRESSCONV,
	GEARS,
	PUSHERS,
	LASERS,
	ENDREGISTER,
	ENDTURN
    }
}
