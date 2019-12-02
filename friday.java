import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
ID: nsortur1
LANG: JAVA
TASK: friday
*/
public class friday {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new BufferedReader(new FileReader("friday.txt")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		ArrayList<Integer> frequencies = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			frequencies.add(0);
		}

//		int leftOver = days[i] % 7;

		int years = scan.nextInt();
		int leapYears = getLeapYears(years);

		int totalDays = ((years - leapYears) * 365) + (leapYears * 366);
		System.out.println("total days: " + totalDays);

		int weekDay = 0;
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < years; i++) {
			// Each year

			for (int j = 0; j < days.length; j++) {
				// Each month
				for (int k = 0; k < days[j]; k++) {
					// Each day

					weekDay++;
					if (weekDay > 6) {
						weekDay = 0;
					}
				}
			}
		}

		for (int i = 0; i < frequencies.size(); i++) {
			System.out.print(frequencies.get(i) + " ");
		}
	}

	public static int getLeapYears(int years) {
		int numLeapYears = 0;

		for (int i = 1900; i <= 1900 + years; i++) {
			if (i % 100 == 0) {
				if (i % 400 == 0) {
					numLeapYears++;
				}
			} else {
				if (i % 4 == 0) {
					numLeapYears++;
				}
			}
		}

		return numLeapYears;
	}

	public static boolean isLeapYear(int input) {
		int year = 1900 + input;
		boolean returnThis = false;
		
		if (year % 100 == 0) {
			if(year % 400 == 0) {
				returnThis = true;
			}
		} else {
			if (year % 4 == 0) {
				returnThis = true;
			}
		}
		return returnThis;
	}
//	for(int i=0; i <= totalDays; i++) {
//		if(i % 13 == 0) {
//			if(i % 7 == 1) {
//				frequencies.set(0, frequencies.get(0) + 1);
//			} else if(i % 7 == 2) {
//				frequencies.set(1, frequencies.get(1) + 1);
//			} else if(i % 7 == 3) {
//				frequencies.set(2, frequencies.get(2) + 1);
//			} else if(i % 7 == 4) {
//				frequencies.set(3, frequencies.get(3) + 1);
//			} else if(i % 7 == 5) {
//				frequencies.set(4, frequencies.get(4) + 1);
//			} else if(i % 7 == 6) {
//				frequencies.set(5, frequencies.get(5) + 1);
//			} else if(i % 7 == 0) {
//				frequencies.set(6, frequencies.get(6) + 1);
//			} else {
//				System.out.println("Wat");
//			}
//		}
//	}
}
