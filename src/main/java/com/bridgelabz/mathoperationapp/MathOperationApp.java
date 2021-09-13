package com.bridgelabz.mathoperationapp;

public class MathOperationApp {

	public static void main(String[] args) {
		IMathFunction add = (int a,int b) -> a+b;
		IMathFunction subtract = (a,b) -> a-b;
		IMathFunction multiply = ( a, b) -> a*b;
		IMathFunction divide = (a,b) -> a/b;
		IMathFunction.print(7, 3,"ADD",add);
		IMathFunction.print(7, 3,"SUBTRACT",subtract);
		IMathFunction.print(7, 3,"MULTIPLY",multiply);
		IMathFunction.print(7, 3,"DIVIDE",divide);

	}

}
@FunctionalInterface
interface IMathFunction{
	int calculate(int a, int b);
	static void print(int a, int b, String function, IMathFunction functionObj)
	{
		System.out.println("RESULT OF THE OPERATION "+function+" IS "+functionObj.calculate(a, b));
	}
}
