class Dog extends Animal{

    // Dog-specific property
    private String breed;

    // Constructor for Dog class
    public Dog(String name) {
        super(name); // Call the constructor of the parent class Animal
        this.breed = "Unknown"; // Default value for breed
    }

    public Dog(String name, String breed) {
        super(name); // Call the constructor of the parent class Animal
        this.breed = breed; // Set the breed
    }

    // Dog class extends Animal class
    public String toString(){
        return "Dog name is: " + this.name + ", breed is: " + this.breed;
  }
}
