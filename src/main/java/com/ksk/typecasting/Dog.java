package com.ksk.typecasting;

public class Dog extends Animal {
	
	public Dog() {
		System.out.println("dog created...");
	}
	
	public void walk() {
		System.out.println("dog walking...");
	}
	
	public void bark() {
		System.out.println("dog barking...");
	}
	
	private String someMethod(String name) {
		return "private method called...";
	}
}
