public class DVDShop
{
    private DVD dvdList [];//declaring the array called dvdList of type DVD
    private int total;

    public DVDShop(int howManyIn)//constructor method
    {
        dvdList = new DVD [howManyIn];//the array size is being set by the parameter being sent in to constructor
        total = 0;//starting total at zero as no DVD's have been added yet
    }

    public int getTotal()
    {
        return total;
    }

    public boolean isEmpty()
    {
        if(total == 0)//if total has not increased it means no DVD's have been added 
        {
            return true;//the array is empty
        }
        else
        {
            return false; //the array is not empty
        }
    }

    public boolean isFull()
    {
        if(total == dvdList.length)//if the total number of DVD's added is equal to the length of the array
        {
            return true;//the array is full
        }
        else
        {
            return false;//the array is not full
        }
    }

    public boolean add(DVD dvdIn)
    {
        if(isFull() == false)//check to see if the array is full by using the isFull method 
        {
            dvdList[total] = dvdIn;//the next available location in they array is equal to the DVD object sent in
            total ++;//increasing total by 1
            return true;//sending back true to let user know it was added successfully
        }
        else
        {
            return false;//sending back false because the array was full so another DVD object could not be added
        }
    }

    private int search(String idIn)//private because it is not used in any other classes
    {
        for(int i = 0; i < total; i ++)
        {
            if(dvdList[i].getDvdId().equals(idIn) == true)//dvd ID equals the ID sent in
            {
                return i;//send back location in the array of the object with the dvd ID sent in
            }
        }
        return -999;//send back an integer to say the ID wasn't found in the array
    }

    public boolean remove(String idIn)
    {
        if(search(idIn) == -999)//the location of the dvd with the ID number sent in is equal to -999
        {
            return false; //no dvd with that id number found
        }
        else
        {
            for(int i = search(idIn); i < total-1; i++)
            //i=location in array of dvd with ID sent in, total-1 to stop out of bounds error 
            {
                dvdList[i] = dvdList[i+1];//current dvd object is now equal to the dvd object located after it and so on 
            }
            total--;//decreasing the total by one
            return true;//dvd was removed successfully
        }
    }

    public String list()
    {
        String allDvds = "";//initialise the variable of type String with a blank String

        if(isEmpty() == true)//checking to see if there are any dvd's to send back
        {
            return allDvds; //return the empty string if the array is empty
        }
        else
        {
            for(int i = 0; i < total; i++)
            {
                allDvds = allDvds + "\n\nDVD ID: " + dvdList[i].getDvdId() + "\nDVD Name: " + dvdList[i].getDvdName() + 
                "\nDVD Classification: " + dvdList[i].getAgeClassification() + "\nDVD Category: " + dvdList[i].getCategory() +
                "\nDVD Rating: " + dvdList[i].getRating() + "\nLength of DVD: " + dvdList[i].getNumMinutes() + 
                "\nNumber of years in shop: " + dvdList[i].getLenOfTime();
                //string allDvds = all the dvd information using the methods in the dvd class to get the information

            }
        }
        return allDvds;//send back the string
    }

    public DVD getItem(String idIn)
    {
        if(search(idIn) == -999)
        {
            return null; //send back the empty object if the id cannot be found
        }
        else
        {
            return dvdList[search(idIn)]; //send back the dvd object using the search method to find the location in the array
        }
    }

    public DVD checkLongestDvd()
    {
        DVD longestDvd = null;//initialise the variable of type dvd by setting it to null

        if(isEmpty() == true)
        {
            return longestDvd;//if the array is empty return the variable that is null
        }
        else
        {
            longestDvd = dvdList[0];//variable = first object in the array
            for(int i = 1; i < total; i++)//start i at 1 so we are not checking the first object against itself
            {
                if(longestDvd.getNumMinutes() < dvdList[i].getNumMinutes())
                //// if first dvd length is less than dvd length in 'i'
                {
                    longestDvd = dvdList[i];//set variable equal to dvd object in array position 'i' 
                }
            }
            return longestDvd;
        }

    }

    public DVD checkShortestDvd()
    {
        DVD shortestDvd = null;

        if(isEmpty() == true)
        {
            return shortestDvd; 
        }
        else
        {
            shortestDvd = dvdList[0];
            for(int i = 1; i < total; i++)
            {
                if(shortestDvd.getNumMinutes() > dvdList[i].getNumMinutes())
                //if first dvd length is greater than dvd length in 'i'
                {
                    shortestDvd = dvdList[i];//set variable equal to dvd object in array position 'i'
                }
            }
            return shortestDvd;
        }
    }

    public String updateLenOfTime()
    {
        String updated = "";
        if(isEmpty() == true)
        {
            return updated; 
        }
        else
        {
            updated = "All information is updated";//add a string to the variable
            DVD.setLenOfTime(1);//call the static method and send in 1 because we want to increase the length of time by 1 year
            return updated;//return the string to confirm all dvd's have been updated
        }
    }

    public boolean addDetails(String idIn, int ratingIn)
    {
        if(search(idIn) == -999)//if search method doesnt find the id sent in as parameter
        {
            return false;
        }
        else
        {
            dvdList[search(idIn)].setRating(ratingIn);
            //array name[location found by search using id sent in] is the object used to call the set rating method
            return true;
        }
    }

    public String dvdByClassification(int classificationIn)
    {
        String dvdClassification = "";
        for(int i = 0; i < total; i++)
        {
            if(dvdList[i].getAgeClassification() == classificationIn)//use array as key to call dvd class method
            {//if the age classification send back equals the classification sent in
                DVD dvd = getItem(dvdList[i].getDvdId());
                //the variable dvd of type DVD equal to dvd object sent back by get item method
                //variable must equal itself plus the strings otherwise every time loop goes around the previous info will be gone
                dvdClassification = dvdClassification + "\n\nDVD ID: " + dvdList[i].getDvdId() + "\nDVD Name: " +
                dvdList[i].getDvdName() + "\nDVD Classification: " + dvdList[i].getAgeClassification() + "\nDVD Category: " 
                + dvdList[i].getCategory() +"\nDVD Rating: " + dvdList[i].getRating() + "\nLength of DVD: " + 
                dvdList[i].getNumMinutes();
            }
        }
        return dvdClassification;
    }

}

