package lesson8.exercise_2_soln;

import java.util.Random;

public class MyRandGen implements MyIface {
	public int produce() {
		Random r = new Random();
		return r.nextInt();
	}	
	public static void main(String[] args) {
		MyIface mrg = new MyRandGen();
		System.out.println(mrg.produce());	
		MyIface mrg2 = () -> (new Random()).nextInt();
		System.out.println(mrg2.produce());
	}
}
