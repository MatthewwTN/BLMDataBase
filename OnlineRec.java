
/**
 * OnlineRec
 * ---------
 * This class holds a record of some online resource like a website or an online article.
 * Any article of resource online can be held by this class. 
 * Contains a spot for the websiteURL. 
 * As well as a String for the Name of the Online Resource.
 * 
 * It also extends from the Record class which implements the compareToByInterface, which essentailly allows it to be comparable
 * with other classes that inherit from record, or implement the compareToBy interface.
 * 
 * Matthew Negasi
 * @author 
 */
public class OnlineRec extends Record
{
    public String websiteURL;
    public String name; 
    public String description;
    
    /**
     * OnlineRec()
     * -----------
     * No Arg Constructor
     */
    public OnlineRec()
    {
        // initialise instance variables
        super("Online", "unNamed OnlineRec","blank description" );
        this.websiteURL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        this.name = "unNamed";
    }

    /**
     * OnlineRec() 
     * ------------
     * Constructor with 3 Parameters: (String name, String description, String websiteURL)
     * Pre: None, just need to fill in the parameters. 
     * 
     */
    public OnlineRec(String name, String description, String websiteURL)
    {
        // initialise instance variables
        super("Online", name, description );
        this.websiteURL = websiteURL;
        this.name = name;
        this.description = description;
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
            Record otherOnlineRec = new OnlineRec(); 
            otherOnlineRec = other; 
            OnlineRec that = (OnlineRec) otherOnlineRec;
            if(attributeToCompareBy.equals("identifier")|| attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetic Check to order the comparison 
            }

            if(attributeToCompareBy.equals("websiteURL")){

                if(this.getWebsiteURL().length() > that.getWebsiteURL().length()){
                    return 1; 
                    // Comparing the length of the WebsiteURL if this instance is greater than the incoming Online
                }
                if(this.getWebsiteURL().length() == that.getWebsiteURL().length()){
                    return 0; // if they are equal, return 0           
                }
                if(this.getWebsiteURL().length() < that.getWebsiteURL().length()){
                    return -1;      // if the description is smaller in length, returns - 1      
                }
            }
            
            if(attributeToCompareBy.equals("description")){
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the online source has a longer description than the casted online source, it will return 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if equal than 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if less than - 1
                }
            }    
        }

        if(other.getRecordType().equals("Book")){ // the recType comparison allows for the right casting
            Record otherBook = new Book(); 
            otherBook = other; 
            Book that = (Book) otherBook;// Casting the Book, so that it will be a comparable object 

            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetic Check, will align the objects in alphabetic order
            }

            if(attributeToCompareBy.equals("description")){
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the online source has a longer description length than the casted book , it returns 1
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0; // if equal than 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1;  // if less than - 1
                }
            }
            
            if(attributeToCompareBy.equals("websiteURL")){
                return -1; // The Book doesnt have this feature, so this will return -1
            }
            if(attributeToCompareBy.equals("author")){
                return 1; // Online Source doesnt have this feature, so it will return 1
            }
            if(attributeToCompareBy.equals("year")){
                return 1; // Online Source doesnt have this feature, so it will return 1
            }


            if(attributeToCompareBy.equals("recordType")){
                return 1; // When comparing simply by type, the online rec will be greater than the Book
            }
        }

        if(other.getRecordType().equals("Movie")){ // the recType comparison allows for the proper casting
            Record otherMovie = new Movie(); 
            otherMovie = other;
            Movie that = (Movie) otherMovie; // casting the record to become a movie that can be comparable 

            if(attributeToCompareBy.equals("identifier")){
                return this.getName().compareTo(that.getName()); // Alphabetic Check, will align the objects in alphabetic order
            }

            if(attributeToCompareBy.equals("description")){
                if(this.getDescription().length() > that.getDescription().length()){
                    return 1; // if the online source has a longer length than the casted movie, return 1 
                }
                if(this.getDescription().length() == that.getDescription().length()){
                    return 0;  // if equal than 0
                }
                if(this.getDescription().length() < that.getDescription().length()){
                    return -1; // if less than - 1
                }
            }
            
            if(attributeToCompareBy.equals("websiteURL")){
                return -1; // Movie does not have this feature, so this will return - 1
            }
            if(attributeToCompareBy.equals("director")){
                return 1; // Online Rec doesnt have this feature, so it returns 1, because movie does
            }
            if(attributeToCompareBy.equals("year")){
                return 1; // Online Rec doesnt have this feature, so it returns 1, because movie does
            }

            if(attributeToCompareBy.equals("recordType")){
                return 1; // When comparing simply by type, the online rec will be greater than the Movie 
            }
        }

        return 0; // Returns zero if neither have the features.
    }

    /**
     * getWebsiteURL
     * -------------
     */
    public String getWebsiteURL(){
        // [OH NO! IT GOT ERASED!]
        return this.websiteURL; // Returns the websiteURL of the website.
    }

    /**
     * toString
     * --------
     * This provides a nice looking String representation of this particular Record
     * PRE: none
     * POST: current object is unchanged. A String is returned.
     */
    public String toString(){
        return this.identifier + " (" + this.websiteURL + "): \n" + niceLookingDescription() + "\n";
    }

    public String getName(){
        return this.name; // Returns the name of the online Resource 
    }

    public String getDescription(){
        return this.description; // Returns the Description of the OnlineResource 
    }
}
