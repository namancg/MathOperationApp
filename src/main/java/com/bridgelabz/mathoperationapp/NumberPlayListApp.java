package com.bridgelabz.mathoperationapp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import java.util.stream.Collectors;
public class NumberPlayListApp {

	public static void main(String[] args) {
		List<Integer> myNumberList = new ArrayList<Integer>();
		for(int index=0 ; index<7 ; index++)
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
				System.out.println("METHOD 2: Consumer implmentation value: "+t);
			}
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
		//Traversing with Anonymous Consumer interface 
		myNumberList.forEach(new Consumer<Integer>(){
			public void accept(Integer t) {
				System.out.println("METHOD 3: anonymous class Implementation Value: "+t);
			}
		});
		//Explicit Lambda Function
		Consumer<Integer> myListAction = n -> {
			System.out.println("METHOD 4: Explicit Lambda Implementation Value: "+n);
		};
		myNumberList.forEach(myListAction);
		//Implicit Lambda Function
		myNumberList.forEach(n ->{
			System.out.println("METHOD 5: Implicit Lambda Implementation Value: "+n);
		});
		//Implicit function to print double value
		Function<Integer, Double> toDoubleFunction =Integer::doubleValue;
		myNumberList.forEach(n -> {
			System.out.println("METHOD 6: Double implementation Value :" +toDoubleFunction.apply(n));
		});
		// implicit function to check even and print it
		Predicate<Integer> isEvenFunction = n -> n>0 && n % 2 == 0;
		myNumberList.forEach(n -> System.out.println((isEvenFunction.test(n)==true) ?"METHOD 7: " +n+"IS EVEN NUMBER":+n+"IS A ODD NUMBER"));
		
		// JAVA STREAMS
		// Processing the stream
		myNumberList.stream().forEach(n -> {
			System.out.println("Stream forEach value: "+n);
		});
		// process streams, apply operations and store the results using streams
		List<Double> streamList = myNumberList.stream()
								  .filter(isEvenFunction)
								  .map(toDoubleFunction)
								  .collect(Collectors.toList());
		System.out.println("printing double list"+streamList);
		
		//Peek first element 
		Integer first = myNumberList.stream()
						.filter(isEvenFunction)
						.peek(n -> System.out.println("Peek Even Number:"+n))
						.findFirst()
						.orElse(null);
		System.out.println("METHOD 8: first even number "+first);
		
		//Minimum and maximum of the given even number
		Integer min = myNumberList.stream()
					  .filter(isEvenFunction)
					  .min((n1,n2)->n1-n2)
					  .orElse(null);
		System.out.println("METHOD 9: Minimum even nnumber : "+min);
		
		Integer max = myNumberList.stream()
				  .filter(isEvenFunction)
				  .max((Comparator.comparing(Integer::intValue)))
				  .orElse(null);
		System.out.println("METHOD 10: Maximum even nnumber : "+max);
		
		//Sum and average in numbers stream
		Integer sum = myNumberList.stream()
					  .reduce(0, Integer::sum);
		long count = myNumberList.stream()
					 .count();
		System.out.println("METHOD 11: Average of " +sum+ "/"+count+" = "+sum/count);
		
		//Find all or atleast one is even in number stream
		boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
		boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
		boolean noneMultiOfSix= myNumberList.stream().noneMatch(i -> i>0 && i%6 ==0);
		System.out.println("METHOD 12: allEven: "+allEven+"\noneEven " +oneEven+ "\nnoneMultiOfSix "+noneMultiOfSix);
		
		//sort the number stream in ascending order
		List <Integer> sortedList = myNumberList.stream()
									.sorted((n1,n2)->n1.compareTo(n2))
									.collect(Collectors.toList());
		System.out.println("METHOD 13: "+sortedList);
	}
	
}
