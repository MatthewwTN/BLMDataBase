/**
 * Book
 * ----
 * This class holds a record of a book.
 * This record includes the name of the book 
 * A short description about the book
 * The author and creator of the book 
 * As well as the year the book was made public / released.
 * 
 * It also extends from the Record class which implements the compareToByInterface, which essentailly allows it to be comparable
 * with other classes that inherit from record, or implement the compareToBy interface.
 * Matthew Negasi
 * @author 
 */
public class Book extends Record
{
    public String name;
    public String description;
    public String author;
    public int year;

    /**
     * Book()
     * ------
     * No Arg Constructor
     */
    public Book()
    {
        // initialise instance variables
        super("Book", "unNamed Book","blank description" );
        this.author = "UnNamed author";
        this.year = 2021;
        this.name = "unNamed Book";
    }

    /**
     * public Book() 
     * ------------
     * Constructor: With 4 parameters ( String Title , String Description, String Author, and Int Year). 
     * Pre: year > 1000, and < 2021.
     * Post: Initializes a valid Book Object. 
     * 
     */
    public Book(String title, String description, String author, int year)
    {

        super("Book", title, description ); // Caling super to initialize that this is a Record that is a Book 
        this.author = author;
        if (year < 1000 || year > 2021) year = 2021;
        else this.year = year;
        this.name = title;
    }

    /**
     * compareToBy
     * -----------
     * This method will compare this to other using the attribute specified by attributeToCompareBy.
     * A negative number is returned if this < other when comparing their respective attributeToCompareBy.
     * A 0 is returned if this = other with respect to attributeToCompareBy
     * a positive number is returned if this > other with respect to their attributeToCompareBy
     * So for example, if attributeToCompareBy is "Name", then 
     *              (assuming that both this and other have an attribute called 'Name')
     * if this.Name < other.Name, we'll return -1
     * if this.Name = other.Name, we'll return 0
     * if this.Name > other.Name, we'll return 1
     * PRECONDITION: Both this and other have the attribute specified by attributeToCompareBy.  
     *               If this has the attribute, but other does not, return a negative number.
     *               If this doesn't have the attribute, return a positive number.
     *               If neither has the attribute, return 0;
     *               This strategy will make it so that the items that DO have the attributeToCompareBy
     *               will end up at the beginning of a sorted list.
     *               other must be a Record. If not, we'll return 0;
     * POSTCONDITION: Neither this nor other is changed in any way. An integer is returned     
     */
    @Override public int compareToBy(Record other, String attributeToCompareBy){
        // [OH NO! IT GOT ERASED!]
        if(other.getRecordType().equals("Movie")){ // the Rec type determines the type of casting that will be done.
            Record otherMovie = new Movie(); // Casting to make the Record into a comparable object 
            otherMovie = other;
            Movie that = (Movie) otherMovie;
            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetic check, to see which name comes first.
            }

            if(attributeToCompareBy.equals("year")){
                // Comparing the year 
                if(this.year == that.year){
                    return 0; // if the years are equal this will return 0
                }
                if(this.year > that.year){
                    return 1; // if the year for the book is greater than the movie, it will return 1
                }
                if(this.year < that.year){
                    return -1; // if it is less than that of the movie it will return -1
                }
            }

            if(attributeToCompareBy.equals("description")){
                // I decided to compare the description length, if that is the feature to compare by
                if(this.getDescription().length() > that.getDescription().length()){
                    // if a book has a bigger description than the movie, we return 1
                    return 1;
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if they are equal then 0 
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if the books description is less in length to the movie, this will return -1 
                }
            }

            if(attributeToCompareBy.equals("director")){
                return 1;// Books do not have a director to compare with in concern to movies, so this will return 1
            }
            if(attributeToCompareBy.equals("author")){
                return -1; // Movies do not have authors, so this will return - 1
            }

            if(attributeToCompareBy.equals("recordType")){
                return -1; // Books will be first when comparing the type to a movie, so this returns -1
            }
        }

        if(other.getRecordType().equals("Online")){
            Record otherOnline = new OnlineRec(); // Casting the Record into an actual object that can be compared
            otherOnline = other;
            OnlineRec that = (OnlineRec) otherOnline;
            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // alphabetic check
            }

            if(attributeToCompareBy.equals("description")){
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the book has a longer description than the online source, we return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if equal than 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1;  // if less than - 1
                }
            }
            
            
            if(attributeToCompareBy.equals("websiteURL")){
                return 1; // Books dont have the websiteURL Feature, so this will return 1
            }
            if(attributeToCompareBy.equals("author")){
                return -1; // online rec doesnt have an author returns -1
            }
            if(attributeToCompareBy.equals("year")){
                return -1;  // online rec do not have a year either , so returns - 1
            }
        

            if(attributeToCompareBy.equals("recordType")){
                return -1; // this helps settle the sort by type. books will be first in comparison to online resources
            }
        }

        if(other.getRecordType().equals("Book") || other.getRecordType().equals("book")){
            Record otherBook = new Book();
            otherBook = other; 
            Book that = (Book) otherBook;
            // Casting in order to create an object that will allow an actual comparison

            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetic check
            }

            if(attributeToCompareBy.equals("author")){
                return this.author.compareTo(that.author); // Alphabetic check
            }

            if(attributeToCompareBy.equals("year")){

                if(this.year == that.year){
                    return 0; // if both years are equals this returns 0
                }
                if(this.year > that.year){
                    return 1; // If this year is greater than that of which it is being compared to we return 1
                }
                if(this.year < that.year){
                    return -1; // if this year is less than that of which it is being compared to we return - 1
                }
            }

            if(attributeToCompareBy.equals("description")){ 
                // I decided to compare by description length, since it would be a noticebale difference.
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the book length is greater than the casted book, it will return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if equal than 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if less than - 1 
                }
            }

        }

        return 0; // Returns zero if neither have the features.
    }

    /**
     * getName
     * -------
     */
    public String getName(){
        return this.name; // returns the name of the book. 
    }

    /**
     * getAuthor
     * ---------
     */
    public String getAuthor(){
        // [OH NO! IT GOT ERASED!]
        return this.author; // returns the author of the book.
    }

    /**
     * getYear
     * -------
     */
    public int getYear(){
        // [OH NO! IT GOT ERASED!]
        return this.year; // returns the year the book was released.
    }

    /**
     * toString
     * --------
     * This provides a nice looking String representation of this particular Record
     * PRE: none
     * POST: current object is unchanged. A String is returned.
     */
    public String toString(){
        return this.identifier + " (" + this.year + "), written by " + this.author + ": \n" + niceLookingDescription()+ "\n";
    }
}
