package hullo;

public class Cat {
	String mood;
	int legs = 2;
	Cat next;
	
	public void setMood(String m) {
		mood = m;
	}
	
	public void crash() {
		if (legs > 0) {
			legs--;
		} 
		else if(legs == 0) {
			mood = "dead";
			legs--;
		}
	}
	
	public String getMood() {
		return mood;
	}
	
	public int getLegs() {
		return legs;
	}
	
}
