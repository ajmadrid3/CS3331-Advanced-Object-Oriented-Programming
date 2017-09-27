/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 3 - UML Class Diagram
 * Fall 2017
 * Purpose:
 * 	This is the Ship class from the diagram.  It includes all of the attributes
 * 	and methods.
 */
public class Ship 
{
	public int size;
	public int value;
	public boolean sunk;
	public int[][] coordinates;
	
	public boolean is_Hit()
	{
		/*
		 * Returns true if the ship is hit and false if it is
		 * a miss.
		 */
		return false;
	}
	
}
