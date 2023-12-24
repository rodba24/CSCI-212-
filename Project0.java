import javax.swing.JOptionPane;

public class Project0 {

	public static void main(String[] args) {
		// Declare variables to store user input and character counts
		String inputWord;
		int countLower = 0, countUpper = 0;
		
		// Start an infinite loop to repeatedly prompt the user
		while (true) 
		{
			// Prompt the user to enter a sentence
			inputWord = JOptionPane.showInputDialog(null, "Please enter a sentence: ");
			// Check if the entered sentence is "STOP" (case-insensitive)
			if (inputWord.equalsIgnoreCase("STOP"))
				System.exit(0); // exit if true 

			// Iterate through each character in the entered sentence
			for (int i = 0; i < inputWord.length(); i++) 
			{

				if (inputWord.charAt(i) == 'e')
					countLower++; // If current char is e then increment the count for lower case e
				else if (inputWord.charAt(i) == 'E')
					countUpper++; // If the current char is E then increment for upper case E
			}
			// Display the counts of lower case e and upper case E
			JOptionPane.showMessageDialog(null,
					"Number of lower case e's: " + countLower + "\n" + 
					"Number of upper case E's: " + countUpper);
			// Reset the count variables for the next sentence
			countLower = 0;
			countUpper = 0;
		}
	}
}
