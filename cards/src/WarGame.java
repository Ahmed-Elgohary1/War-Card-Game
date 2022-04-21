import java.util.ArrayList;

public class WarGame {

	private  Deck deck1 =new Deck(52);
	private Pile p1 = new Pile();
    private Pile p2 = new Pile();

   public void play()
   {
	deck1.shuffle();
	p1.addDeck(deck1.subdeck(0, 25));
	p2.addDeck(deck1.subdeck(26, 51));
	while(!p1.isEmpty() && !p2.isEmpty())
	 {
			  Cards c1 = p1.popCard();
	          Cards c2 = p2.popCard();
	         if(IsThereWinner())
	        	 break;
	    int diff = c1.getRank() - c2.getRank();	
	    
	    if (diff > 0) 
	      {
	    	p1.addCard(c1);
	    	p1.addCard(c2);
	       }
	    else if (diff < 0) 
	       {
	    	p2.addCard(c1);
	    	p2.addCard(c2);
	       }
	    else
	        {
	    	tie(c1,c2);
	    	}
		
	 }
	if(p1.isEmpty())
	{
	  System.out.println("Player 2 ");
	}
	else
		  System.out.println("Player 1 ");
	
	
  }
     
   
// helper function
private void tie(Cards c1,Cards c2)
 {
Pile temp=new Pile();
int n=0;
while(c1.getRank()==c2.getRank())
	{
	  
    	temp.addCard(c1);  temp.addCard(c2);
    	n+=2;
      for(int i=0;i<3;i++)
      {
    	  
    	  temp.addCard(p1.popCard());  temp.addCard(p2.popCard());
    	  if(IsThereWinner())
    	  {
    		  return;
    	  }    	  n+=2;
      }
     
      c1 = p1.popCard(); c2 = p2.popCard(); 
      if(IsThereWinner())
	  {
		  return;
	  }	}
	int diff = c1.getRank() - c2.getRank();	
    
    if (diff > 0) 
      {
    	p1.addCard(c1);
    	p1.addCard(c2);
    	while(n-->0)
    	{
    		p1.addCard(temp.popCard());
    	}
       }
    else if (diff < 0) 
       {
    	p2.addCard(c1);
    	p2.addCard(c2);
    	while(n-->0)
    	{
    		p1.addCard(temp.popCard());
    	}
       }
	
  }

private boolean IsThereWinner()
{
	if(p1.isEmpty())
	{
	  return true;
	}
	if(p2.isEmpty())
	{
	  return true;
	}
	return false;
}

public static void main(String[] args) 
{
	
	WarGame og=new WarGame();
	og.play();
}


}
