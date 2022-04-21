


/*
Clubs 7 → 0
Diamonds 7 → 1
Hearts 7 → 2
Spades 7 → 3
 
Ace 7 → 1
Jack 7 → 11
Queen 7 → 12
King 7 → 13 
 */


public class Cards {
		private final int rank, suit;
		public static final String [] suits= {"Clubs", "Diamonds", "Hearts", "Spades"};
		public static final String[] ranks = {null, "Ace", "2", "3", "4", "5", "6","7", "8", "9", "10", "Jack", "Queen", "King"}; //start with "null" just to start with index '1'
		
		
	public Cards(int rnk,int sut)	//Constructor of the obj.
	    {
		this.rank=rnk;
		this.suit=sut;
	    }
	
	//Getter methods
	public int getRank()
     	{
		return this.rank;
		}
		public int getSuit() 
		{
		return this.suit;
		}
	
	public boolean equals(Cards that) //test whether two objects are equivalent
	{
		return this.rank == that.rank
			&& this.suit == that.suit;
	}
	public int compareTo(Cards that) //To make cards comparable and decide which is more important
	{
		if (this.suit < that.suit) {
		return -1;
		}
		if (this.suit > that.suit) {
		return 1;
		}
		if (this.rank < that.rank) {
		return -1;
		}
		if (this.rank > that.rank) {
		return 1;
		}
		return 0;
		}
	
	public String toString() //that method to decode the rank and suit to readable strings
	{ 
	String s=ranks[this.rank] + " of " + suits[this.suit];
	return s;
	}
	
	public static void search(Cards that,Cards [] card,int left,int right)
	{
		int mid=(left+right)/2;
		if(left>right)
		{
			System.out.printf("%d",-1);
			return ;
		}
		if(card[mid].compareTo(that)==0)
		{
			System.out.printf("%d",mid);
			return;
		}
		if(card[mid].compareTo(that)<1)
		{
			search(that,card, mid+1, right);
		}
		else 
			{
				 search(that,card,left ,mid-1);
			}
			
			
	}
	
	/*public static void main(String[] args)
	{
		//initializing our playing cards 
		Cards[] card = new Cards[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++)
		{
		for (int rank = 1; rank <= 13; rank++) 
		{
		card[index] = new Cards(rank, suit);
		index++;
		}
		}
		
		Cards targ=new Cards(1,0);
		Cards.search(targ,card,0 ,51);
		
		
	}*/
}
