import java.util.Scanner;



public class StaticDistancing {
    public static int OutPatientMainAreaCapacity = 20;
    public static int OutPatientSubAreaCapacity = 10;
    public static int ICUAreaCapacity = 5;
    public static int InPatientMainAreaCapacity = 20;
    public static int ResearchAreaCapacity = 40;
    public static int SurgeryAreaCapacity = 10;
    static Scanner input = new Scanner(System.in);
    public static int[] store_capacity;

    // calling the objects from RestrictedSpots class to get the details of each
    public static RestrictedSpots.restrictedSpots OPmain_waiting_area = new RestrictedSpots.restrictedSpots(1,
            "Main Waiting Area", 10, 50, 30);
    public static RestrictedSpots.restrictedSpots OPsub_waiting_area = new RestrictedSpots.restrictedSpots(2,
            "Sub Waiting Area", 20, 50, 10);
    public static RestrictedSpots.restrictedSpots ICU_waiting_area = new RestrictedSpots.restrictedSpots(3,
            "ICU Waiting Area", 35, 50, 5);
    public static RestrictedSpots.restrictedSpots IP_waiting_area = new RestrictedSpots.restrictedSpots(4,
            "Inpatient Waiting Area", 50, 50, 10);
    public static RestrictedSpots.restrictedSpots research_center = new RestrictedSpots.restrictedSpots(5,
            "Research Center", 10, 50, 20);
    public static RestrictedSpots.restrictedSpots surgery_room = new RestrictedSpots.restrictedSpots(6, "Surgery Room",
    23, 120, 5);

    // creating an array of all the area objects to iterate through when needed
    public static RestrictedSpots.restrictedSpots[] restrictedSpotsArray = { OPmain_waiting_area, OPsub_waiting_area,
            ICU_waiting_area, IP_waiting_area, research_center, surgery_room };

    public static void main(String[] args) {

        int user_input = 0;

        System.out.println("Welcome to the Hospital!");

        int loop_menu = 0;
        // using a while loop to keep the application running until the user exits
        while (loop_menu == 0) {

            
            System.out.println(
                    "Select the location you would like to enter:\n1: Out-patient visitors' Main Waiting Area\n2: Out-patient Visitors' Sub-waiting Area\n3: Intensive Care Unit Visiting Area\n4: In-patient Visitors' Waiting Area\n5: Research Center\n6: Surgery Room Waiting Area\n7: Exit Application");

            user_input = input.nextInt();
            input.nextLine(); // consume the newline character left by nextInt()
            // switch case to select the location the user wants to enter
            
            switch (user_input) {
                case 1: {
                    System.out.println("You have selected the Out-patient visitors' Main Waiting Area.\n");
                    break;
                }
                case 2: {
                    System.out.println("You have selected the Out-patient Visitors' Sub-waiting Area.\n");
                    break;
                }
                case 3: {
                    System.out.println("You have selected the Intensive Care Unit Visiting Area.\n");
                    break;
                }
                case 4: {
                    System.out.println("You have selected the In-patient Visitors' Waiting Area.\n");
                    break;
                }
                case 5: {
                    System.out.println("You have selected the Research Center.\n");
                    break;
                }
                case 6: {
                    System.out.println("You have selected the Surgery Room Waiting Area.\n");
                    break;
                }
                case 7: {
                    System.out.println("Thank you for using the application! Please come again.\n");
                    System.exit(user_input);
                }
            }

            int menuCheck = enterCheck(user_input); // calling the method to check if the user can enter the area
            System.out.println("Hello! Menu check is: " + menuCheck);

            // if the value returned by enterCheck() is 1, return back to menu. else, enter
            // to area selected
            if (menuCheck == 0) {
                enterArea(user_input);
            }

        }

    }

    // method to get the maximum capacities of each location
    public static int[] getMaxCapacity() {
        int[] maxCapacities = { OutPatientMainAreaCapacity, OutPatientSubAreaCapacity, ICUAreaCapacity,
                InPatientMainAreaCapacity };
        return maxCapacities;
    }

    // method to get the maximum time a user can wait in each location
    public static double[] getMaxTime() {
        double[] maxTimes = new double[restrictedSpotsArray.length];

        for (int i = 0; i < restrictedSpotsArray.length; i++) {
            for (RestrictedSpots.restrictedSpots restrictedSpots2 : restrictedSpotsArray) {
                maxTimes[i] = restrictedSpots2.getSpot_Permitted_Average_Time();
            }
        }

        return maxTimes;
    }

