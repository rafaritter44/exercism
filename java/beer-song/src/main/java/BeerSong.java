
public class BeerSong {
	
	public String sing(int bottles, int times) {
		if(times == 0) return "";
		if(bottles == 0) {
			return "No more bottles of beer on the wall, no more bottles of beer.\n" + 
					"Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
		} else return String.format("%s of beer on the wall, %s of beer.\n"
				+ "Take " + (bottles == 1 ? "it" : "one") + " down and pass it around, %s of beer on the wall.\n\n",
				toString(bottles), toString(bottles), toString(bottles - 1)) + sing(bottles - 1, times - 1);
	}
	
	public String singSong() {
		return sing(99, 100);
	}
	
	private String toString(int bottles) {
		switch(bottles) {
		case 0: return "no more bottles";
		case 1: return "1 bottle";
		default: return String.format("%d bottles", bottles);
		}
	}

}
