/*  The game Bulls and Cows 
 * 	Main Class
 *  Natali Boniel, 201122140 */

package BullsAndCows;

import javax.swing.JOptionPane;

public class PlayBullsAndCows {
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Welcome to the Bulls And Cows game!", "Bulls And Cows", JOptionPane.PLAIN_MESSAGE);
		
		final int NUM_SIZE = 4;
		int numOfGames = 0;
		boolean newGame = true;
		while (newGame)
		{
			numOfGames ++;
			JOptionPane.showMessageDialog(null, "Game no." + numOfGames, "Bulls And Cows", JOptionPane.PLAIN_MESSAGE);
			
			//random number
			BullsAndCows gameNum = new BullsAndCows();
					
			String ifMoreGame = "";
			
			boolean legal = true;
			int numOfGuesses = 1;
			String winning = "Very good! you won!";
			String result = "";
			String guess = "";
			
			//************************
			//JOptionPane.showMessageDialog(null, "The number is: " + gameNum.number, "1111", JOptionPane.PLAIN_MESSAGE);
			//************************
			
			while (!result.equals(winning))
			{
				guess = JOptionPane.showInputDialog("Enter your guess no. " + numOfGuesses + " (" + NUM_SIZE + " digits number)");
				legal = gameNum.guessIsLegal(guess);
				if (legal)
				{
					result = gameNum.checkGuess(guess);
					JOptionPane.showMessageDialog(null, gameNum.historyGuesses(result), "History of guesses", JOptionPane.PLAIN_MESSAGE);
					numOfGuesses++;
				}
				else
					JOptionPane.showMessageDialog(null, "Didn't enter " + NUM_SIZE + " digits \n or \nSame digits in your guess", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			numOfGuesses--;
			JOptionPane.showMessageDialog(null, "The number is: " + gameNum.number + "\nTotal number of guesses: " + numOfGuesses, "You Won!", JOptionPane.PLAIN_MESSAGE);
			
			//check if he wants to play again
			ifMoreGame = JOptionPane.showInputDialog("Do you wont to play again? Enter 'YES' or 'NO'");
			if (ifMoreGame.equals("NO"))
				newGame = false;
		}
	}
}
