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
		
		int[][] adjacent = {
							{x_coordinate - 1, y_coordinate},	// Left
							{x_coordinate + 1, y_coordinate},	// Right
							{x_coordinate, y_coordinate - 1},	// Upper
							{x_coordinate, y_coordinate + 1}	// Lower
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
	
	//Used to find and print the squares that are corner adjacent to the given point. 
	public static void corner_Adjacency(int x_coordinate, int y_coordinate)
	{
		System.out.println("Squares Corner Adjacent to (" + x_coordinate + ", " + y_coordinate + "):");
		
		int[][] adjacent = {
							{x_coordinate - 1, y_coordinate - 1},	// Bottom Left
							{x_coordinate + 1, y_coordinate - 1},	// Bottom Right	
							{x_coordinate - 1, y_coordinate + 1},	// Upper Left
							{x_coordinate + 1, y_coordinate + 1}	// Upper Right
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
