/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 3 - UML Class Diagram
 * Fall 2017
 * Purpose:
 * 	This is the Board class from the diagram.  It includes all of the attributes
 * 	and methods as well as the appropriate associations.
 */
import java.util.HashSet;
import java.util.Set;
public class Board 
{
	public int size;
	final int NUM_SHIPS = 6;
	Set<Ship> ships;
	
	// Constructor Methods
	public Board()
	{
		ships = new HashSet<Ship>();
	}
	
	public Board(Set<Ship> ships) throws Exception
	{
		if(ships.size() != NUM_SHIPS)
			throw new Exception("ERROR: Incorrect number of ships.");
		this.ships = ships;
	}
	
	// Add Method
	public void add_Ship(Ship s) throws Exception
	{
		if(ships.size() + 1 > NUM_SHIPS)
			throw new Exception("ERROR: Can't have more than 6 ships.");
		ships.add(s);
		System.out.println("Ship added.");
	}
	
	// Remove Method
	public void remove_Ship(Ship s) throws Exception 
	{
		if(ships.size() - 1 < NUM_SHIPS)
			throw new Exception("ERROR: Can't have less than 6 rounds.");
		ships.remove(s);
		System.out.println("Ship removed.");
	}
	
	// List Method
	public void list_Ships()
	{
		System.out.println("List of Ships:");
		for(Ship s:ships)
			System.out.println(s.toString());
	}
}
