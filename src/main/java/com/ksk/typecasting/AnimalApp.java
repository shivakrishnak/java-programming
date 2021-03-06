package com.ksk.typecasting;

/**
 * When using inheritance, the compile-time type of the reference to an object
 * on which you call a method is only used to see (at compile time) if the
 * method may be invoked.
 *
 * But at the invocation time, it does not matter what that compile-time type
 * is. What really matters in this case is the runtime type of the object.
 */
public class AnimalApp {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.walk();
		animal.run();

		System.out.println("-----------Upcasting----------");
		Dog adog = new Dog();
		adog.bark();
		System.out.println(adog);
		Animal animalDog = adog; // Upcasting - Casting from a subclass to a superclass
		animalDog.walk();
		animalDog.run();
		// animalDog.bark(); //compilation error - At compile time, type of object is Animal
		((Dog) animalDog).bark(); // Works due to Downcasting
		System.out.println(animalDog);

		System.out.println("----------Downcasting-----------");
		Animal acat = new Cat();
		System.out.println(acat);
		acat.walk();
		acat.run();
		// acat.meow(); //compilation error
		((Cat) acat).meow(); // Downcasting - It’s the casting from a superclass to a subclass

		Animal animalCat = acat;
		// animalCat.meow(); //compilation error
	}
}
