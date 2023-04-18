import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class StaticDistancing {

    static Scanner input = new Scanner(System.in);
    public static int[] store_capacity;
    public static int[] currentCapacities;

    // some defaults initializations
    public static int waitCheck = 0;
    public static int exitFlag = 0;
    static String contactStatus = "Casual Contact";

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

        // using a while loop to keep the application running until the user exits
        while (true) {

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

            if (menuCheck == 0) {
                enterArea(user_input, waitCheck);
            } else if (menuCheck == 1) {
                waitCheck = 1;
                enterArea(user_input, waitCheck);
            }

            // resetting waitCheck flag
            waitCheck = 0;
        }

    }

    // method to get the maximum capacities of each location
    public static int[] getMaxCapacity(int user_input) {

        int[] maxCapacities = new int[restrictedSpotsArray.length];

        for (int i = 0; i < restrictedSpotsArray.length; i++) {
            for (RestrictedSpots.restrictedSpots restrictedSpots2 : restrictedSpotsArray) {
                if (i + 1 == restrictedSpots2.getSpotID()) {
                    maxCapacities[i] = restrictedSpots2.getSpot_Maximum_Capacity();
                }
            }
        }
        return maxCapacities;
    }

    // method to get the maximum time a user can wait in each location
    public static double[] getMaxTime(int user_input) {
        double[] maxTimes = new double[restrictedSpotsArray.length];

        for (int i = 0; i < restrictedSpotsArray.length; i++) {
            for (RestrictedSpots.restrictedSpots restrictedSpots2 : restrictedSpotsArray) {
                if (i + 1 == restrictedSpots2.getSpotID()) {
                    maxTimes[i] = restrictedSpots2.getSpot_Permitted_Average_Time();
                }
            }
        }

        return maxTimes;
    }

    // method to check if the user can enter the area
    public static int enterCheck(int user_input) {
        DynamicDistancing currentCapacity = new DynamicDistancing(); // creating object of DynamicDistancing class to
                                                                     // access its methods

        int flag = 0; // flag to check if the room has reached its maximum capacity
        int menuFlag = 0; // flag to check if the user wants to wait or not

        currentCapacities = currentCapacity.getCurrCapacity(user_input); // getting the current capacities of each
                                                                         // location
        int[] maxCapacities = getMaxCapacity(user_input); // getting the maximum capacities of each location

        // comparing values of current and maximum capacities
        if (currentCapacities[user_input - 1] < maxCapacities[user_input - 1]) {
            return menuFlag;
        } else {
            flag = 1;

        }

        // if the room the user has selected has reached its maximum capacity, the user
        // is asked if they want to wait
        while (menuFlag == 0) {
            if (flag == 1) {
                System.out.println(
                        "The room has reached its maximum visitor count of " + maxCapacities[user_input - 1] +
                                " visitors.\nWould you like to wait " + getMaxTime(user_input)[user_input - 1] +
                                " minutes for a visitor to leave?\n1: Yes\n2: No");

                int inputWait = input.nextInt();

                if (inputWait == 1) {
                    menuFlag += 1;
                    return menuFlag;
                } else {
                    System.out.println("Returning to menu....\n");
                    menuFlag = 2;
                }
            }
        }

        // if menuFlag = 0 -> capacity not reached
        // if menuFlag = 1 -> capacity reached, user waits
        // if menuFlag = 2 -> capacity reached, user does not wait
        return menuFlag;
    }

    // function to prompt user entering the area
    public static void enterArea(int user_input, int waitCheck) {

        boolean closeContact = false; // flag to check if the user is too close to another person
        // Scanner input = new Scanner(System.in);

        System.out.println("You have successfully entered the area.\n");

        // for (int i = 0; i < restrictedSpotsArray.length; i++) {
        // System.out.println("Capacity: " + currentCapacities[i]);
        // }

        if (waitCheck == 0) {
            System.out.println("The current capacity of this area: " + currentCapacities[user_input - 1]); // Prints out
                                                                                                           // the
                                                                                                           // current
                                                                                                           // capacity
        } else {
            int maxCapacity = restrictedSpotsArray[user_input - 1].getSpot_Maximum_Capacity();
            System.out.println("The current capacity of this area: "
                    + (maxCapacity - 1));
        }

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
                closeContact = true;
                System.out.printf(
                        "You are too close to the person to the %s of you. Please move away %.2f meters away.\n",
                        arr[i], diff);
            }
        }

        if (closeContact == true) {
            contactStatus = "Close Contact";
        }

        // using for each statement to get details of the area
        for (RestrictedSpots.restrictedSpots restrictedSpots2 : restrictedSpotsArray) {
            restrictedSpots2.getSpotID();

            // compare user input to the spotID of the locations; if they are equal, get the
            // rest of the data
            if (user_input == restrictedSpots2.getSpotID()) {
                String spotName = restrictedSpots2.getSpotName();
                int spotArea = restrictedSpots2.getSpot_area();
                double avg_time = restrictedSpots2.getSpot_Permitted_Average_Time();
                int max_Cap = restrictedSpots2.getSpot_Maximum_Capacity();

                System.out.println("Enter your User ID: ");
                int UserID = input.nextInt();
                input.nextLine();
                System.out.println("Enter your Name: ");
                String UserName = input.nextLine();

                // checking if user waited to enter or not
                // if waitCheck = 0, user did not wait
                // if waitCheck = 1, user waited

                JFrame myJFrame = new JFrame();
                double timeRemaining;
                timeRemaining = avg_time * 60;

                while (timeRemaining > 0) {
                    if (waitCheck == 0) {
                        // this value is meant to represent the number of people, INCLUDING the user.
                        int currentCapacity = (currentCapacities[user_input - 1] + 1);
                        double area = (double) (currentCapacity / (double) max_Cap
                                * spotArea) * 10;

                        System.out.println("\n\033[H\033[2J" +
                                "\nUser ID: " + UserID +
                                "\nFull Name: " + UserName +
                                "\nSelected Spot ID: " + restrictedSpots2.getSpotID() +
                                "\nSelected Spot Name: " + spotName +
                                "\nSelected Spot Area: " + restrictedSpots2.getSpot_area() + "m^2" +
                                "\nSelected Spot Current Capacity: " + currentCapacity +
                                "/" + restrictedSpots2.getSpot_Maximum_Capacity() +
                                "\nTotal area occupied: " + area + "%" +
                                "\nSelected Spot Permitted Average Time: " + avg_time + " minutes" +
                                "\nContact Status: " + contactStatus + "\n\n");

                    } else {
                        System.out.println("\n\033[H\033[2J" +
                                "\nUser ID: " + UserID +
                                "\nFull Name: " + UserName +
                                "\nSelected Spot ID: " + restrictedSpots2.getSpotID() +
                                "\nSelected Spot Name: " + spotName +
                                "\nSelected Spot Area: " + restrictedSpots2.getSpot_area() + "m^2" +
                                "\nSelected Spot Current Capacity: "
                                + restrictedSpots2.getSpot_Maximum_Capacity() +
                                "/" + restrictedSpots2.getSpot_Maximum_Capacity() +
                                "\nTotal area occupied: 100%" +
                                "\nSelected Spot Permitted Average Time: " + avg_time + " minutes" +
                                "\nContact Status: " + contactStatus + "\n\n");
                    }

                    exitFlag = 0;

                    myJFrame.setVisible(true);

                    System.out.println(
                            "\nTime remaining: " + timeRemaining + " seconds" +
                                    "\nPress '1' to leave the room");

                    myJFrame.addKeyListener(new KeyAdapter() {
                        public void keyPressed(KeyEvent e) {

                            if (e.getKeyCode() == KeyEvent.VK_1) {
                                exitFlag = 1;
                            }
                        }
                    });

                    try {
                        Thread.sleep(1000); // sleep for 1 second
                    } catch (InterruptedException e) { // Catch the error if system fails -- Print the Stack
                        e.printStackTrace();
                    }

                    if (exitFlag == 1) {
                        myJFrame.setVisible(false);
                        break;
                    }

                    timeRemaining--;
                }

            }

            break;
        }
    }
}
