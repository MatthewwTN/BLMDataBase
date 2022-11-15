
/**
 * Movie
 * ----
 * This class holds a record of a movie.
 * Contains the Name of the Movie 
 * Contains the description of the Movie 
 * Contains the Director of the Movie 
 * Also holds the Year the Movie was made. 
 * 
 * It also extends from the Record class which implements the compareToByInterface, which essentailly allows it to be comparable
 * with other classes that inherit from record, or implement the compareToBy interface.
 * 
 * Matthew Negasi
 * @author 
 */
public class Movie extends Record
{
    public String name;
    public String description;
    public String director;
    public int year;

    /**
     * Movie()
     * -------
     * No Arg Constructor
     */
    public Movie()
    {
        // initialise instance variables
        super("Movie", "unNamed Movie","blank description" );
        this.director = "UnNamed Director";
        this.year = 2021;
        this.name = "movie";
    }

    /**
     * public Movie()
     * --------------
     * Constructor with 4 Parameters (String name, String description, String director, int year).
     * Pre: year > 1000 and <  year 2021. 
     * Post: Initializes a valid Movie Object. 
     * 
     */
    public Movie(String name, String description, String director, int year)
    {
        // initialise instance variables
        super("Movie", name, description ); // Calling super to initialize that it is a record of type Movie 
        this.director = director;
        if (year < 1000 || year > 2021) year = 2021;
        else this.year = year;
        this.name = name;
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

        if(other.getRecordType().equals("Online")){
            Record otherOnline = new OnlineRec(); 
            otherOnline = other;
            OnlineRec that = (OnlineRec) otherOnline;
            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetically organizes, by using the compareTo with the name 
                // either returns -1 , 0 or 1. 
            }

            if(attributeToCompareBy.equals("websiteURL")){
                return 1; // Movie does not have the feature called websiteURL therefore it will return 1
            }
            if(attributeToCompareBy.equals("director")){
                return -1; // Online rec doesnt have this feature so it will return - 1
            }
            if(attributeToCompareBy.equals("year")){
                return -1;  // Online rec doesnt have this feature so it will return - 1
            }

            if(attributeToCompareBy.equals("description")){
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the Movies is greater, it will return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if they are equal it will return 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if the  Movies is less than that of the book it will return -1
                }
            }

            if(attributeToCompareBy.equals("recordType")){
                return -1; // Movies will always be considered as the type that is less than that of an online source ( returns -1)
            }
        }

        if(other.getRecordType().equals("Book")){
            Record otherBook = new Book(); 
            otherBook = other;
            Book that = (Book) otherBook;
            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Comparing the Alhpabetical standing to see which name comes first 
            }

            if(attributeToCompareBy.equals("year")){
                if(this.year == that.year){
                    return 0; // if the attribute is years, and they are equal to one another, this will return 0 
                }
                if(this.year > that.year){
                    return 1; // if the attribute is years, and the movies year is greater than the books, this will return 1 
                }
                if(this.year < that.year){
                    return -1; // if the attribute is years, and the movies year is less than the book , this will return -1
                }
            }

            if(attributeToCompareBy.equals("description")){
                // Comparing description lengths between the book and the Movie 
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the movies is greater, it will return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if they are equal it will return 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if the movies is less than that of the book it will return -1
                }
            }

            if(attributeToCompareBy.equals("author")){
                return 1; // Movies do not have a technical author, so this will return 1 
            }
            if(attributeToCompareBy.equals("director")){
                return -1; // Books do not have directors, so this will return - 1
            }

            if(attributeToCompareBy.equals("recordType")){
                return 1; // Movies will always be considered Greater than books, this will make the heirachy go from
                //Books > Movies > Online
            }
        }

        if(other.getRecordType().equals("Movie")){
            Record otherMovie = new Movie();
            otherMovie = other; 
            Movie that = (Movie) otherMovie;
            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Comparing names, with the compareTo feature 
            }

            if(attributeToCompareBy.equals("director")){
                return this.director.compareTo(that.director); // Comparing names with the CompareTo Feature
                // if this name is before or equal or less than the casted objects name, in regards to alphabetical order 
                // it will return 1 0 or -1 in correspondence to the place in the alphabet it lies.
            }

            if(attributeToCompareBy.equals("year")){

                if(this.year == that.year){
                    return 0; // if the attribute is years, and they are equal to one another, this will return 0 
                }
                if(this.year > that.year){
                    return 1; // if the attribute is years, and this instances year is greater than the casted object, this will return 1 
                }
                if(this.year < that.year){
                    return -1; // if the attribute is years, and this instances year is less than the casted object, this will return -1 
                }
            }

            if(attributeToCompareBy.equals("description")){
                // Comparing description lengths between the book and the Movie 
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the description of the casted object (Movie)  is less than the one its being compared to, this will return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if both descriptions are equal in length, this will return 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if the casted object (Movie) has a longer description, this will return -1 when compared
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
        return this.name; // Returns the name of the Movie 
    }

    /**
     * getDirector
     * -----------
     */
    public String getDirector(){
        // [OH NO! IT GOT ERASED!}
        return this.director; // Returns the Director of the Movie
    }

    /**
     * toString
     * --------
     * This provides a nice looking String representation of this particular Record
     * PRE: none
     * POST: current object is unchanged. A String is returned.
     */
    public String toString(){
        return this.identifier + " (" + this.year + "), directed by " + this.director + ": \n" + niceLookingDescription()+ "\n";
    }

    /**
     * getYear
     * -------
     */
    public int getYear(){
        return this.year;
        // Returns the year that the movie was made. 
    }

}
