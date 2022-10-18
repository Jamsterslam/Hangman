import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman
{
	private static final String[] hanged = {"_________\n |/\n |\n |\n |\n |\n |\n |___\n",
											"_________\n |/   |\n |\n |\n |\n |\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |\n |\n |\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |    |\n |    |\n |\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |   /|\n |    |\n |\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |   /|\\\n |    |\n |\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |   /|\\\n |    |\n |   /\n |\n |___\n",
											"_________\n |/   |\n |   (_)\n |   /|\\\n |    |\n |   / \\\n |\n |___\n"};
	
	ArrayList<String> letters;
	private int score;
	private String[] currentGuess;
	private String word;
	
	public Hangman ()
	{
		Scanner keyboard = new Scanner(System.in);
		letters = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		word = "AARDVARK";
		currentGuess = new String[word.length()];
		score = 0;
		
		while(score < 7 && !word.equalsIgnoreCase(String.join("", currentGuess)))
		{
			System.out.println(hanged[score]);
			System.out.println(letters);
			
			printCurrentGuess();
			
			System.out.println("");
			System.out.print("What is your guess? ");
			
			String guess = keyboard.nextLine().toUpperCase();
			
			if(letters.indexOf(guess) == -1)
				System.out.println("The letter has already been used or your input is inadequate.");
			
			else
			{
				if(word.contains(guess))
					addGuess(guess);
				else
					score++;
			}
			
			clearScreen();
		}
		
		if(score == 7)
		{
			System.out.println(hanged[score]);
			System.out.println("You have lost.");
		}
		
		else
			System.out.println("You Have Won");
	}
	
	private void addGuess (String guess)
	{
		String[] wordSplit = word.split("");
		
		for(int i = 0; i < wordSplit.length; i++)
			if(wordSplit[i].equalsIgnoreCase(guess))
				currentGuess[i] = guess;
		
		letters.remove(guess);
	}
	
	private void printCurrentGuess ()
	{
		for(int i = 0; i < currentGuess.length; i++)
			if(currentGuess[i] == null)
				System.out.print(" _ ");
			else
				System.out.print(" " + currentGuess[i] + " ");
	}
	
	private void clearScreen () 
	{  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	
	public static void main (String[] args)
	{
		Hangman game = new Hangman();
	}
}