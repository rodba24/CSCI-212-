import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * The Date212GUI class includes a JFrame with a file menu
 * and displays unsorted and sorted lists of dates.
 * 
 * @author Rodba Khondoker
 */
public class Date212GUI extends JFrame {

    private JFrame jframe;
    private JList<String> unsortedList; 
    private JList<String> sortedList;
    private JMenuBar menuBar;
    private JMenu menu;
    private DefaultListModel<String> unsortedListModel; 
    private DefaultListModel<String> sortedListModel; 
    private UnsortedDate212List unsortedL = new UnsortedDate212List();
    private SortedDate212List sortedL = new SortedDate212List();
    private JMenu editMenu;

    /**
     * Constructs a Date212GUI object.
     * Initializes the GUI components and sets up the frame.
     */
    public Date212GUI() {
        // Frame
        jframe = new JFrame("Project 3");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(600, 600);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        // Layout
        GridLayout layout = new GridLayout();
        layout.setColumns(2);
        layout.setRows(1);
        jframe.setLayout(layout);

        // File Menu
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        editMenu = new JMenu("Edit");

        // File Menu Handler
        FileMenuHandler fmh = new FileMenuHandler(this);
        EditMenuHandler emh = new EditMenuHandler(this);

        // MenuBar - Create and Add Menu Items
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(fmh);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(fmh);
        JMenuItem searchItem = new JMenuItem("Search"); // Search menu item
        searchItem.addActionListener(emh);

        menu.add(openItem);
        menu.addSeparator();
        menu.add(quitItem);
        editMenu.add(searchItem);

        // Left Side - Unsorted Dates
        unsortedListModel = new DefaultListModel<>();
        unsortedListModel.addElement("Unsorted");

        // Right Side - Sorted Dates
        sortedListModel = new DefaultListModel<>();
        sortedListModel.addElement("Sorted");

        // Add models to List
        unsortedList = new JList<>(unsortedListModel);
        sortedList = new JList<>(sortedListModel);

        // Add all elements to frame
        menuBar.add(menu);
        menuBar.add(editMenu);
        jframe.setJMenuBar(menuBar);
        jframe.add(unsortedList);
        jframe.add(sortedList);

        // Show/Enable Frame
        jframe.setVisible(true);
    }

    public void addToUnsortedList(Date212 date) {
        unsortedL.add(date);
    }

    public void addToSortedList(Date212 date) {
        sortedL.add(date);
    }

    /**
     * Populates the unsorted model with the given date list.
     *
     * @param dateList The unsorted date list.
     * @param list     The default list model to be populated.
     */
    public void populateUnsortedModel(UnsortedDate212List dateList, DefaultListModel<String> list) {
        for (Date212 date : dateList) {
            list.addElement(date.toString());
        }
    }

    /**
     * Populates the sorted model with the given date list.
     *
     * @param dateList The sorted date list.
     * @param list     The default list model to be populated.
     */
    public void populateSortedModel(SortedDate212List dateList, DefaultListModel<String> list) {
        for (Date212 date : dateList) {
            list.addElement(date.toString());
        }
    }
   
    public void filterByYear(int year) {
        // Clear existing list models
        unsortedListModel.clear();
        sortedListModel.clear();

        // Filter and add dates to unsorted list
        for (Date212 date : unsortedL.filterByYear(year)) {
            unsortedListModel.addElement(date.toString());
        }

        // Filter and add dates to sorted list
        for (Date212 date : sortedL.filterByYear(year)) {
            sortedListModel.addElement(date.toString());
        }
    }

    /**
     * Populates both unsorted and sorted lists.
     */
    public void populateLists() {
        populateUnsortedModel(unsortedL, unsortedListModel);
        populateSortedModel(sortedL, sortedListModel);
    }
}
