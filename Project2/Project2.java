import java.util.*;

/**
 * The Project2 class reads dates from an input file, creates Date212 objects
 * from date strings,
 * and displays them using a GUI. It sorts and displays the dates in both
 * unsorted and sorted orders.
 * Invalid date formats in the input file are also handled and displayed to the
 * console.
 * 
 * @author Rodba Khondoker
 */
public class Project2 {
    public static TextFileInput inputFile;
    public static Date212[] allDates;
    public static int dateCount;

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnsortedDate212List unsortedList = new UnsortedDate212List();
        SortedDate212List sortedList = new SortedDate212List();
        String myFile = "input.txt"; // Replace with the actual input file path.
        inputFile = new TextFileInput(myFile);
        allDates = new Date212[100]; // Adjust the array size as needed.
        dateCount = 0;

        // Fill up the allDates array
        fillArray(inputFile);

        // Read from the array and add dates to the two linked lists
        for (int i = 0; i < dateCount; i++) {
            Date212 d = allDates[i];
            unsortedList.add(d);
            sortedList.add(d);
        }

        // Display the two linked lists
        new Date212GUI(unsortedList, sortedList);
    }

    /**
     * Method to read dates from the input file, validate them, and populate the
     * date details array.
     *
     * @param input The TextFileInput used to read date values from the input file.
     */
    public static void fillArray(TextFileInput input) {
        String line = input.readLine();
        while (line != null) {
            StringTokenizer dateTokens = new StringTokenizer(line, ",");
            while (dateTokens.hasMoreTokens()) {
                String dateStr = dateTokens.nextToken();
                if (dateStr.length() == 8) {
                    try {
                        Date212 d = new Date212(dateStr);
                        allDates[dateCount++] = d;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date format: " + dateStr);
                    }
                } else {
                    System.out.println("Invalid date format: " + dateStr);
                }
            }
            // Read the next line
            line = input.readLine();
        }
    }
}
