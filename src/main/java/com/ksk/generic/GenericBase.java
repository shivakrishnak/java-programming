package com.ksk.generic;

class Generic<T> {

	T obj;

	void setObject(T value) {
		this.obj = value;
	}

	T getObject() {
		return this.obj;
	}

}

public class GenericBase{
	
	public static void main(String[] args) {
		Generic gen = new Generic(); //Raw Type
		gen.setObject("shiva");
		System.out.println(gen.getObject());
		
		Generic<String> gen2 = new Generic<String>(); 
		gen2.setObject("shiva");
		System.out.println(gen2.getObject());
	}
}
