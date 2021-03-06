package com.ksk.snippets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ksk.typecasting.Dog;

public class ReflectionTest {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		/*
		 * Dog dog = new Dog(); Method method =
		 * dog.getClass().getDeclaredMethod("someMethod"); method.setAccessible(true);
		 * Object r = method.invoke(dog, "shiva");
		 */
		
		try {
            Class c = Class.forName("com.ksk.typecasting.Dog");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
            System.out.println(m[i].toString());
            m[2].setAccessible(true);
            m[2].invoke(c, "shiva");
         }
         catch (Throwable e) {
            System.err.println(e);
         }
	}

}
