package hullo;

import java.util.Scanner;

public class killCat {
	
	
	public static boolean runOver() {
		System.out.println("Run over cat??");
		Scanner scan = new Scanner(System.in);
		String sc = scan.next();
		boolean question = true;

		if (sc.equals("yes")) {
			question = true;
		} else if (sc.equals("no")){
			question = false;
		} else {
			System.out.println("Say yes or no fool");
			runOver();
		}
		

		return question;
	}
	
	public static void main(String[] args) {
		Cat a = new Cat();
		a.setMood("happy");
		while (a.getLegs() > 1) {
			if (runOver() == true) {
				a.crash();
				System.out.println("Cat's legs after crash: " + a.getLegs() + " and mood is " + a.getMood());
				runOver();
			} else {
				System.out.println("Cat still has " + a.getLegs() + " legs and mood is " + a.getMood());
				runOver();
			}
		}
		System.out.println("You killed the cat and its mood is " +a.getMood());
	}

}
