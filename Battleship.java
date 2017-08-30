/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Fall 2017
 * Purpose:
 * 	This program allows users to enter a point on the board.  It will then list all of the
 * 	squares that are edge adjacent, corner adjacent, and squares that are not adjacent.
 */
import java.util.Scanner;
public class Battleship 
{	
	public static boolean board[][] = new boolean[9][9];
	
	//Used to find and print the squares that are edge adjacent to the given point.
	public static void edge_Adjacency(int x_coordinate, int y_coordinate)
	{
		System.out.println("Squares Edge Adjacenct to (" + x_coordinate + ", " + y_coordinate + "):");
		if(x_coordinate == 0)
		{
			if(y_coordinate == 0)
			{
				//System.out.println("Corner");
				board[x_coordinate][y_coordinate+1] = true;
				board[x_coordinate+1][y_coordinate] = true;
				System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
				System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
			}
			else if(y_coordinate == 8)
			{
				//System.out.println("Corner");
				board[x_coordinate][y_coordinate-1] = true;
				board[x_coordinate+1][y_coordinate] = true;
				System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
				System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
			}
			else
			{
				//System.out.println("Edge");
				board[x_coordinate][y_coordinate-1] = true;
				board[x_coordinate][y_coordinate+1] = true;
				board[x_coordinate+1][y_coordinate] = true;
				System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
				System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
				System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
			}
		}
		else if(x_coordinate == 8)
		{
			if(y_coordinate == 0)
			{
				//System.out.println("Corner");
				board[x_coordinate-1][y_coordinate] = true;
				board[x_coordinate][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
				System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
			}
			else if(y_coordinate == 8)
			{
				//System.out.println("Corner");
				board[x_coordinate-1][y_coordinate] = true;
				board[x_coordinate][y_coordinate-1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
				System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
			}
			else
			{
				//System.out.println("Edge");
				board[x_coordinate-1][y_coordinate] = true;
				board[x_coordinate][y_coordinate-1] = true;
				board[x_coordinate][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
				System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
				System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
			}
		}
		else if(y_coordinate == 0)
		{
			//System.out.println("Edge");
			board[x_coordinate-1][y_coordinate] = true;
			board[x_coordinate+1][y_coordinate] = true;
			board[x_coordinate][y_coordinate+1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
			System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
		}
		else if(y_coordinate == 8)
		{
			//System.out.println("Edge");
			board[x_coordinate-1][y_coordinate] = true;
			board[x_coordinate+1][y_coordinate] = true;
			board[x_coordinate][y_coordinate-1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
			System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
		}
		else
		{
			//System.out.println("Center");
			board[x_coordinate-1][y_coordinate] = true;
			board[x_coordinate+1][y_coordinate] = true;
			board[x_coordinate][y_coordinate-1] = true;
			board[x_coordinate][y_coordinate+1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + y_coordinate + ")");
			System.out.println("(" + x_coordinate + ", " + (y_coordinate-1) + ")");
			System.out.println("(" + x_coordinate + ", " + (y_coordinate+1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + y_coordinate + ")");
		}
	}
	
	//Used to find and print the squares that are corner adjacent to the given point. 
	public static void corner_Adjacency(int x_coordinate, int y_coordinate)
	{
		System.out.println("Squares Corner Adjacent to (" + x_coordinate + ", " + y_coordinate + "):");
		if(x_coordinate == 0)
		{
			if(y_coordinate == 0)
			{
				board[x_coordinate+1][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate+1) + ")");
			}
			else if(y_coordinate == 8)
			{
				board[x_coordinate+1][y_coordinate-1] = true;
				System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate-1) + ")");
			}
			else
			{
				board[x_coordinate+1][y_coordinate-1] = true;
				board[x_coordinate+1][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate-1) + ")");
				System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate+1) + ")");
			}
		}
		else if(x_coordinate == 8)
		{
			if(y_coordinate == 0)
			{
				board[x_coordinate-1][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate+1) + ")");
			}
			else if(y_coordinate == 8)
			{
				board[x_coordinate-1][y_coordinate-1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate-1) + ")");
			}
			else
			{
				board[x_coordinate-1][y_coordinate-1] = true;
				board[x_coordinate-1][y_coordinate+1] = true;
				System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate-1) + ")");
				System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate+1) + ")");
			}
		}
		else if(y_coordinate == 0)
		{
			board[x_coordinate-1][y_coordinate+1] = true;
			board[x_coordinate+1][y_coordinate+1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate+1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate+1) + ")");
		}
		else if(y_coordinate == 8)
		{
			board[x_coordinate-1][y_coordinate-1] = true;
			board[x_coordinate+1][y_coordinate-1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate-1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate-1) + ")");
		}
		else
		{
			board[x_coordinate-1][y_coordinate-1] = true;
			board[x_coordinate-1][y_coordinate+1] = true;
			board[x_coordinate+1][y_coordinate-1] = true;
			board[x_coordinate+1][y_coordinate+1] = true;
			System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate-1) + ")");
			System.out.println("(" + (x_coordinate-1) + ", " + (y_coordinate+1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate-1) + ")");
			System.out.println("(" + (x_coordinate+1) + ", " + (y_coordinate+1) + ")");
		}
	}
	
	// Prints out all of the squares that are not adjacent to the given point.
	public static void non_Adjacency(int x_coordinate, int y_coordinate)
	{
		System.out.println("Squares Not Adjacent to (" + x_coordinate + ", " + y_coordinate + "):");
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(!board[i][j])
				{
					System.out.println("(" + i + ", " + j + ")");
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{	
		Scanner scnr = new Scanner(System.in);
		boolean valid_choice = false;
		int x_coordinate = 0, y_coordinate = 0;
		while(!valid_choice)
		{
			System.out.print("Enter the x-coordinate of the square: ");
			x_coordinate = scnr.nextInt();
			if(x_coordinate < 0 || x_coordinate > 8)
			{
				System.out.println("ERROR: Invalid x-coordinate.");
			}
			else
			{
				valid_choice = true;
			}
		}
		
		valid_choice = false;
		while(!valid_choice)
		{
			System.out.print("Enter the y-coordinate of the square: ");
			y_coordinate = scnr.nextInt();
			if(y_coordinate < 0 || y_coordinate > 8)
			{
				System.out.println("ERROR: Invalid y-coordinate.");
			}
			else
			{
				valid_choice = true;
			}
		}
		board[x_coordinate][y_coordinate] = true;
		
		edge_Adjacency(x_coordinate, y_coordinate);
		corner_Adjacency(x_coordinate, y_coordinate);
		non_Adjacency(x_coordinate, y_coordinate);
	}

}
