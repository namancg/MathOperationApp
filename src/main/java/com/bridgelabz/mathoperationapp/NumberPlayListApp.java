package com.bridgelabz.mathoperationapp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
public class NumberPlayListApp {

	public static void main(String[] args) {
		List<Integer> myNumberList = new ArrayList<Integer>();
		for(int index=0 ; index<5 ; index++)
			myNumberList.add(index);
		//Using Iterator
		Iterator<Integer> iterator = myNumberList.iterator();
		while(iterator.hasNext()) {
			Integer eachInteger = iterator.next();
			System.out.println("Value: "+eachInteger);
		}
		//Traversing with Consumer interface 
		class MyConsumer implements Consumer<Integer>{
			public void accept(Integer t) {
				System.out.println("Value of list using class: "+t);
			}
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
		//Traversing with Anonymous Consumer interface 
		myNumberList.forEach(new Consumer<Integer>(){
			public void accept(Integer t) {
				System.out.println("anonymous class Impl Value: "+t);
			}
		});
		//Explicit Lambda Function
		Consumer<Integer> myListAction = n -> {
			System.out.println("Explicit Lambda Impl Value: "+n);
		};
		myNumberList.forEach(myListAction);
		//Implicit Lambda Function
		myNumberList.forEach(n ->{
			System.out.println("Implicit Lambda Impl Value: "+n);
		});

	}

}
