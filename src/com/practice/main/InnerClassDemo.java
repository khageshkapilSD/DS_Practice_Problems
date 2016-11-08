package com.practice.main;

public class InnerClassDemo {
	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	void display() {
		Inner in = new Inner();
		in.msg();
	}

	public static void main(String args[]) {
		InnerClassDemo obj = new InnerClassDemo();
		obj.display();
		Inner in = obj.new Inner();
		in.msg();
	}
}
