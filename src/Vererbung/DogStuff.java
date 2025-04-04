package Vererbung;

public class DogStuff implements AnimalStuff {
    @Override
    public void makeSound() {
        System.out.println("Aff");
    }
}
