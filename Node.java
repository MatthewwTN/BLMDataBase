
/**
 * The piece of the linked list.
 *
 * @author (Matthew Negasi)
 * @version (2/15/2022)
 */
public class Node <T1>
{
    // instance variables - replace the example below with your own
    
    public Node <T1> next; // the next memory location 
    private T1 data; // the data being held within the node

    /**
     * Node()
     * ------
     * No Arg Constructor.
     */
    public Node()
    {  
        
    }

    /**
     * Node(T1 Val) 
     * -----------
     * Pre: None
     * Post: Instantiates the Node, and takes in the data value.
     * 
     */
    public Node(T1 val) {
    this.data = val;
    this.next = null;
    }
    
    /**
     * Node(T1 Val, Node Next)
     * ----------------------
     * Pre: None
     * Post: Takes in the data value, and the next link (Node) to build a linked list.
     */
    public Node(T1 data, Node next) {
    this.data = data; 
    this.next = next;
    }
    
    /**
     * setData()
     * ---------
     * Changes the data value within the node to the value passed in the parameter.
     */
    public void setData(T1 val) {
    this.data = val;
    }
    
    /**
     * getNext()
     * ----------
     * Returns the value of the next link (Memory location within the linked list).
     */
    public Node getNext(){
    return this.next;
    }

    /**
     * getData()
     * ----------
     * Returns the data value within the data element.
     */
    public T1 getData(){
    return data; 
    }
    
    /**
     * setNext()
     * ---------
     * Allows you to set the "next" location of the node to point to a new location.
     */
    public void setNext(Node next){
    this.next = next; 
    }
    
    
}
