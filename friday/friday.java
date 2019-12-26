package friday;
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
		Scanner scan = new Scanner(new BufferedReader(new FileReader("friday.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		ArrayList<Integer> frequencies = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			frequencies.add(0);
		}

		int years = scan.nextInt();

		int weekDay = 0;
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < years; i++) {
			// Each year
			int tempMonths = (isLeapYear(i)) ? leapDays.length : days.length;

			for (int j = 0; j < tempMonths; j++) {
				// Each month

				int tempDays = (isLeapYear(i)) ? leapDays[j] : days[j];
				for (int k = 0; k < tempDays; k++) {
					// Each day
					if (k == 13) {
						frequencies.set(weekDay, frequencies.get(weekDay) + 1);
					}
					weekDay++;
					if (weekDay > 6) {
						weekDay = 0;
					}
				}
			}
		}
		frequencies.add(0, frequencies.get(6));
		frequencies.remove(7);

		for (int i = 0; i < frequencies.size(); i++) {
			if (i == 6) {
				out.print(frequencies.get(i));
				out.println();

			} else {
				out.print(frequencies.get(i) + " ");
			}
		}
		out.close();
	}

	public static boolean isLeapYear(int input) {
		int year = 1900 + input;
		boolean returnThis = false;

		if (year % 100 == 0) {
			if (year % 400 == 0) {
				returnThis = true;
			}
		} else {
			if (year % 4 == 0) {
				returnThis = true;
			}
		}
		return returnThis;
	}
//	public static int getLeapYears(int years) {
//		int numLeapYears = 0;
//
//		for (int i = 1900; i <= 1900 + years; i++) {
//			if (i % 100 == 0) {
//				if (i % 400 == 0) {
//					numLeapYears++;
//				}
//			} else {
//				if (i % 4 == 0) {
//					numLeapYears++;
//				}
//			}
//		}
//
//		return numLeapYears;
//	}
}
