import java.io.*;

public class Exercise_4 {
	
	/* Created by James Harbison 
	 * This program reads an input from a .txt file and splits that text into individual words
	 * then the words are converted into Pig Latin and both the original word and the converted word 
	 * are displayed in tabular format
	 */

	public static void main(String[] args) {
		// initializes the file name for the input 
				String fileName = "Exercise4InputFile.txt";
				
				// initializes a string for the input taken from the file
				String fileInput= null;
				
				try {
					// initializes the file reader
					FileReader fileReader = new FileReader(fileName);
					
					// wraps the file reader in a buffered reader
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					
					// reads the text input from the file
					fileInput = bufferedReader.readLine();
				
					// closes the buffered reader
					bufferedReader.close();
					
					// Initializes string arrays to hold the words from the file input
					String[] words = fileInput.split(" ");
					String[] pigLatin = new String[words.length];
					
					
					for(int i = 0; i < words.length; i++) {
						
						// separates each word at the fist vowel after capitalizing each word
						String[] wordSeparator = words[i].toUpperCase().split("(?=[AEIOU])", 2);
						
						// combines the words into Pig Latin by placing the second part before the first part and adding AY
						if(wordSeparator.length == 2) {
							pigLatin[i] = wordSeparator[1] + wordSeparator[0] + "AY";
						}
						// if there is only one part adds WAY to the word to convert to Pig Latin
						else {
							pigLatin[i] = wordSeparator[0] + "WAY";
						}
					}
					
					// displays the original words and the newly converted Pig Latin words in tabular format
					for(int i = 0; i < words.length; i++) {
						System.out.println(words[i] + "\t" + pigLatin[i]);
					}
					
				}
				catch(FileNotFoundException ex) {
					System.out.println("Unable to open file '" + fileName + "'");
				}
				catch(IOException ex) {
					System.out.println("Error reading file '" + fileName + "'");
				}
		
	}
}
