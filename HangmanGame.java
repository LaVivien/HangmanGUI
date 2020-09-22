package project1;

import java.util.*;

public class HangmanGame {
	 // Java Keywords
	 public static final String[] wordPool = {
			 "communication",
			 "science",
			 "programming",
			 "language",
			 "difficulty",
			 "artificial",
			 "intelligence",
			 "attempts",
			 "screenshot",
			 "baseball",
			 "windows",
			 "learning",
			 "electronics",
			 "beautiful",
			 "internet",
			 "database",
			 "organization",
			 "application",
			 "network",
			 "friendly",
			 "validation",
			 "attempts",
			 "statistics",
			 "physics",
			 "chemistry",
			 "engineering",
			 "school",
			 "industry",
			 "revolution",
			 "progress",
			 "characters",
			 "heavily",
			 "graphics"

	 };

	 public static final Random RANDOM = new Random();
	 public static final int MAX_LEVEL = 5;
	 private String wordToFind="";
	 private char[] wordFound;
	 private int errorCount;
	 private ArrayList <String> letters = new ArrayList < > ();
	 public boolean reset=false;

	 // Method returning randomly next word to find
	 private String nextWordToFind() {
		 return wordPool[RANDOM.nextInt(wordPool.length)];
	 }
	 
	 public String getWord() {
		 return wordToFind;
	 }
	 
	 public void resetWord() {
		 wordToFind="";
		 reset=true;
	 }
	 
	 public int getErrorCount(){
		 return errorCount;
	 }
	 
	 public String getProgress() {
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<wordFound.length;i++)
			 sb.append(wordFound[i]);
		 return sb.toString();
	 }

	 // Method for starting a new game
	 public void newGame() {
		 errorCount = 0;
		 letters.clear();
		 wordToFind = nextWordToFind();
		 reset=false;
		 System.out.println(wordToFind);

		 wordFound = new char[wordToFind.length()];
		 for (int i = 0; i < wordFound.length; i++) {
			 wordFound[i] = '_';
		 }
	 }
	 
	 public void pressKey(String c) {
		 if (!letters.contains(c)) {
			 if (wordToFind.contains(c)) {
				 int index = wordToFind.indexOf(c);
				 while (index >= 0) {
					 wordFound[index] = c.charAt(0);
					 index = wordToFind.indexOf(c, index + 1);
				 }
			 } else {
				 errorCount++;
			 }
			 letters.add(c);
		 }
	 }

	 public boolean wordFound() {
		 return wordToFind.contentEquals(new String(wordFound));
	 }
	 
	 public String wordString() {
		 StringBuilder builder = new StringBuilder();
		 for (int i = 0; i < wordFound.length; i++) {
			 builder.append(wordFound[i]);
			 if (i < wordFound.length - 1) {
				 builder.append(" ");
			 }
		 }
		 return builder.toString();
	 }
}
