import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * The SortedDate212List class represents a list of Date212 objects
 * that is automatically sorted when new dates are added.
 * It implements the Iterable interface, allowing iteration over the dates.
 * 
 * @author Rodba K.
 */
public class SortedDate212List implements Iterable<Date212> {
    //The internal ArrayList to store sorted dates.
    private ArrayList<Date212> sortedDatesList;

    /**
     * Constructs a SortedDate212List with an empty list of dates.
     */
    public SortedDate212List() {
        this.sortedDatesList = new ArrayList<>();
    }

    /**
     * Adds a Date212 object to the sorted list and maintains the sorted order.
     * 
     * @param d The Date212 object to be added.
     */
    public void add(Date212 d) {
        sortedDatesList.add(d);
        Collections.sort(sortedDatesList);
    }
    public boolean contains(Date212 d) {
        return sortedDatesList.contains(d);
    }

    /**
     * Gets a copy of the sorted list of Date212 objects.
     * 
     * @return A new ArrayList containing the sorted dates.
     */
    public ArrayList<Date212> getSortedDatesList() {
        return new ArrayList<>(sortedDatesList);
    }
    
   public SortedDate212List filterByYear(int year) {
    SortedDate212List filteredList = new SortedDate212List();

    for (Date212 date : sortedDatesList) {
        if (date.getYear() == year) {
            filteredList.add(date);
        }
    }

    Collections.sort(filteredList.sortedDatesList); // Sort the dates of the selected year

    return filteredList;
}


    /**
     * Returns an iterator over the sorted dates.
     * 
     * @return An iterator over the sorted dates.
     */
    @Override
    public Iterator<Date212> iterator() {
        return sortedDatesList.iterator();
    }
}
