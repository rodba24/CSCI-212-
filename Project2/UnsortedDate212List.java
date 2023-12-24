/**
 * The UnsortedDate212List class is an extension of the Date212List class with an add method that appends nodes to the list.
 * 
 * @author Rodba Khondoker
 */
public class UnsortedDate212List extends Date212List {

    public UnsortedDate212List() {
        super();
    }

    /**
     * Method to add a new date to the unsorted linked list.
     * 
     * @param c: A Date212 object to be added to the unsorted list.
     */
    public void add(Date212 c) {
        append(c);
    }
}
