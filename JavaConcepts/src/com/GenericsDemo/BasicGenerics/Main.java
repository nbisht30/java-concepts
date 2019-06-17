package com.GenericsDemo.BasicGenerics;

public class Main {
public static void main(String args[]) {
	// TODO Auto-generated constructor stub
	Test t1= new Test("Nikhil");  //Raw type declaration, warning given
	t1.setObject(10);
	System.out.println(t1.getObject());  
	
	Test<String> t2= new Test<>("Nikhil");

	//t2.setObject(10); gives error at compile time as type has been restricted to String
}
}

