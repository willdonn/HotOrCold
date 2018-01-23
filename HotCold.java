
public class HotCold {
	public static String HotOrCold(int g1, int g2, int compGuess) {
		if (compGuess == g2)
			return "Game Over";
		if (Math.abs(compGuess - g1) < Math.abs(compGuess - g2))
			return "Colder";
		if (Math.abs(compGuess - g2) <= Math.abs(compGuess - g1))
			return "Hotter";
		return "NULL";
	}
	
	public static int ComputerGuess(int n) {
		int guess = (int) Math.round(Math.random() * (n-1)) + 1;
		System.out.println(guess);
		return guess;
	}
	
	public static int GuessAlgorithm(int n, int CompGuess) {
		int low = 1, nextGuess = n, direction = 1;
		int count = 0;

		String HC = HotOrCold(low, nextGuess, CompGuess);
		
		while(HC != "Game Over") {
			if (HC == "Hotter") {
				direction = -direction;
			}
			if (HC == "Hotter" && direction == 1) {
				int temp = low;
				low = nextGuess; 
				nextGuess = (temp-low)/2 + low;
				}
			
			else if (HC == "Colder" && direction == 1) {
				nextGuess = low + (nextGuess - low)/2;
			}
			
			else if (HC == "Hotter" && direction == -1) {
				int temp = nextGuess;
				nextGuess = low + (nextGuess - low)/2;
				low = temp;
			}
			
			else if(HC == "Colder" && direction == -1) {
				nextGuess = (low - nextGuess)/2 + nextGuess;
			}
			
			HC = HotOrCold(low, nextGuess, CompGuess);
			count++;
	}
		return count;
		
	}

	
	public static void main(String args[]) {
		int n = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += GuessAlgorithm(n, ComputerGuess(n));
		}
		
		System.out.println("Solution: "+sum/1000);
	}
	
}
