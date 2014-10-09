package Client.Board;

import Client.Enums;

public class Deck
{
    private Card[] deck = new Card[84];
    private int curCard = 0;

    public void makeDeck() {
	for(int i=0;i<84;i++) {
	    if(i < 18)
		deck[i] = new Card(Enums.CardType.FORWARD1, (int)Math.round(Math.random()*30) * 10 + 300);
	    else if(i < 30)
		deck[i] = new Card(Enums.CardType.FORWARD2, (int)Math.round(Math.random()*30) * 10 + 400);
	    else if(i < 36)
		deck[i] = new Card(Enums.CardType.FORWARD3, (int)Math.round(Math.random()*30) * 10 + 500);
	    else if(i < 42)
		deck[i] = new Card(Enums.CardType.BACKUP, (int)Math.round(Math.random()*30) * 10 + 200);
	    else if(i < 60)
		deck[i] = new Card(Enums.CardType.RIGHT, (int)Math.round(Math.random()*30) * 10 + 200);
	    else if(i < 78)
		deck[i] = new Card(Enums.CardType.LEFT, (int)Math.round(Math.random()*30) * 10 + 200);
	    else if(i < 84)
		deck[i] = new Card(Enums.CardType.UTURN, (int)Math.round(Math.random()*30) * 10 + 100);
	}
	shuffleDeck();
    }

    public void resetDeck() {
	curCard = 0;
	shuffleDeck();
    }

    public void shuffleDeck() {
	for(int i=curCard; i < 84; i++) {
	    int n = (int)(Math.random() * (84-i) + i);
	    Card c = deck[n];
	    deck[n] = deck[i];
	    deck[i] = c;
	}
    }

    public Card pickCard() {
	return deck[curCard++];
    }
}
