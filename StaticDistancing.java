
import java.util.Scanner;


public class StaticDistancing{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the location you would like to enter");

        String user_input = input.nextLine();
        input.close();
        System.out.println("Username is: " + user_input);  // Output user input
    }
}