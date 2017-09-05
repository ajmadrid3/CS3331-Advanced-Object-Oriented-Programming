/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 1 - Battle Ship Game
 * Fall 2017
 * Purpose:
 * 	This program allows users to enter a point on the board.  It will then list all of the
 * 	squares that are edge adjacent, corner adjacent, and squares that are not adjacent.  If 
 *  the incorrect format or values are entered, it will prompt the user to enter it again 
 *  until they are valid.
 */
import java.util.Scanner;
public class Battleship 
{	
	// Once a square is marked, the value in the array is set to true.
	public static boolean board[][] = new boolean[9][9];
	
	//Used to determine the type of input the user enters and if they entered valid coordinates.
	public static int[] input_Reader()
	{
		Scanner scnr = new Scanner(System.in);
		boolean valid_format = false;
		boolean valid_choice = false;
		int[] coordinates = new int[2];
		
		while(!valid_choice)
		{
			System.out.println("Enter the coordinates (0 to 8 or a to i) in one of the following formats: ");
			System.out.println("(5, 5)   3 0   4,1   a7   b 2");
			System.out.print("Entered Coordinates: ");
			String input = scnr.nextLine();
			
			// Checks to see if the parenthesis format is entered correctly
			if(input.charAt(0) == '(')
			{
				if(!Character.isDigit(input.charAt(1)) || !Character.isDigit(input.charAt(4)))
				{
					System.out.println("ERROR: Invalid Format\n");
				}
				else
				{
					coordinates[0] = Character.getNumericValue(input.charAt(1));
					coordinates[1] = Character.getNumericValue(input.charAt(4));
					valid_format = true;
				}
			}
			
			// Checks to see if either of the letter formats are entered correctly
			else if(Character.isLetter(input.charAt(0)))
			{
				input.toLowerCase();
				char value = input.charAt(0);
				
				// Changes the letter to the correct number value
				switch (value)
				{
					case 'a': coordinates[0] = 0;
						break;
					case 'b': coordinates[0] = 1;
						break;
					case 'c': coordinates[0] = 2;
						break;
					case 'd': coordinates[0] = 3;
						break;
					case 'e': coordinates[0] = 4;
						break;
					case 'f': coordinates[0] = 5;
						break;	
					case 'g': coordinates[0] = 6;
						break;
					case 'h': coordinates[0] = 7;
						break;
					case 'i': coordinates[0] = 8;
						break;
					default: System.out.println("ERROR: Invalid Value Entered\n");
				}
				
				// Checks if next character is a letter
				if(Character.isLetter(input.charAt(1)))
				{
					System.out.println("ERROR: Invalid Format\n");
				}
				// Checks if the next character is a digit
				else if(Character.isDigit(input.charAt(1)))
				{
					coordinates[1] = Character.getNumericValue(input.charAt(1));
					valid_format = true;
				}
				//Checks if the two charcters are an empty space and a digit
				else if(input.charAt(1) == ' ' && Character.isDigit(input.charAt(2)))
				{
					coordinates[1] = Character.getNumericValue(input.charAt(2));
					valid_format = true;
				}
				else
					System.out.println("ERROR: Invalid Format\n");
			}
			
			// Checks to see if either of the digit formats are entered correctly
			else if(Character.isDigit(input.charAt(0)))
			{
				coordinates[0] = Character.getNumericValue(input.charAt(0));
				// Checks if the next charcter is either a comma or an empty space
				if(input.charAt(1) == ',' || input.charAt(1) == ' ')
				{
					if(Character.isDigit(input.charAt(2)))
					{
						coordinates[1] = Character.getNumericValue(input.charAt(2));
						valid_format = true;
					}
					else
						System.out.println("ERROR: Invalid Format\n");
				}
				else
					System.out.println("ERROR: Invalid Format\n");
			}
			
			// Gives the error that an unaccepted format was used
			else
				System.out.println("ERROR: Invalid Format\n");
			
			// If a valid format was entered, checks to see if the values are between 0 and 8
			if(valid_format) 
			{
				if((coordinates[0] >= 0 && coordinates[0] < 9) || (coordinates[1] >= 0 && coordinates[1] < 9))
					valid_choice = true;
				else
					System.out.println("ERROR: Invalid Values Entered");
			}
		}
		System.out.println("Coordinates Accepted\n");
		// Sets the entered coordinates to true.
		board[coordinates[0]][coordinates[1]] = true;
		return coordinates;
	}
	
	//Used to find and print the squares that are edge adjacent to the given point.  Sets the adjacent squares to true.
	public static void edge_Adjacency(int[] coordinates)
	{
		System.out.println("Squares Edge Adjacent to (" + coordinates[0] + ", " + coordinates[1] + "):");
		
		int[][] adjacent = {
							{coordinates[0] - 1, coordinates[1]},	// Left
							{coordinates[0] + 1, coordinates[1]},	// Right
							{coordinates[0], coordinates[1] - 1},	// Upper
							{coordinates[0], coordinates[1] + 1}	// Lower
						   };
		
		for(int counter = 0; counter < adjacent.length; counter ++)
		{
			if(!(adjacent[counter][0] > 8 || adjacent[counter][0] < 0 || adjacent[counter][1] > 8 || adjacent[counter][1] < 0))
			{
				board[adjacent[counter][0]][adjacent[counter][1]] = true;
				System.out.println("(" + adjacent[counter][0] + ", " + adjacent[counter][1] + ")");
			}
		}
	}
	
	//Used to find and print the squares that are corner adjacent to the given point.  Sets the adjacent squares to true.
	public static void corner_Adjacency(int[] coordinates)
	{
		System.out.println("Squares Corner Adjacent to (" + coordinates[0] + ", " + coordinates[1] + "):");
		
		int[][] adjacent = {
							{coordinates[0] - 1, coordinates[1] - 1},	// Bottom Left
							{coordinates[0] + 1, coordinates[1] - 1},	// Bottom Right	
							{coordinates[0] - 1, coordinates[1] + 1},	// Upper Left
							{coordinates[0] + 1, coordinates[1] + 1}	// Upper Right
							};
		
		for(int counter = 0; counter < adjacent.length; counter ++)
		{
			if(!(adjacent[counter][0] > 8 || adjacent[counter][0] < 0 || adjacent[counter][1] > 8 || adjacent[counter][1] < 0))
			{
				board[adjacent[counter][0]][adjacent[counter][1]] = true;
				System.out.println("(" + adjacent[counter][0] + ", " + adjacent[counter][1] + ")");
			}
		}
	}
	
	// Prints out all of the squares that are not adjacent to the given point, false.
	public static void non_Adjacency(int[] coordinates)
	{
		System.out.println("Squares Not Adjacent to (" + coordinates[0] + ", " + coordinates[1] + "):");
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(!board[i][j])
				{
					System.out.print("(" + i + ", " + j + ") ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{	
		System.out.println("Battleship Square Adjacency\n");
		
		int[] coordinates = input_Reader();
		edge_Adjacency(coordinates);
		corner_Adjacency(coordinates);
		non_Adjacency(coordinates);
	}

}
