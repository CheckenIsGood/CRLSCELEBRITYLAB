import java.util.ArrayList;

/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */

	private Celebrity gameCelebrity;

	/**
	 * The GUI frame for the Celebrity game.
	 */

	private CelebrityFrame gameWindow;

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */

	private ArrayList<Celebrity> celebGameList;

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		this.celebGameList = new ArrayList<Celebrity>();
		this.gameWindow = new CelebrityFrame(this);
	}

	/**
	 * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
	 */
	public void prepareGame()
	{
		this.celebGameList = new ArrayList<Celebrity>(); 
		gameWindow.replaceScreen("START");
	}

	/**
	 * Determines if the supplied guess is correct.
	 * 
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{

		boolean matches = false;

		if (guess.trim().equalsIgnoreCase(gameCelebrity.getAnswer()))
		{
			matches = true;
			celebGameList.remove(0);
			if (celebGameList.isEmpty())
			{
				this.gameCelebrity = new Celebrity("", "");
			}
			else
			{
				this.gameCelebrity = celebGameList.getFirst();
			}
		}
		return matches;
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	public void play()
	{
		if (this.celebGameList != null && !celebGameList.isEmpty())
		{
			this.gameCelebrity = celebGameList.get(0);
			this.gameWindow.replaceScreen("GAME");
		}
		else
		{
			this.gameWindow = new CelebrityFrame(this);
			this.gameWindow.replaceScreen("START");
		} 
	}

	/**
	 * Adds a Celebrity of specified type to the game list
	 * 
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		Celebrity currentCelebrity;
		if (type.equals("Literature"))
		{
			currentCelebrity = new LiteratureCelebrity(name, guess);
		}
		else if (type.equals("Movie"))
		{
			currentCelebrity = new MovieCelebrity(name, guess);
		}
		else //Add an else if here
		{
			currentCelebrity = new Celebrity(name, guess);
		}
		this.celebGameList.add(currentCelebrity); 
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		if (name.trim().length() >= 4)
		{
			return true;
		}
		return false;
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity 
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{

		// wtf does series of clues mean?
		boolean validClue = false;
		if (clue.trim().length() >= 10)
		{
			validClue = true;
			if (type.equalsIgnoreCase("Literature"))
			{
				String[] temp = clue.split(",");
				if (temp.length > 1)
				{
					validClue = true; // Literature clues must be a series of clues
				}
				else
				{
					validClue = false; // Literature clues must be a series of clues
				}
			}
			else if (type.equalsIgnoreCase("Movie"))
			{
				String[] temp = clue.split(",");
				if (temp.length > 2)
				{
					validClue = true; // Movie clues must be a series of clues
				}
				else
				{
					validClue = false; // Movie clues must be a series of clues
				}
			}
		}
		return validClue;
	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 * 
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return this.celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 * 
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return this.gameCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 * 
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return this.gameCelebrity.getAnswer();
	}
}
