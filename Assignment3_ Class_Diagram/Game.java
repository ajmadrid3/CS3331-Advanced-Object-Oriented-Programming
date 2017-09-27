/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 3 - UML Class Diagram
 * Fall 2017
 * Purpose:
 * 	This is the Game class from the diagram.  It includes all of the attributes
 * 	and methods as well as the appropriate associations.
 */
import java.util.HashSet;
import java.util.Set;
public class Game 
{
	public int start_Time;
	public int end_Time;
	public int game_Type;
	final int MIN_ROUNDS = 0;
	final int NUM_PLAYERS = 2;
	Set<Round> rounds;
	Set<Player> players;
	
	//Constructor methods
	public Game()
	{
		rounds = new HashSet<Round>();
		players = new HashSet<Player>();
	}
	
	public Game(Set<Player> players) throws Exception
	{
		if(players.size() != NUM_PLAYERS)
			throw new Exception("ERROR: Incorrect number of players.");
		this.players = players;
		rounds = new HashSet<Round>();
	}
	
	// Add methods
	public void add_Rounds(Round r)
	{
		rounds.add(r);
		System.out.println("Round added.");
	}
	
	public void add_Player(Player p) throws Exception
	{
		if(players.size() + 1 > NUM_PLAYERS)
			throw new Exception("ERROR: Can't have more than two players.");
		players.add(p);
		System.out.println("Player added.");
	}
	
	// Remove methods
	public void remove_Rounds(Round r) throws Exception 
	{
		if(rounds.size() - 1 < MIN_ROUNDS)
			throw new Exception("ERROR: Can't have less than 0 rounds.");
		rounds.remove(r);
		System.out.println("Round removed.");
	}
	
	public void remove_Player(Player p) throws Exception
	{
		if(players.size() - 1 < NUM_PLAYERS)
			throw new Exception("ERROR: Can't have less than two players.");
		players.remove(p);
		System.out.println("Player removed.");
	}
	
	// List methods
	public void list_Rounds()
	{
		System.out.println("List of Rounds:");
		for(Round r:rounds)
			System.out.println(r.toString());
	}
	
	public void list_Players()
	{
		System.out.println("List of Players:");
		for(Player p:players)
			System.out.println(p.toString());
	}
	
	public void create_Game()
	{
		/*
		 * This will be used to initialize the game by setting the players,
		 * the type of game, and placing the ships on the board.
		 */
	}
	
	public void check_Win(Player one, Player two)
	{
		/*
		 * This method will check to see if there is a winner between the two
		 * players.  It will also assign points accordingly if there is a winner.
		 */
	}
}
