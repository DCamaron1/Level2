package level2Game;

import java.util.ArrayList;

public class WarmUp {
	public static void main(String[] args) {
		ArrayList<Integer> ages = new ArrayList<>();
		ages.add(2);
		ages.add(10);
		ages.set(0, ages.get(0) + 2);
		ages.add(0,50);
		System.out.println(ages);
	}
}

