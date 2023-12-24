import java.util.ArrayList;
import java.util.Iterator;

/**
 * The UnsortedDate212List class represents a list of Date212 objects
 * that maintains the order in which dates are added.
 * It implements the Iterable interface, allowing iteration over the dates.
 * 
 * @author Rodba K.
 */
public class UnsortedDate212List implements Iterable<Date212> {
    // The internal ArrayList to store unsorted dates. 
    private ArrayList<Date212> unsortedDatesList;

    /**
     * Constructs an UnsortedDate212List with an empty list of dates.
     */
    public UnsortedDate212List() {
        this.unsortedDatesList = new ArrayList<>();
    }

    /**
     * Adds a Date212 object to the unsorted list.
     * 
     * @param d The Date212 object to be added.
     */
    public void add(Date212 d) {
        unsortedDatesList.add(d);
    }

    /**
     * Gets a copy of the unsorted list of Date212 objects.
     * 
     * @return A new ArrayList containing the unsorted dates.
     */
    public ArrayList<Date212> getUnsortedDatesList() {
        return new ArrayList<>(unsortedDatesList);
    }

    /**
     * Returns an iterator over the unsorted dates.
     * 
     * @return An iterator over the unsorted dates.
     */
    @Override
    public Iterator<Date212> iterator() {
        return unsortedDatesList.iterator();
    }
}
