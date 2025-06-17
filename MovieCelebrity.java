public class MovieCelebrity extends Celebrity
{
    /**
     * The movie that the celebrity is known for.
     */
    private String movie;

    /**
     * The date of the movie that the celebrity is known for.
     */
    private int date;

    /**
     * Creates a MovieCelebrity instance with the supplied answer, clue, and movie.
     * @param answer The name of the celebrity.
     * @param clue The clue to determine the celebrity.
     * @param movie The movie associated with the celebrity.
     * @param date The date of the movie associated with the celebrity.
     */
    public MovieCelebrity(String answer, String clue, String movie, int date)
    {
        super(answer, clue);
        this.movie = movie;
        this.date = date;
    }

    public MovieCelebrity(String answer, String clue)
    {
        super(answer, clue);
        this.movie = "Unknown"; // Default value if not provided
        this.date = 0; // Default value if not provided
    }

    /**
     * Supplies the movie associated with the celebrity.
     * @return The movie of the celebrity.
     */
    public String getMovie()
    {
        return this.movie;
    }

    /**
     * Updates the movie to the provided String.
     * @param movie The new movie.
     */
    public void setMovie(String movie, int date)
    {
        this.movie = movie;
        this.date = date;
    }
    
    //overrides the toString in Celebrity
	public String toString()
	{
		return "The movie celebrity's name is " + super.getAnswer() + ", the clue is " + super.getClue() + ", and the movie is " + this.movie + " released in " + this.date;
	}
}
