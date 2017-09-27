import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
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
	
	// Main Menu
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome. Creating a game.");
		Game test = new Game();
		Player one = new Player();
		int choice = 0;
		while(choice != 8)
		{
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Add Round");
			System.out.println("2. Remove Round");
			System.out.println("3. List Rounds");
			System.out.println("4. Add Player");
			System.out.println("5. Remove Player");
			System.out.println("6. List Player");
			System.out.println("7. View Player Associations");
			System.out.println("8. Exit Program\n");
			
			System.out.print("Enter: ");
			choice = scnr.nextInt();
			
			switch(choice)
			{
			case 1: // Add Round
				Round r = new Round();
				test.add_Rounds(r);
				break;
			case 2: // Remove Round
				Round r2;
				if(test.rounds.iterator().hasNext())
					r2 = test.rounds.iterator().next();
				else
					r2 = new Round();
				try {
					test.remove_Rounds(r2);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 3: // List Round
				test.list_Rounds();
				break;
			case 4: // Add Player
				Player p = new Player();
				try {
					test.add_Player(p);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 5: // Remove Player
				Player p2;
				if(test.players.iterator().hasNext())
					p2 = test.players.iterator().next();
				else
					p2 = new Player();
				try {
					test.remove_Player(p2);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 6: // List Players
				test.list_Players();
				break;
			case 7:
				while(choice != 10)
				{
					System.out.println("Entered Player. Which would you like to view?");
					System.out.println("1. Add Torpedo");
					System.out.println("2. Remove Torpedo");
					System.out.println("3. List Torpedos");
					System.out.println("4. Add Board");
					System.out.println("5. Remove Board");
					System.out.println("6. List Boards");
					System.out.println("7. Add Ship");
					System.out.println("8. Remove Ship");
					System.out.println("9. List Ships");
					System.out.println("10. Go Back\n");
					
					System.out.print("Enter: ");
					choice = scnr.nextInt();
					
					switch(choice)
					{
					case 1:
						Torpedo t = new Torpedo();
						try {
							one.add_Torpedo(t);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 2:
						Torpedo t2;
						if(one.torpedos.iterator().hasNext())
							t2 = one.torpedos.iterator().next();
						else
							t2 = new Torpedo();
						try {
							one.remove_Torpedo(t2);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 3:
						one.list_Torpedos();
						break;
					case 4:
						Board b = new Board();
						try {
							one.add_Board(b);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 5:
						Board b2;
						if(one.boards.iterator().hasNext())
							b2 = one.boards.iterator().next();
						else
							b2 = new Board();
						try {
							one.remove_Board(b2);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 6:
						one.list_Boards();
					case 7:
						Ship s = new Ship();
						try {
							one.add_Ship(s);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 8:
						Ship s2;
						if(one.ships.iterator().hasNext())
							s2 = one.ships.iterator().next();
						else
							s2 = new Ship();
						try {
							one.remove_Ship(s2);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					case 9:
						one.list_Ships();
						break;
					case 10:
						break;
					case 11:
						break;
					default:
						System.out.println("Invalid input entered.\n");
					}
				}
			case 8: // Exit
				break;
			default: // Invalid Input
				System.out.println("Invalid input entered.\n");
			}
		}
		System.out.println("Exiting program.");
	}
}