    // method to check if the user can enter the area
    public static int enterCheck(int user_input) {
        DynamicDistancing currentCapacities = new DynamicDistancing(); // creating object of DynamicDistancing class to
                                                                       // access its methods

        int flag = 0; // flag to check if the room has reached its maximum capacity
        int menuFlag = 0; // flag to check if the user wants to wait or not

        currentCapacities.setCurrCapacity(); // getting the current capacities of each location
        int[] maxCapacities = getMaxCapacity(); // getting the maximum capacities of each location

        store_capacity = currentCapacities.getCurrentCapacity();

        // comparing values of current and maximum capacities
        for (int i = 0; i < maxCapacities.length; i++) {
            if (user_input == i + 1) {
                if (currentCapacities.currentCapacities[i] < maxCapacities[i]) {
                    return menuFlag;
                } else {
                    flag = 1;
                }
            }
        }

        // if the room the user has selected has reached its maximum capacity, the user
        // is asked if they want to wait
        while (menuFlag == 0) {
            if (flag == 1) {
                System.out.printf(
                        "The room has reached its maximum visitor count of %d visitors.\nWould you like to wait %.2f minutes for a visitor to leave?\n1: Yes\n2: No\n",
                        maxCapacities[user_input - 1], getMaxTime()[user_input - 1]);
                
                
                int inputWait = input.nextInt();
                

                if (inputWait == 1) {
                    return menuFlag;
                } else {
                    System.out.println("Returning to menu....\n");
                    menuFlag = 1;
                }
            }
        }
        return menuFlag;
    }


    // function to prompt user entering the area
    public static void enterArea(int user_input) {

        boolean closeContact = false; // flag to check if the user is too close to another person
        //Scanner input = new Scanner(System.in);

        System.out.println("You have successfully entered the area.\n");


        System.out.println("The current capacity of this area: " + store_capacity[user_input]); // Prints out the current capacity
        // check for the distance of the closest person in all 4 directions:
        String[] arr = { "left", "right", "front", "back" };
        float[] distArr = new float[arr.length];

        // taking in input of distance of closest person in all four directions
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter the distance between the closest person to the %s of you in meters:\n", arr[i]);
            distArr[i] = input.nextFloat();
            input.nextLine();

            // if the input is less than 1 meter away, ask user to move away
            if (distArr[i] < 1) {
                float diff = 1 - distArr[i];
                closeContact = !closeContact;
                System.out.printf(
                        "You are too close to the person to the %s of you. Please move away %.2f meters away.\n",arr[i], diff);
            }
        }


        // generating the user's contact status to casual contact to default
        String contactStatus = "Casual Contact";

        if (closeContact == true) {
            contactStatus = "Close Contact";
        }

        // using for each statement to get details of the area
        for (RestrictedSpots.restrictedSpots restrictedSpots2 : restrictedSpotsArray) {
            restrictedSpots2.getSpotID();

            System.out.println(restrictedSpots2.getSpotID());

            // compare user input to the spotID of the locations; if they are equal, get the rest of the data
            if (user_input == restrictedSpots2.getSpotID()) {
                String spotName = restrictedSpots2.getSpotName();
                int spotArea = restrictedSpots2.getSpot_area();
                double avg_time = restrictedSpots2.getSpot_Permitted_Average_Time();
                int max_Cap = restrictedSpots2.getSpot_Maximum_Capacity();

                int[] currentCapacity_area = store_capacity;

                // int currentCapacity = CurrCap.getCurrentCapacity(restrictedSpots2.getSpotID());
                // int maxCapacity = restrictedSpots2.getSpot_Maximum_Capacity();

                // double capacity = (double) currentCapacity / maxCapacity;
                
                double area = (double) (currentCapacity_area[restrictedSpots2.getSpotID()] / (double) max_Cap * spotArea) * 10;

                // if(area == 0.00){
                //     System.out.println("This area is empty and safe to enter");
                // }else{
                    System.out.println("The area is " + String.format("%.2f",area) + " Occupied");
                //}
                //System.out.println("The current capacity in this area is " + result[restrictedSpots2.getSpotID()]); 

                

                System.out.println("Enter your userID: ");
                int UserID = input.nextInt();
                input.nextLine();
                System.out.println("Enter your Name");
                String UserName = input.nextLine();


                // then print the details of the user and the area they are in
                System.out.println("User ID:" + UserID + "\nFull Name:" + UserName + "\nSelected Spot ID:"
                        + restrictedSpots2.getSpotID() + "\nSelected Spot Name: " + restrictedSpots2.getSpotName()
                        + "\nSelected Spot Area: " + restrictedSpots2.getSpot_area()
                        + "\nSelected Spot Permitted Average Time: " + restrictedSpots2.getSpot_Permitted_Average_Time()
                        + "\nSelected Spot Maximum Capacity: " + restrictedSpots2.getSpot_Maximum_Capacity()
                        + "\nContact Status: " + contactStatus);
            break;
            }
        }
        //input.close();
    }
}
