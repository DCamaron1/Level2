package org.jointheleague.level2;

public class Arrays {
	public static void main(String[] args) {
		String[] names = new String[3];
		names[2] = "David";
		names[0] = "Esme";
		names[1] = "Isis";
		for (int i = 0; i < names.length; i++) {
		//	System.out.println(names[i]);
		}
		
		int[] numbers = new int[3];
		numbers[2]= 3;
		numbers[1] = 2;
		numbers[0] = 1;
		for (int i = numbers.length-1; i >= 0; i=i-1) {
			System.out.println(numbers[i]);
		}
	}
}
