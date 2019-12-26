package beads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: nsortur1
LANG: JAVA
TASK: beads
*/
public class beads {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new BufferedReader(new FileReader("beads.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

		int beadCount = scan.nextInt();
		String necklace = scan.next();
		int tempHigh = 0, tempCount = 0;
		necklace = necklace.concat(necklace).concat(necklace);

		char[] beads = necklace.toCharArray();

		int startPoint = beads.length / 3;

		for (int i = startPoint; i < beads.length * 2 / 3; i++) {

			tempCount = 0;

			int tempStart = i;
			char breakPoint = beads[i];

			if (breakPoint == 'w') {
				for (int j = tempStart; j < beads.length * 2 / 3; j++) {
					if (beads[j] == 'r') {
						breakPoint = 'r';
						break;
					} else if (beads[j] == 'b') {
						breakPoint = 'b';
						break;

					}
				}
			}

			while (beads[i] == breakPoint || beads[i] == 'w') {
				i++;
				if(i == beads.length) {
					break;
				}
				if (tempCount < beadCount) {
					tempCount++;
				}
			}

			i = tempStart - 1;
			breakPoint = beads[i];

			if (breakPoint == 'w') {
				for (int k = i; k > 0; k--) {

					if (beads[k] == 'r') {
						breakPoint = 'r';
						break;
					} else if (beads[k] == 'b') {
						breakPoint = 'b';
						break;

					}
				}
			}

			while (beads[i] == breakPoint || beads[i] == 'w') {
				if (i <= 0) {
					break;
				}
				i--;
				if (tempCount < beadCount) {
					tempCount++;
				}
			}
			if (tempCount > tempHigh) {
				tempHigh = tempCount;

			}

			i = tempStart;
		}
		out.println(tempHigh);
		out.close();
	}
}
