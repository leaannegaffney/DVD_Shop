
public class XtraVisionApplication
{
    public static void main(String args [])
    {
        int choice1;//variable for main menu

        System.out.print("Enter the maximum number of DVD's that can be stored in the shop: ");

        DVDShop xtraVision = new DVDShop(EasyScanner.nextInt());//setting the size of the array

        do
        {//menu displayed using a loop
            System.out.println();
            System.out.println("DVD System");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Check if DVD Shop is Empty");
            System.out.println("4. Check if DVD Shop is Full");
            System.out.println("5. Add Additional DVD Details");
            System.out.println("6. DVD Details");
            System.out.println("7. Update DVD Length of Time in Store");
            System.out.println("8. Search DVD by Age Classification");
            System.out.println("9. Exit System");
            System.out.println();
            System.out.print("Please enter choice [1 - 9 only]: ");
            choice1 = EasyScanner.nextInt();

            switch(choice1)//switch statement based on users entry saved in choice1
            {
                case 1:
                option1(xtraVision);
                /*xtraVision object of type dvdshop must be sent in to allow the methods to use the object to access 
                dvdshop methods*/
                break;

                case 2:
                option2(xtraVision);
                break;

                case 3:
                option3(xtraVision);
                break;

                case 4:
                option4(xtraVision);
                break;

                case 5:
                option5(xtraVision);
                break;

                case 6:
                option6(xtraVision);
                break;

                case 7:
                option7(xtraVision);
                break;

                case 8:
                option8(xtraVision);
                break;

                case 9:
                System.out.println();
                System.out.println("Thank you for using the DVD System");//final message
                break;

                default:
                System.out.print("Invalid entry, please enter [1-9] only");//user must only enter 1-9
                System.out.println();
            }
        }
        while(choice1 != 9);//loop will finish when user enters 9
    }

    private static void option1(DVDShop xtraVision)//adding new dvd
    {
        System.out.print("Enter DVD ID: ");//saving all the inputs from the user in variables
        String id = EasyScanner.nextString();
        System.out.print("Enter DVD Name: ");
        String name = EasyScanner.nextString();
        System.out.print("Enter DVD Category: ");
        String category = EasyScanner.nextString();
        System.out.print("Enter DVD Classification: ");
        int classification = EasyScanner.nextInt();
        while(classification != 12 && classification != 15 && classification != 18)
        {//error checking to ensure only 12, 15 or 18 are entered
            System.out.print("Please enter a valid classification (12, 15 or 18): ");
            classification = EasyScanner.nextInt();
        }
        System.out.print("Enter DVD Running Time: ");
        int runningTime = EasyScanner.nextInt();

        DVD dvd = new DVD(id,name,category,classification,runningTime);
        //sending in variables with user inputs to constructor to create the dvd object 
        if(xtraVision.add(dvd) == false)//using dvdshop object to call the methods in dvdshop class
        {
            System.out.println();
            System.out.println("Can not add new DVD. The list is full");
        }
        else
        {
            System.out.println();
            System.out.println("DVD Added");
        }
    }

    private static void option2(DVDShop xtraVision)//removing dvd
    {
        System.out.println();
        System.out.print("Enter DVD ID to remove: ");
        String id = EasyScanner.nextString();//saving id entered from user
        if(xtraVision.remove(id) == false)//calling the remove method from dvdshop class
        {
            System.out.println();
            System.out.println("Cannot delete DVD as no such DVD exists");
        }
        else
        {
            System.out.println();
            System.out.print("DVD with ID number " + id + " is removed");
            System.out.println();
        }
    }

    private static void option3(DVDShop xtraVision)//checking if array is empty
    {
        if(xtraVision.isEmpty() == true)
        {
            System.out.println();
            System.out.println("The DVD shop is empty");
        }
        else
        {
            System.out.println();
            System.out.println("The DVD shop is not empty");
        }
    }

    private static void option4(DVDShop xtraVision)//checking if array is full
    {
        if(xtraVision.isFull() == true)
        {
            System.out.println();
            System.out.println("The DVD shop is full");
        }
        else
        {
            System.out.println();
            System.out.println("The DVD shop is not full");
        }
    }

    private static void option5(DVDShop xtraVision)//adding a rating to the dvd
    {
        System.out.print("Enter DVD ID: ");
        String id = EasyScanner.nextString();
        System.out.println();
        System.out.print("Enter DVD rating: ");
        int rating = EasyScanner.nextInt();

        if(xtraVision.addDetails(id,rating) == false)//cant find the dvd with the id user enters
        {
            System.out.println();
            System.out.println("No such DVD ID exists");
        }
        else
        {
            System.out.println();
            System.out.println("DVD details updated"); 
        }
    }

