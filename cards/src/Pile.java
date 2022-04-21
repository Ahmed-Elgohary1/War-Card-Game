import java.util.ArrayList;

public class Pile 
{

	public ArrayList<Cards> cards;	
	
  public Pile() 
   {
    	this.cards = new ArrayList<Cards>();
   }
	
	public Cards popCard() 
		{
		return this.cards.remove(0); // from the top of the pile
		}
	public void addCard(Cards card)
		{
		this.cards.add(card); // to the bottom of the pile
		}
	public boolean isEmpty()
	    {
		return this.cards.isEmpty();
		}
	
	public void addDeck(Deck deck) 
	  {
		for (Cards card : deck.getCards()) 
		 {
		   this.cards.add(card);
		 }
	  }

	
}
