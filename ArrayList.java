/**
 * A LinkedList , but we call it a Quack.
 *
 * @author (Matthew Negasi)
 * @version (2/21/2022)
 */
public class ArrayList<T>  
{
    public Node<T> head;

    /**
     * ArrayList 
     * ------
     * No Arg Constructor for Instantiation
     */
    public ArrayList()
    {

    }

    /**
     * protected insert()
     * ------------------
     * Parameters ( Object data , int index  ) 
     * Pre: index > 0 
     * Post: Adds object to the linked list (next available spot).
     * 
     */
    protected void insert ( T newData , int index) {  
        Node newNode = new Node(newData);
        if(index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        }
        // Tracking to make sure the index is in bounds
        int tracker = 1; 
        Node Pointer = this.head;
        while(Pointer.next != null) {
            tracker ++;
            Pointer = Pointer.next; 
        }
        if(index > tracker) { // Invariant
            System.out.println("This index is out of bounds, too large, please re-enter a valid index.");
            return;
        }

        if(index < 0) { // Invariant
            System.out.println("Enter in a valid index, greater or equal to zero.");
            return;
        }

        if(index == 0) { // if the Quack is empty  add to the head
            this.head = newNode;
        }

        else if (tracker ++ == index ) // if the user plans to add to the next spot, first we need to create it
        {
            Node Pointer2 = this.head;
            while(Pointer2.next != null) {
                Pointer2 = Pointer2.next;    
            }
            Pointer2.next = newNode;
        }

        else // If the user adds in between or anywhere else thats in bounds, transition to the final else statement
        {
            if(index <= tracker) {
                int i = 0; 
                Node Pointer3 = this.head; 
                while( i < index-1 ) {
                    Pointer3 = Pointer3.next;
                    i++;
                }
                newNode.next = Pointer3.next.next;
                Pointer3.next = newNode; 
            }
        }
    }

    /**
     * protected Remove () 
     * -------------------
     * Parameters ( int index )
     * Pre: Index > 0 and within the length of the linked list 
     * Post: Removes the object within the given index  
     */
    protected Object remove (int index){
        if(index == 0) {  // If the index is one, just change the head over to the next
            Node returnVal = this.head;
            head = head.next;
            return returnVal.getData();
        }

        if(index < 0) { // Invariant 
            return "Youre index is below zero, choose a plausible number please."; 
        }
        int tracker = 1; 
        Node Pointer = head;
        Node returnVal = null;

        while(Pointer.next != null) { // Using a tracker to make sure the index is in bounds
            tracker ++;
            Pointer = Pointer.next; 
        }

        if(index > tracker) { // if greater, say its out of bounds
            return "Your desired index is out of bounds, please try again."; 
        }
        if(head == null) {
            return "Empty List, nothing to return.";
        }

        if(index <= tracker) { // if its in bounds, go through our list and find it, then remove and return the objects data
            int i = 0;
            Node Pointer2 = head; 
            while( i < index - 1) { 
                Pointer2 = Pointer.next; 
                i++;
            }   
            returnVal = Pointer2.next;
            Pointer2.next = Pointer2.next.next; 
        }

        return returnVal.getData();
    }

    /**
     * protected append()
     * ------------------
     * Parameters(Object data)
     * Pre: Object input
     * Post: Adds the Object to the back of the "line",  the next available spot.
     */
    protected void append(T newData) {
        Node newNode = new Node(newData); // This is the data from the object being created within a node
        if(head == null) { // if the head is null  just set the head to the newNode
            head = newNode; 
            return;
        }
        // Simply adding to the back of the Linked list
        Node Pointer2 = head;
        while(Pointer2.next != null) {
            Pointer2 = Pointer2.next;    
        }
        Pointer2.next = newNode;

    }

    /**
     * protected delete()
     * -----------------
     * Parameters(int index) 
     * Pre : index > 0
     * Post: Deletes the link within the given index. 
     */
    protected void delete (int index) {
        if(index < 0) {
            System.out.println("Please enter an index greater than 0."); 
            return; 
        }
        if(index == 0) {
            head = head.next;
            return;
        }

        int tracker = 1; 
        Node Pointer = this.head;
        Node returnVal = null;
        // Using the tracker to make sure the index is in bounds
        while(Pointer.next != null) {
            tracker ++;
            Pointer = Pointer.next; 
        }

        if(index > tracker) { //Invariants
            System.out.println("Please enter an in-bounds index.");
            return;
        }

        if(this.head == null) { // if our head is null return a String to the user
            System.out.println("Nothing to remove, list is empty!");
        }

        if(index <= tracker) { // if not go through the linked list, and find the object at the index and remove it
            int i = 0;
            Node Pointer2 = this.head; 
            while( i < index - 1) {
                Pointer2 = Pointer.next; 
            }   
            returnVal = Pointer2.next;
            Pointer2.next = Pointer2.next.next; 
        }

    }

