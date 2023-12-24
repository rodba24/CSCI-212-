/**
 * The Date212 class defines a node to be used in a Date212List.
 * 
 * @author Rodba Khondoker
 */
class Date212Node {

    protected Date212 data;
    protected Date212Node next;

    /**
     * Constructs a Date212Node for the specified Date212 object.
     *
     * @param data A Date212 object to be stored in the node.
     */
    public Date212Node(Date212 d) {
        data = d;
        next = null;
    }
}