import java.util.Scanner;


public class StaticDistancing{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select the location you would like to enter:\n 1: Out-patient visitors' Main Waiting Area\n2: Out-patient Visitors' Sub-waiting Area\n3: Intensive Care Unit Visiting Area\n 4: In-patient Visitors' Waiting Area");

        int user_input = input.nextInt();
        input.close();

        if (user_input == 1 ) {
            System.out.println("You have selected the Out-patient visitors' Main Waiting Area");
        } else if (user_input == 2) {
            System.out.println("You have selected the Out-patient Visitors' Sub-waiting Area");
        } else if (user_input == 3) {
            System.out.println("You have selected the Intensive Care Unit Visiting Area");
        } else if (user_input == 4) {
            System.out.println("You have selected the In-patient Visitors' Waiting Area");
        } else {
            System.out.println("Invalid input");
        }
        // System.out.println("Username is: " + user_input);  // Output user input
    }
}

