public class Animal 
{
    // This class can be extended by other classes like Dog.
    // It can contain common properties or methods for all animals.
    
    // Example property
    String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Animal name: " + name;
    }
}
