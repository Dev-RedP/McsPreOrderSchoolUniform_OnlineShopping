package quarter2;

import org.junit.Test;

public class Gamboa {

    @Test
    public void printMyProfile() {
        String myName = "Gamboa";
        String petName = "Rambo";
        String favFood = "Chiken inasal";
        int myAge = 18;

        System.out.println("--- MY DIGITAL PROFILE ---");
        System.out.println("Hello, my name is " + myName + " and I am " + myAge + " years old.");
        System.out.println("I have a wonderful pet named " + petName + ".");
        System.out.println("If I could, I would eat " + favFood + " every single day!");
    }
}