    /**
     * protected get()
     * --------------
     * Parameters (int index)
     * Pre: index > 0
     * Post: Returns the Object within the given index. 
     */
    protected T get(int index){
        if(index == 0) {
            return head.getData();
        }
        // using a tracker to make sure our index is in bounds
        int tracker = 1;
        Node<T> Pointer = this.head;
        Node<T> returnVal = null;
        while(Pointer.next != null) {
            tracker ++;
            Pointer = Pointer.next; 
        }

        if(index <= tracker) { // if our index is in bounds go through the linked list, and find the object at the proper index
            int i = 0;
            Node<T> Pointer2 = this.head; 
            while( i < index - 1) {
                Pointer2 = Pointer2.next; 
                i++;
            }   
            
            if(i == index - 1){
            Pointer2 = Pointer2.next; 
            return Pointer2.getData();
            }
            
            returnVal = Pointer2.next;
            Pointer2.next = Pointer2.next.next; 
        }
        else {
            System.out.println("Cant return anything. Object not found!"); 
            return null;
        }

        return returnVal.getData(); // returning the data within the object
    }

    /**
     *  Size()
     * ---------------
     * Pre: None. 
     * Post: Returns the size of the ArrayList, (How long the linked list is.) 
     */
    public int size(){
        if(this.head == null) {
            return 0;
        }
        int sizeTrack = 1; 
        Node<T> Pointer = this.head; 
        while(Pointer.next != null) {
            Pointer = Pointer.next; 
            sizeTrack ++; // Tracking the size with the int variable
        }

        return sizeTrack; // returning the size
    }

    /**
     *  toString()
     * -------------------
     * Pre: None
     * Post: Returns the String concatenation of all the data within the list.
     */
    public String toString(){
        String s = "";
        Node<T> Pointer = this.head; 
        try{
            
            while(Pointer.next != null) {
                s+= Pointer.getData() + ","; // String Concatentation
                Pointer = Pointer.next;
            }
            s+= Pointer.getData();

        }
        catch(NullPointerException e) {
            System.out.println("This is an empty ArrayList..."); // Catching the null exception and printing a message to the user
        }
        return s;
    }

    /**
     * isEmpty()
     * --------
     * Pre: None. 
     * Post: returns True or False to weather the quack is empty
     * 
     */
    public boolean isEmpty(){
        return head == null; // Simply check if its null or not
    }

    /**
     * indexOf()
     * ---------
     * Parameters(Object target) 
     * Pre: Takes in the Object
     * Post: Returns the index at which the Object resides.
     */
    protected int indexOf(T target) {
        if(this.head.next == null) {
            if(this.head.getData().equals(target)){
                return 0;
            }
        }

        int index = 1; // using a tracker to return the proper int
        Node <T> Pointer = this.head; 
        while(Pointer != null) {
            if(Pointer.getData().equals(target)){
                return index-1; // returning the proper index            
            }
            index ++; 
            Pointer = Pointer.next;
        }

        int sizeTrack = 1; 
        Node <T> Pointer2 = head; 
        while(Pointer2.next != null) {
            Pointer2 = Pointer2.next; 
            sizeTrack ++; // Tracking the size with the int variable
        }

        if(index == sizeTrack){
            return - 1; // Basically means we couldnt find the object
        }

        return index;
    }

    /**
     * equals()
     * ---------
     * Parameters(Object other) 
     * Pre: An Object, preferabbly a ArrayList
     * Post: Returns T/F on whether the Object is identical to the ArrayList or not.
     */
    public boolean equals(Object other){
        if(other == null) {
            return false; 
        }
        else if(this.getClass() != other.getClass()) 
            return false; 

        else{ 
            ArrayList that = (ArrayList)other; 

            Node<T> thisPointer = this.head; 
            Node<T> thatPointer = that.head; 

            while(thisPointer != null && thatPointer != null) {
                if(thisPointer.getData() != thatPointer.getData()) {
                    return false; // if it finds one piece of data that is not equal than we return false;
                }
                else{
                    thisPointer = thisPointer.next; // this scales them up
                    thatPointer = thatPointer.next;
                }
            }

            if(thatPointer == null && thisPointer == null){ // if they both get to null, that means they are equal
                return true; 
            }
        } 
        return false; 
    }
}

