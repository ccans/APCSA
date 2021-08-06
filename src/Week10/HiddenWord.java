package Week10;

public class HiddenWord {
	
	private String hiddenWord;
	public HiddenWord(String input) {
		hiddenWord = input;
	}
	
	public String getHint(String input) {
		String returnString = "";
		char[] string1 = input.toCharArray();
		char[] string2 = hiddenWord.toCharArray();

		for(int i = 0; i < input.length(); i++) {
			if(string1[i] == string2[i]) {
				returnString += string1[i];
			} else if(checkIfInDiffPos(string1[i], string2)) {
				returnString += "+";
			} else {
				returnString += "*";
			}
		}

		return returnString;
	}

	public boolean checkIfInDiffPos(char a, char[] b) {
		for(int i = 0; i < b.length; i++) {
			if(a == b[i]) return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		
		HiddenWord puzzle = new HiddenWord("HARPS");
		System.out.println(puzzle.getHint("AAAAA"));
		System.out.println(puzzle.getHint("HELLO"));
		System.out.println(puzzle.getHint("HEART"));
		System.out.println(puzzle.getHint("HARMS"));
		System.out.println(puzzle.getHint("HARPS"));
		
	}

}

