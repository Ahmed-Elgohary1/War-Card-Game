import java.util.Random;

public class Deck {
 
private Cards[] cards;

Deck(int n)
{
	this.cards= new Cards[n];
	int index = 0;
	for (int suit = 0; suit <= 3&&index<n; suit++) 
	{
		for (int rank = 1; rank <= 13&&index<n; rank++)
		{
			this.cards[index] = new Cards(rank, suit);
			index++;
		}
	}
}

public Deck subdeck(int low, int high)
{
Deck sub = new Deck(high - low + 1);
for (int i = 0; i < sub.cards.length; i++)
  {
	sub.cards[i] = this.cards[low + i];
  }
return sub;
}

public void shuffle()
{
  for (int i=0;i<cards.length;i++)
  {
	int rand=randomInt(i,cards.length);
	swapCards(i,rand);
  }
}

public void SelectionSort()
{
	for(int i=0;i<cards.length;i++)
	{
	int index=indexLowest(i,cards.length-1);
	swapCards(i,index);
	}
}

private void sort(int low, int high)
{
    if (low < high) {
        // Find the middle point
        int m = low+(high-low)/2;

        // Sort first and second halves
        sort(low, m);
        sort(m + 1, high);

        // Merge the sorted halves
       merge(low, m, high);
    }
}

//helper functions
private static int randomInt(int low, int high) // create A random number in range of [low,high]
{
	Random rand = new Random();
	if(low==high)
	{
		return low;
	}
	return (low+rand.nextInt(high-low)); 
}

private void swapCards(int i, int j) 	// swap the ith and the jth cards in the array
{
Cards temp;
temp=cards[i];
cards[i]=cards[j];
cards[j]=temp;
}

private int indexLowest(int low, int high) 	// find the lowest card between low and high
{
	int index=low;
	Cards temp;
	Cards min=cards[low];

	for(int i=low;i<=high;i++)
	{
	   temp=cards[i];
	   if(min.compareTo(temp)>=0)
	   {
		   index=i;
		   min=temp;
	   }
	   
	}
	return index;
}



//Merges two subarrays of cards[].
// First subarray is cards[l..m]
// Second subarray is cards[m+1..r]
private void merge( int l, int m, int r)
{
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    Cards[] L = new Cards[n1];
    Cards [] R = new Cards[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
        L[i] = cards[l + i];
    for (int j = 0; j < n2; ++j)
        R[j] = cards[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i].compareTo(R[j])<1) {
            cards[k] = L[i];
            i++;
        }
        else {
            cards[k] = R[j];
            j++;
        }
        k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
        cards[k] = L[i];
        i++;
        k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
        cards[k] = R[j];
        j++;
        k++;
    }
}


public void print() 
{
	for (Cards card : this.cards)
	{
		System.out.println(card);
	}
}
public Cards[] getCards() {
return this.cards;
}
	
	

/*
public static void main(String[] args) 
	{
Deck og=new Deck(52);
og.shuffle();
og.print();

	}*/

}
