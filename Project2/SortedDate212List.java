/**
 * The SortedDate212List class is an extension of the Date212List
 * class with an add method that adds the nodes in order.
 * 
 * @author Rodba Khondoker
 */
public class SortedDate212List extends Date212List {

    public SortedDate212List() {

        super();
    }

    /**
     * Method to add a new node in order in the sorted list.
     * 
     * @param d: a new date
     */
    public void add(Date212 d) {
        Date212Node newNode = new Date212Node(d);

        if (first.next == null) {
            // List is empty, add the new node as the first element.
            first.next = newNode;
            last = newNode;
            length++;
        } else {
            Date212Node current = first.next;
            Date212Node previous = first;

            while (current != null && d.compareTo(current.data) >= 0) {
                previous = current;
                current = current.next;
            }

            previous.next = newNode;
            newNode.next = current;

            if (current == null) {
                // If the new node is added at the end, update the 'last' reference.
                last = newNode;
            }

            length++; // increment length
        }
    }
}
