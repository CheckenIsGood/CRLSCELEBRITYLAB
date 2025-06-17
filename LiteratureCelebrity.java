public class LiteratureCelebrity extends Celebrity
{
    /**
     * The literature that the celebrity is known for.
     */
    private String literature;

    /**
     * Creates a LiteratureCelebrity instance with the supplied answer, clue, and literature.
     * @param answer The name of the celebrity.
     * @param clue The clue to determine the celebrity.
     * @param literature The literature associated with the celebrity.
     */
    public LiteratureCelebrity(String answer, String clue, String literature)
    {
        super(answer, clue);
        this.literature = literature;
    }

    public LiteratureCelebrity(String answer, String clue)
    {
        super(answer, clue);
        this.literature = "Unknown"; // Default value if not provided
    }

    /**
     * Supplies the literature associated with the celebrity.
     * @return The literature of the celebrity.
     */
    public String getLiterature()
    {
        return this.literature;
    }

    /**
     * Updates the literature to the provided String.
     * @param literature The new literature.
     */
    public void setLiterature(String literature)
    {
        this.literature = literature;
    }
    
    //overrides the toString in Celebrity
    public String toString()
    {
        return "The literature celebrity's name is " + super.getAnswer() + ", the clue is " + super.getClue() + ", and the literature is " + this.literature;
    }
    
}
