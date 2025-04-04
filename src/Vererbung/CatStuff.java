package Vererbung;

public class CatStuff implements AnimalStuff {

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}
