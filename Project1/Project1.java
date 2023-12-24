import java.util.StringTokenizer;
/**
 * The Project1 class reads dates from a text file, creates Date212 objects from date strings,
 * and displays them using a GUI.
 */

public class Project1 {
    //file containing the dates
    public static String filename = "dates.txt";

    public static void main(String[] args) {
        // Read dates from the file into a String array
        String[] dateStringArray = inputFromFile(filename);
        int count= dateStringArray.length; 


        // Create a Date212 array for sorted dates
        Date212[] sortedDates = new Date212[dateStringArray.length];
        

        // Convert the date strings to Date212 objects and store them in sortedDates
        for (int i = 0; i < dateStringArray.length; i++) {
            try {
                sortedDates[i] = new Date212(dateStringArray[i]);
            } catch (IllegalArgumentException e) {
                System.out.println(dateStringArray[i] + " is not a valid date.");
            }
        } 

        // Sort the sortedDates array using selectionSort method
        selectionSort(sortedDates, sortedDates.length);

        // Create a DateGui instance to display the dates
        DateGui gui = new DateGui(dateStringArray, sortedDates, count);

    }

    // Reads the .txt file and creates Date212 objects
    public static String[] inputFromFile(String filename) {
      // method will read an inputed file and use the
      // StringTokenizer class to read all the dates
      int counter = 0;
      int tokenCounter = 0;
      TextFileInput in = new TextFileInput(filename);
      String line = in.readLine();
      while (line != null) { 
         // counts the amount tokens in file
         StringTokenizer token = new StringTokenizer(line, ",");
         tokenCounter += token.countTokens();
         line = in.readLine();
      } 
      
      String[] dates = new String[tokenCounter];
      TextFileInput file = new TextFileInput(filename);
      String line2 = file.readLine();
      
      while (line2 != null) { 
         // takes each token on a given line and puts it in a string array
         StringTokenizer token2 = new StringTokenizer(line2, ",");
         while (token2.hasMoreTokens()) {
            // Get the next token 
            dates[counter++] = token2.nextToken();
            // Store the token in the 'dates' array at the current position indicated by 'counter'
         } 
         line2 = file.readLine(); //// Read the next line from the file
      } 
      
      return dates;
   } // close readFile


    // Selection sort algorithm using Date212's compareTo method to sort the dates
    private static void selectionSort(Date212[] array, int length) {
    for (int i = 0; i < length - 1; i++) {
        int indexLowest = i;
        for (int j = i + 1; j < length; j++) {
            if (array[j] != null && array[indexLowest] != null) {
                // Compare Date212 objects using the compareTo method in Date212 class
                if (array[j].compareTo(array[indexLowest]) < 0) {
                    indexLowest = j;
                }
            }
        }
        // If a smaller element was found, swap it with the current element
        if (indexLowest != i) {
            Date212 temp = array[indexLowest];
            array[indexLowest] = array[i];
            array[i] = temp;
        }
    }
}


}

