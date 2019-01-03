/*  The game Bulls and Cows 
 * 	Methods for the main class
 *  Natali Boniel, 201122140 */

package BullsAndCows;

import java.util.Random;
import static java.lang.Character.getNumericValue;

public class BullsAndCows {
	
	final int NUM_SIZE = 4;
	private int[] num;
	private String history = "";
	
	//the random number
	public int number = 0;
	
	public BullsAndCows()
	{
		num = new int[NUM_SIZE];
		Random r = new Random();
		
		//set random number with different digits
		for (int i=0; i<NUM_SIZE; i++) 
		{
			boolean flag = false;
			num[i] = r.nextInt(10);
			while (i!=0 && !flag)
			{
				flag = true;
				for (int j=i-1; j>=0; j--)
					if (num[i] == num[j])
					{
						num[i] = r.nextInt(10);
						flag = false;
					}
			}	
		}
		
		//the random number
		int m = 1000;
		for (int i=0; i<NUM_SIZE; i++)
		{
			number += num[i] * m;
			m = m/10;
		}
	}
	
	//check if guess is legal
	public boolean guessIsLegal (String guess)
	{
		if ((guess.length()) != (NUM_SIZE))
			return false;
		for (int i=0; i<NUM_SIZE; i++)
			for (int j=0; j<NUM_SIZE; j++)
				if ((guess.charAt(i) == guess.charAt(j)) && (i!=j))
					return false;
		return true;
	}
	
	//check number of bulls and cows
	public String checkGuess (String guess)
	{
		int bulls = 0;
		int cows = 0;
		for (int i=0; i<NUM_SIZE; i++)
	          for(int j=0; j<NUM_SIZE; j++)
	              if(getNumericValue(guess.charAt(i)) == num[j])
	              {
	                  if (i==j)
	                     bulls++;
	                  else
	                     cows++;    
	              }              
	    if (bulls == NUM_SIZE)
	    	return "Very good! you won!";
	    String result = "Guess "  + guess + "- Number of bulls: " + bulls + ", Number of cows: " + cows;
	    return result;
	}
	
	public String historyGuesses (String result)
	{
		history += result + "\n";
		return history;
	}
}
