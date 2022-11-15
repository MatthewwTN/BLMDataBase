/**
 * RecordList
 * ----------
 * RecordList is essentially an ArrayList of Records with a few sorting methods and
display methods added.
 * 
 * Matthew Negasi 
 * @author 
 */
public class RecordList extends ArrayList<Record>
{
    /**
     * RecordList
     * ----------
     * No Arg Constructor
     */
    public RecordList()
    {
        super();
    }

    /**
     * sortBy
     * ------
     * This sorts the Records by featureToSortBy.
     * This uses the Insertion Sort algorithm, since that one is stable
     * PRE: featureToSortBy describes one of the instance variables of at least one
    of the Records in the database,
     *      such that it is taken into account by that Record's compareToBy method.
     *      (If not, correct sorting is not guaranteed, but the program should not 
    crash.)
     * POST: the records in the database are sorted in ascending order by the 
    sorting criteria specified.
     */
    public void sortBy(String featureToSortBy){
        Node <Record> Curr = super.head; // Starting with the head value within the linked list 
        int count = 0; // Counter to keep track of how man elements there are

        while(Curr != null) {
            Node <Record>  Parent = super.head; // Holder value for the head so we dont lose it 
            if (count == 0) {
                Curr = Curr.next; // Simple shift if our count is = 0 
                super.head.next = null; // seperates the list to a sorted and unsorted side
                count++;
            }
            else if(Curr.getData().compareToBy(super.head.getData(),featureToSortBy) <= 0){ 
                // Comparing Curr with our Head, to see if it is less than
                Node <Record> temp= Curr.next;  // Temp variable for shifting to prevent a loss of data from a break in the chain
                Curr.next = super.head; 
                super.head = Curr;
                count ++;
                Curr = temp; // Setting Curr to the next value 
            }
            else {
                // if we get passed the first two conditions, we get to this last one.
                for(int i = 0; i < count - 1; i ++){ // Iteration to move our parent value up
                    if(Curr.getData().compareToBy(Parent.next.getData(),featureToSortBy) > 0){
                        Parent = Parent.next; // helps move the parent val over so we can shift properly
                    }
                    else{
                        break;
                    }
                }
                Node<Record> Temp = Parent.next; // 2 temp variables to help with the swap
                Node <Record> Temp2 = Curr.next;                   
                Parent.next = Curr; 
                Curr.next = Temp; 
                Curr = Temp2; 
                count++; // incrementing the count
            }
        }

    }

    /**
     * swap
     * ----
     * If you're gonna sort an ArrayList, 
     * you might need a way to swap the elements of our ArrayList by index.
     * PRE: indices refer to elements in the arrayList.
     * POST: elements at indices a and b will have swapped places (the memory 
    locations)
     */
    private void swap(int a, int b){
        // [OH NO! IT GOT ERASED!]
        // [EVEN IF YOU DON'T END UP USING THIS METHOD IN YOUR SORT, CREATE IT.]
        Node Pointer = super.head;

        int j = 0; 
        while( j < a ) {
            Pointer =   Pointer.next; // Pointer will hold the infor for the spot at int a
            j++;
        }

        int g = 0; 
        Node Pointer2  = super.head;
        while(g < b) {
            Pointer2 = Pointer2.next; // Pointer 2 will hold the information for the spot at int b
            g++; 
        }

        int m = 0; 
        Node Pointer3 = new Node(); 
        while( m < a ) {
            Pointer3 = Pointer3.next;
            m++;
        }
        Pointer3 = Pointer2; // Swapping b with a 

        int y = 0; 
        Node Pointer4 = new Node(); 
        while(y < b) {
            Pointer4 = Pointer4.next; 
            y++; 
        }
        Pointer4 = Pointer; // Swapping a with b 
    }

    /**
     * overwrite
     * ---------
     * This method overwrites the elements at index i with Record r,
     * so long as there is an element at index i.
     * PRE: there's an element at i
     * POST: overwrites element at i with r.
     */
    private void overwrite(int i,Record r){
        // [OH NO! IT GOT ERASED!]
        // [EVEN IF YOU DON'T END UP USING THIS METHOD IN YOUR SORT, CREATE IT.]
        int j = 0; 
        Node Pointer = super.head;
        while(j < i) {
            j++;
            Pointer = Pointer.next;
        }

        Pointer.setData(r); // replaces the data with the given value at r
    }

    /**
     * displayAllRecords
     * -----------------
     * This prints to the screen a nice representation of all the records in their 
    current order
     * Each record is on its own line.
     * PRE: none
     * POST: none.
     */
    public void displayAllRecords(){
        // [OH NO! IT GOT ERASED!]
        if(super.head == null){ // If the database is empty,  this will let the user know to import a file first.
            System.out.println("No records to display, this is an empty database. Please import a file first.");
        }

        Node pointer = super.head; 
        while(pointer != null) { // If the database isnt empty, this will print out every record there is.
            System.out.println(pointer.getData());
            pointer = pointer.next;
        }

    }

    /**
     * displayRecordsOfRecordType()
     * ----------------------------
     * This prints to the screen a nice representation of all the records in the 
    RecdordList 
     * whose recordType matches the parameter recType.  It displays them in their 
    current order.
     * Each record is on its own line.
     * PRE: r must be a recordType of at least some records, or else it will 
    display no records.
     * POST: none
     */
    public void displayRecordsOfRecordType(String recType){
        // This is basically a check, and it prevents the program from crashing, if the data base is empty, this will catch the null 
        // pointer exception, and notify the user that they cannot sort by these types.
        if(recType.equals("Movie") || recType.equals("Book") || recType.equals("Online")){
            try{
                Node Test = super.head;
                while(Test.next != null){
                    Test = Test.next;
                }
            }
            catch(NullPointerException e){
                System.out.println("Unable to display, this is an empty database."); // Print line to the user.
                return;
            }
        }

        if(recType.equals("Movie") || recType.equals("movie")){ 
            // If the list isnt empty, this will check for the recType
            // And it will print out all them movies, since the value passed in will be "Movie"
            Node Pointer = super.head; 
            while(Pointer.next != null) {
                if(Pointer.getData() instanceof Movie){ // using instance of to print only the movies 
                    System.out.println(Pointer.getData());
                }
                Pointer = Pointer.next; 
            }
            if(Pointer.next == null) {
            if(Pointer.getData() instanceof Movie){ // using instance of to print only the movies 
                    System.out.println(Pointer.getData());
                }
            }
        }

        if(recType.equals("Book") || recType.equals("book")){
            // If the list isnt empty, this will check for the recType
            // And it will print out all them movies, since the value passed in will be "Book"
            Node Pointer = super.head; 
            while(Pointer.next != null) {
                if(Pointer.getData() instanceof Book){ // using instance of to print only the books
                    System.out.println(Pointer.getData());
                }
                Pointer = Pointer.next; 
            }
            if(Pointer.next == null) {
            if(Pointer.getData() instanceof Book){ // using instance of to print only the books
                    System.out.println(Pointer.getData());
                }
            }
        }

        if(recType.equals("online") || recType.equals("Online")){
            // If the list isnt empty, this will check for the recType
            // And it will print out all them movies, since the value passed in will be "Online"
            Node Pointer = super.head; 
            while(Pointer.next != null) {
                if(Pointer.getData() instanceof OnlineRec){ // using instance of to print only the online resources.
                    System.out.println(Pointer.getData());
                }
                Pointer = Pointer.next; 
            }
            if(Pointer.next == null) {
            if(Pointer.getData() instanceof OnlineRec){ // using instance of to print only the online resources.
                    System.out.println(Pointer.getData());
                }
            }
        }
    }

}