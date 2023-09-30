package LA1Q1;

public class SinglyLinkedList<T> {
    // Private Fields
    private Node<T> head;
    private Node<T> tails;
    private int size = 0;

    // Method for SinglyLinked List
    public SinglyLinkedList(Node<T> head, Node<T> tails, int size) {
        this.head = head;
        this.tails = tails;
        size = 0;

    }
    // Empty Method for SinglyLinked List
    public SinglyLinkedList() {
        size = 0;

    }
    // Getter method for Size
    public int getSize() {
        return size;
    }
    // Method to check if list is empty, if it is returns true, if not returns false
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString () {
       String result = "["; // Assigning a String value to result which equals to "[" which indicates the start of the list
       Node<T> current = head; // Assigning current the value of head
       while(current != null){ // While Loop for current to loop through the list till it reaches null, the end of the list
           result = result + current.getElement(); // Adding the elements to the list as a String using current.getElement()
           if(current.getNext() != null){ // Checks if the next value is not null and adds a ", " each time till it reaches the end of the list
               result = result + ", ";
           }
           current = current.getNext(); // Checks the next value and stores it in the current value, once it reaches null the While Loop will break
       }
       return result + "]"; // End bracket of the list
    }


    public void addFirst(T t) { // Method to add t to the front of the list (Adding to Head)
        head = new Node<>(t, head); // adds element t to the front of the list
        if (size==0)
            tails = head; // in the case if list size is 0, the node becomes tails too
        size++;
        }

    public void addLast(T t) { // Method to add t to the last of the list (Adding to Tail)
        Node<T> newest = new Node<>(t, null); // adds element t to the last
        if (isEmpty()) {
            head = newest; // in the case if list is empty
            tails = newest;
        }
        else
            tails.setNext(newest); // setting newest as the tail
            tails = newest; // new node becomes tail
        size++;

    }

    public T removeFirst() { // Remove from head
        if (isEmpty())
            return null; // if list is empty return null
        T answer = head.getElement(); // assigning the value of answer to the  element
        head = head.getNext(); // assigning head value to the next
        size--; // delete statement
        if (size == 0)
            tails = null; // if statement in the scenario the list is zero
        return answer;
    }

    public T removeLast() { // Remove from tail
        T removeLastFunction = tails.getElement(); // gets the element that has the value of tails
        if (isEmpty())
            return null; // case if the list is empty, returns null

        Node<T> current = head; // current is assigned head, it can go through the list in the while loop below
        Node<T> previous = head; // previous is assigned null so it can be the new tails

        while (current.getNext() != null) { // while loop runs till it does not equal null
            previous = current; // assigns previous to the value of current
            current = current.getNext(); // assigns the next value to current
        }
        previous.setNext(null); // once the loop breaks, we have identified our new tail and assign its next value to null
        tails = previous; // assigning tail value to previous
        size--; // deletes the old tails
        return removeLastFunction;
    }

    public void pushAtHead(T element) { // A stack method to add an object at the Head (front of the line)
        addFirst(element);
    }

    public T popFromHead() {// A stack method to remove an object at the Head (front of the line)
        return removeFirst();

    }
    public void pushAtTail(T element){ // A stack method to add an object at the Tail (end of the line)
        addLast(element);
    }

    public T popFromTail() { // A stack object to remove an object at the Tail (end of the line)
       return removeLast();

    }
    public void enqueueAtTail(T element){ // A queue method to add an object to the Tail (end of the line)
        addLast(element);
    }
    public T dequeueAtHead(){ // A queue method to remove an object from the Head (front of the line)
        return removeFirst();
    }

    public int searchStack(T element){
        Node <T> current = head; // making current the value of head (start of the list so we can use our while loop to loop thru the list)
        int index = 1; // setting index value as 1

        while(current!= null){ // while loop to loop start of the list
           if(current.getElement() == element){ // if the element currently displayed is equal to the element we return its index
               return index;
           }
           index++; // incrementing
           current = current.getNext(); // getting next value till it reaches null
        }
        return 0; // if the list is empty, will return 0
    }
}









