package LA1Q1;

public class Node <T> {
    private T element; // Private field for the element
    private Node <T> next; // Private field for the next


    public Node(){ // Empty constructor

    }

    public  Node(T element, Node<T> next) { // Constructor defining element as element and next as next
       this.element = element;
       this.next = next;
    }

    public Node<T> getNext() { // Method to get the "next" value
        return next;
    }

    public T getElement() { // Method to get the element value
        return element;
    }

    public void setNext(Node<T> n) { // Setting next value to a variable
       next = n;
    }
}