    private static void option6(DVDShop xtraVision )//displaying the second menu when user enters 6
    {
        char choice2;//variable for second menu

        System.out.println();
        System.out.println("Employee System");
        System.out.println("1. Add a DVD");
        System.out.println("2. Remove a DVD");
        System.out.println("3. Check if DVD Shop is Empty");
        System.out.println("4. Check if DVD Shop is Full");
        System.out.println("5. Add Additional DVD Details");
        System.out.println("6. DVD Details");
        System.out.println("          a. Display Details of a DVD");
        System.out.println("          b. Display All DVD Details");
        System.out.println("          c. Display Longest Running DVD");
        System.out.println("          d. Display Shortest Running DVD");
        System.out.println("7. Update DVD Length of Time in Store");
        System.out.println("8. Search DVD by Age Classification");
        System.out.println("9. Exit System");
        System.out.println();
        System.out.print("Enter choice [a - d]: ");
        choice2 = EasyScanner.nextChar();

        switch(choice2)//second switch statement based on users input saved in choice2
        {
            case 'a':
            option6a(xtraVision);
            break;

            case 'b':
            option6b(xtraVision);
            break;

            case'c':
            option6c(xtraVision);
            break;

            case'd':
            option6d(xtraVision);
            break;

            default:
            System.out.println();
            System.out.println("Invalid entry, please enter [a-d] only");//letting user know it was an invalid entry
        }
    }

    private static void option6a(DVDShop xtraVision)//display details of one dvd object
    {
        System.out.print("Enter DVD ID: ");
        String id = EasyScanner.nextString();

        DVD dvd = xtraVision.getItem(id);//dvd variable of type DVD is equal to the object sent back by getItem method

        if(dvd == null)//if empty object sent back the id wasn't located
        {
            System.out.println();
            System.out.println("No such DVD ID exists");
        }
        else
        {
            System.out.println();//displays the details of the object
            System.out.println("DVD ID: " + dvd.getDvdId());
            System.out.println("DVD Name: " + dvd.getDvdName());
            System.out.println("DVD Age Classification: " + dvd.getAgeClassification());
            System.out.println("DVD Category: " + dvd.getCategory());
            System.out.println("DVD Rating: " + dvd.getRating());
            System.out.println("DVD Running Time: " + dvd.getNumMinutes());
        }
    }

    private static void option6b(DVDShop xtraVision)//displaying all the objects in the array
    {
        if(xtraVision.list().equals(""))
        {
            System.out.println();
            System.out.println("The DVD shop is empty");
        }
        else
        {
            System.out.println(xtraVision.list());
        }
    }

    private static void option6c(DVDShop xtraVision)//checking the longest running dvd in the array
    {
        DVD dvd = xtraVision.checkLongestDvd();
        //dvd variable of type DVD is equal to the dvd object returned by dvdshop method

        if(dvd == null)//object is null because the array is empty
        {
            System.out.println();
            System.out.println("The DVD shop is empty");
        }

        else
        {
            System.out.println();
            System.out.println(dvd.getDvdName() + " with the ID " + dvd.getDvdId() + " is the longest running dvd (" + 
                dvd.getNumMinutes() + ")");
        }
    }

    private static void option6d(DVDShop xtraVision)//checking the shortest running dvd in the array
    {
        DVD dvd = xtraVision.checkShortestDvd();

        if(dvd == null)
        {
            System.out.println();
            System.out.println("The DVD shop is empty");
        }
        else
        {
            System.out.println();
            System.out.println(dvd.getDvdName() + " with the ID " + dvd.getDvdId() + " is the shortest running dvd (" + 
                dvd.getNumMinutes() + ")");
        }
    }

    private static void option7(DVDShop xtraVision)//updating all dvd objects by calling the static method
    {
        String updated = xtraVision.updateLenOfTime();
        //string variable is equal to the string sent back by dvdshop method
        if(updated.equals(""))//if empty string the array is empty
        {
            System.out.println();
            System.out.println("The DVD shop is empty");
        }
        else
        {
            System.out.println();
            System.out.println(updated);//let the user know the task has been completed
        }
    }

    private static void option8(DVDShop xtraVision)///search for dvd by age classification
    {
        System.out.println();
        System.out.print("Enter age classification of DVD's to view: ");
        int age = EasyScanner.nextInt();
        while(age != 12 && age != 15 && age != 18)//error checking to ensure user enters 12,15 or 18
        {
            System.out.print("Please enter a valid classification (12, 15 or 18): ");
            age = EasyScanner.nextInt();
        }
        String dvdClassifications = xtraVision.dvdByClassification(age);
        //string variable equals the string returned by dvdshop method
        if(dvdClassifications.equals(""))
        {
            System.out.println();
            System.out.println("There are no DVD's for the age classification " + age);
        }
        else
        {
            System.out.println("The DVD's for the age classification " + age + " are:");
            System.out.println(xtraVision.dvdByClassification(age));
        }
    }
}
