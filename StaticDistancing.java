import java.util.Scanner;

public class StaticDistancing {
    public static int OutPatientMainAreaCapacity = 10;
    public static int OutPatientSubAreaCapacity = 5;
    public static int ICUAreaCapacity = 5;
    public static int InPatientMainAreaCapacity = 20;

    public static float OutPatientMainAreaTime = 20;
    public static float OutPatientSubAreaTime = 10;
    public static float ICUAreaTime = 10;
    public static float InPatientMainAreaTime = 40;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int user_input = 0;

        System.out.println("Welcome to the Hospital!");

        // using a while loop to keep the application running until the user exits
        while (true) {
            System.out.println(
                    "Select the location you would like to enter:\n1: Out-patient visitors' Main Waiting Area\n2: Out-patient Visitors' Sub-waiting Area\n3: Intensive Care Unit Visiting Area\n4: In-patient Visitors' Waiting Area\n5: Exit Application");

            user_input = input.nextInt();
            input.nextLine(); // consume the newline character left by nextInt()

            // switch case to select the location the user wants to enter
            switch (user_input) {
                case 1: {
                    System.out.println("You have selected the Out-patient visitors' Main Waiting Area");
                    break;
                }
                case 2: {
                    System.out.println("You have selected the Out-patient Visitors' Sub-waiting Area");
                    break;
                }
                case 3: {
                    System.out.println("You have selected the Intensive Care Unit Visiting Area");
                    break;
                }
                case 4: {
                    System.out.println("You have selected the In-patient Visitors' Waiting Area");
                    break;
                }
                case 5: {
                    System.out.println("Thank you for using the application");
                    System.exit(user_input);
                }
            }

            int menuCheck = enterCheck(user_input); // calling the method to check if the user can enter the area

            // if the value returned by enterCheck() is 1, return back to menu. else, enter
            // to area selected
            if (menuCheck == 1) {
                break;
            } else {
                enterArea();
            }
        }

        input.close();
    }

    // method to get the maximum capacities of each location
    public static int[] getMaxCapacity() {
        int[] maxCapacities = { OutPatientMainAreaCapacity, OutPatientSubAreaCapacity, ICUAreaCapacity,
                InPatientMainAreaCapacity };
        return maxCapacities;
    }

    // method to get the maximum time a user can wait in each location
    public static float[] getMaxTime() {
        float[] maxTimes = { OutPatientMainAreaTime, OutPatientSubAreaTime, ICUAreaTime, InPatientMainAreaTime };
        return maxTimes;
    }

    // method to check if the user can enter the area
    public static int enterCheck(int user_input) {
        DynamicDistancing currentCapacities = new DynamicDistancing(); // creating object of DynamicDistancing class to
                                                                       // access its methods
        
        int flag = 0; // flag to check if the room has reached its maximum capacity
        int menuFlag = 0; // flag to check if the user wants to wait or not

        currentCapacities.getCurrCapacity(); // getting the current capacities of each location
        int[] maxCapacities = getMaxCapacity(); // getting the maximum capacities of each location

        // comparing values of current and maximum capacities
        for (int i = 0; i < maxCapacities.length; i++) {
            if (user_input == i + 1) {
                if (currentCapacities.currentCapacities[i] < maxCapacities[i]) {
                    System.out.println("You can enter the area");
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
                Scanner input = new Scanner(System.in);
                int inputWait = input.nextInt();
                input.nextLine();
                input.close();
                if (inputWait == 1) {
                    System.out.println("You have entered the area.");
                    return menuFlag;
                } else {
                    System.out.println("Returning to menu....\n");
                    menuFlag = 1;
                }
            }
        }
        return menuFlag;
    }

    public static void enterArea() {
        System.out.println("You have successfully entered the area.");
    }
}
