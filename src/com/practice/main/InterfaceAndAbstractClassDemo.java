package com.practice.main;

abstract class Person {
	abstract void eat();
}

public class InterfaceAndAbstractClassDemo {
	public static void main(String args[]) {
		Person p = new Person() {
			public void eat() {
				System.out.println("nice fruits");
			}
		};
		p.eat();
	}
}