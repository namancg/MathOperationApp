package com.bridgelabz.mathoperationapp;

public class MathOperationApp {

	public static void main(String[] args) {
		IMathFunction add = (int a,int b) -> a+b;
		IMathFunction subtract = (a,b) -> a-b;
		IMathFunction multiply = ( a, b) -> a*b;
		IMathFunction divide = (a,b) -> a/b;
		System.out.println("ADDITION:"+add.calculate(7, 3));
		System.out.println("SUBTRACTION:"+subtract.calculate(7, 3));
		System.out.println("MULITIPLICATION:"+multiply.calculate(7, 3));
		System.out.println("DIVISION:"+divide.calculate(20,2));

	}

}
@FunctionalInterface
interface IMathFunction{
	int calculate(int a, int b);
}
