import java.awt.GridLayout;
import javax.swing.*;

/**
 * The Date212GUI class displays unsorted and sorted date lists in a GUI
 * It creates a window with two sections, one for unsorted dates
 * and the other for sorted dates.
 *
 * @author Rodba Khondoker
 */

public class Date212GUI {

    // Construct a DateGui object with unsorted and sorted date lists and display
    // them in a GUI.

    public Date212GUI(UnsortedDate212List unsortedList, SortedDate212List sortedList) {
        createAndShowGUI(unsortedList, sortedList);
    }

    /**
     * @param unsortedList
     * @param sortedList
     */
    private static void createAndShowGUI(UnsortedDate212List unsortedList, SortedDate212List sortedList) {
        // Create and set up the window.
        JFrame frame = new JFrame("Project 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Width, height
        frame.setLocation(200, 200);
        frame.setLayout(new GridLayout(1, 2));

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        textArea.setText("Unsorted Dates: " + "\n\n");

        // Loop to go through the unsorted list and display the dates
        Date212Node currentUnsorted = unsortedList.first.next;
        while (currentUnsorted != null) {
            textArea.append(currentUnsorted.data.toString() + "\n");
            currentUnsorted = currentUnsorted.next;
        }

        JTextArea textArea2 = new JTextArea(10, 20);
        textArea2.setEditable(false);
        frame.getContentPane().add(textArea2);
        textArea2.setText("Sorted Dates: " + "\n\n");

        // Loop to go through the sorted list and display the dates
        Date212Node currentSorted = sortedList.first.next;
        while (currentSorted != null) {
            textArea2.append(currentSorted.data.toString() + "\n");
            currentSorted = currentSorted.next;
        }

        // Display the window.
        frame.setVisible(true);
    }
}
