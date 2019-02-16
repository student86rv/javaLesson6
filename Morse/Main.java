
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		String[] messages = {"gin", "zen", "gig", "msg"};
		
		String[] messagesInMorse = codeGenerator(messages);
		
		System.out.println("Unique messages: " + uniqueSearch(messagesInMorse));
	}
	
	public static String[] codeGenerator(String[] messages){
		String[] codeTable = {".-","-...","-.-.","-..",".","..-.","--.",
		"....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
		".-.", "...","-","..-","...-",".--","-..-","-.--","--.."};
		String[] encodedMsg = new String[messages.length];
		int magicNumber = 97; // 'a' - 97 = [0] index in codeTable
		for (int i = 0; i < messages.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < messages[i].length(); j++) {
				int index = (int)messages[i].charAt(j) - magicNumber;
				sb.append(codeTable[index]);
			}
			encodedMsg[i] = sb.toString();
		}
		return encodedMsg;
	}
	
	public static int uniqueSearch(String[] messagesInMorse) {
		int count = 0;
		for (int i = 0; i < messagesInMorse.length; i++) {
			for (int j = i + 1; j < messagesInMorse.length; j++) {
				if (messagesInMorse[i].equals(messagesInMorse[j])) {
					count++;
				}
			}
		}
		return count;
	}
} 