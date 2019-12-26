package ride;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
ID: nsortur1
LANG: JAVA
TASK: ride
*/
public class ride {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new BufferedReader(new FileReader("ride.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		StringTokenizer st1 = new StringTokenizer(scan.next());

		int firstProd = 1, secondProd = 1;

		for (char a : st1.nextToken().toCharArray()) {
			int temp = Math.abs(64 - (int) a);
			firstProd *= temp;
		}

		StringTokenizer st2 = new StringTokenizer(scan.next());
		for (char a : st2.nextToken().toCharArray()) {
			int temp = Math.abs(64 - (int) a);
			secondProd *= temp;
		}

		if (firstProd % 47 == secondProd % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		out.close();

	}

}
