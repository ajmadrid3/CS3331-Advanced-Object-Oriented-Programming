/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 3 - UML Class Diagram
 * Fall 2017
 * Purpose:
 * 	This is the Player class from the diagram.  It includes all of the attributes
 * 	and methods as well as the appropriate associations.
 */
import java.util.HashSet;
import java.util.Set;
public class Player 
{
	public String id;
	public int points;
	final int MIN_TOR = 0;
	final int MAX_TOR = 45;
	final int NUM_BOARDS = 2;
	final int NUM_SHIPS = 6;
	Set<Torpedo> torpedos;
	Set<Board> boards;
	Set<Ship> ships;
	
	// Constructor Methods
	public Player()
	{
		torpedos = new HashSet<Torpedo>();
		boards = new HashSet<Board>();
		ships = new HashSet<Ship>();
	}
	
	public Player(Set<Board> boards, Set<Ship> ships) throws Exception
	{
		if(boards.size() != NUM_BOARDS)
			throw new Exception("ERROR: Incorrect number of boards.");
		this.boards = boards;
		if(ships.size() != NUM_SHIPS)
			throw new Exception("ERROR: Incorrect number of ships.");
		this.ships = ships;
		torpedos = new HashSet<Torpedo>();
	}
	
	// Add Methods
	public void add_Torpedo(Torpedo t) throws Exception
	{
		if(torpedos.size() + 1 > MAX_TOR)
			throw new Exception("ERROR: Can't have more than 45 torpedos.");
		torpedos.add(t);
		System.out.println("Torpedo added.");
	}
	
	public void add_Board(Board b) throws Exception
	{
		if(boards.size() + 1 > NUM_BOARDS)
			throw new Exception("ERROR: Can't have more than two boards.");
		boards.add(b);
		System.out.println("Board added.");
	}
	
	public void add_Ship(Ship s) throws Exception
	{
		if(ships.size() + 1 > NUM_SHIPS)
			throw new Exception("ERROR: Can't have more than 6 ships.");
		ships.add(s);
		System.out.println("Ship added.");
	}
	
	// Remove Methods
	public void remove_Torpedo(Torpedo t) throws Exception 
	{
		if(torpedos.size() - 1 < MIN_TOR)
			throw new Exception("ERROR: Can't have less than 0 torpedos.");
		torpedos.remove(t);
		System.out.println("Torpedo removed.");
	}
	
	public void remove_Board(Board b) throws Exception 
	{
		if(boards.size() - 1 < NUM_BOARDS)
			throw new Exception("ERROR: Can't have less than 2 rounds.");
		boards.remove(b);
		System.out.println("Board removed.");
	}
	
	public void remove_Ship(Ship s) throws Exception 
	{
		if(ships.size() - 1 < NUM_SHIPS)
			throw new Exception("ERROR: Can't have less than 6 rounds.");
		ships.remove(s);
		System.out.println("Ship removed.");
	}
	
	// List Methods
	public void list_Torpedos()
	{
		System.out.println("List of Torpedos:");
		for(Torpedo t:torpedos)
			System.out.println(t.toString());
	}
	
	public void list_Boards()
	{
		System.out.println("List of Boards:");
		for(Board b:boards)
			System.out.println(b.toString());
	}
	
	public void list_Ships()
	{
		System.out.println("List of Ships:");
		for(Ship s:ships)
			System.out.println(s.toString());
	}
}
