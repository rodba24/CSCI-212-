/**
 * The abstract Date212List class provides common methods
 * for managing a linked list of Date212 dates.
 * This class defines a basic structure for a linked list
 * and implements methods for adding, removing, and searching
 * for elements within the list.
 * 
 * @author Rodba Khondoker
 */
public abstract class Date212List {

    // The first node in the linked list is a dummy node
    protected Date212Node first;

    // The last node in the linked list
    protected Date212Node last;

    // Number of items in the list
    protected int length;

    public Date212List() {
        first = new Date212Node(null);
        last = first;
        length = 0;
    }

    /**
     * The append method adds a new node to the list.
     * 
     * @param data A Date212 object to be added to the end of the list.
     */
    void append(Date212 data) {
        Date212Node newNode = new Date212Node(data);
        last.next = newNode;
        last = newNode;
        length++;
    }

    /**
     * Method to get the length of the linked list.
     * 
     * @return The length of the linked list.
     */
    public int getLength() {
        return length;
    }
}
