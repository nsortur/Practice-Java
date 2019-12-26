package gift1;
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
TASK: gift1
*/
public class gift1 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new BufferedReader(new FileReader("gift1.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();

		int giverIndex = 0;
		int giveMoney = 0;
		int numPeople = 0;
		String giver = "";
		int amtGroupMembers = scan.nextInt();

		for (int i = 0; i < amtGroupMembers; i++) {
			values.add(0);
		}
		for (int i = 0; i < amtGroupMembers; i++) {
			names.add(scan.next());
		}

		while (scan.hasNext()) {
			giver = scan.next();

			for (int i = 0; i < amtGroupMembers; i++) {
				if (names.get(i).equals(giver)) {
					giverIndex = i;
				}
			}

			giveMoney = scan.nextInt();
			numPeople = scan.nextInt();

			if (numPeople != 0) {
				int leftOver = giveMoney % numPeople;
				if (numPeople != 1) {
					values.set(giverIndex, values.get(giverIndex) + leftOver - giveMoney);
				} else {
					values.set(giverIndex, values.get(giverIndex) - giveMoney);
				}
				
				int tempMoney = 0;
				
				
				for(int i=0; i < numPeople; i++) {
					String tempName = scan.next();
					for(int j=0; j < amtGroupMembers; j++) {
						if(names.get(j).equals(tempName)) {
							tempMoney = values.get(j) + (giveMoney / numPeople);
							values.set(j, tempMoney);
						}
					}
				}
			}
		}
		
		for(int i=0; i < names.size(); i++) {
			out.println(names.get(i) + " " + values.get(i));
		}
		out.close();
	}

}
