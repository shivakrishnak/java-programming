package com.ksk.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MultiGeneric<T, S> {

	T firstObj;
	S secondObj;
	
	public T getFirstObj() {
		return firstObj;
	}
	public void setFirstObj(T firstObj) {
		this.firstObj = firstObj;
	}
	public S getSecondObj() {
		return secondObj;
	}
	public void setSecondObj(S secondObj) {
		this.secondObj = secondObj;
	}

	

}

public class MultiGenericBase{
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		MultiGeneric gen = new MultiGeneric(); //Raw Type
		gen.setFirstObj("shiva");
		gen.setSecondObj(25);
		System.out.println(gen.getFirstObj());
		System.out.println(gen.getSecondObj());
		
		MultiGeneric<String, Integer> gen2 = new MultiGeneric<String, Integer>(); 
		gen2.setFirstObj("krishna");
		gen2.setSecondObj(28);
		System.out.println(gen2.getFirstObj());
		System.out.println(gen2.getSecondObj());
	}
}
