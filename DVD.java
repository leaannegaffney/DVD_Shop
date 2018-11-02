public class DVD
{
    private String dvdId;
    private String dvdName;
    private int ageClassification;
    private String category;
    private int numMinutes;
    private static int lenOfTime;//static variable to change every object in class by a set length of time
    private int rating;

    public DVD(String idIn, String nameIn, String categoryIn,int ageIn, int runningTimeIn)//constructor method
    {
        dvdId = idIn;
        dvdName = nameIn;
        category = categoryIn;
        ageClassification = ageIn;
        numMinutes = runningTimeIn;
        lenOfTime = 0;
    }

    /*setter methods set the variables to what is sent in as parameter - getter methods return the variable from where method 
    was called*/
    public void setDvdId(String idIn)
    {
        dvdId = idIn; 
    }

    public String getDvdId()
    {
        return dvdId;
    }

    public void setDvdName(String nameIn)
    {
        dvdName = nameIn;
    }

    public String getDvdName()
    {
        return dvdName; 
    }

    public void setCategory(String categoryIn)
    {
        category = categoryIn;
    }

    public String getCategory()
    {
        return category;
    }

    public void setAgeClassification(int ageIn)
    {
        ageClassification = ageIn; 
    }

    public int getAgeClassification()
    {
        return ageClassification; 
    }

    public void setNumMinutes(int minsIn)
    {
        numMinutes = minsIn;
    }

    public int getNumMinutes()
    {
        return numMinutes;
    }

    public static void setLenOfTime(int timeIn)//static makes it a class method - call it by class name not object name
    {
        lenOfTime = lenOfTime + timeIn;
    }

    public static int getLenOfTime()//static makes it a class method - call it by class name not object name
    {
        return lenOfTime;
    }

    public void setRating(int ratingIn)
    {
        rating = ratingIn;
    }

    public int getRating()
    {
        return rating;
    }
}