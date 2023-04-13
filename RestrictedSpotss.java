import java.util.Random;
import java.util.Scanner;

public class RestrictedSpotss {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        
        while (continueRunning) {
            RestrictedSpot researchCenter = new RestrictedSpot(2, "Research Center", "", 50, 20);
            RestrictedSpot surgeryRoom = new RestrictedSpot(3, "Surgery Room", "", 120, 5);

            System.out.println("Enter 2 for Research Center or 3 for Surgery Room:");
            int choice = input.nextInt();
            int timeRemaining = 0;

            if (choice == 2) {
                int randomCapacity = researchCenter.getSpotMaximumCapacity() + (new Random().nextInt(11));
                System.out.println("Spot Name: " + researchCenter.getSpotName());
                System.out.println("Spot ID: " + researchCenter.getSpotID());
                System.out.println("Random Maximum Capacity: " + randomCapacity);
                System.out.println("Permitted Average Time: " + researchCenter.getSpotPermittedAverageTime());
                if (researchCenter.getSpotID() == 2) {
                    System.out.println("Timer Started!");
                    timeRemaining = researchCenter.getSpotPermittedAverageTime();
                    while (timeRemaining > 0) {
                        System.out.println("Time remaining: " + timeRemaining + " seconds");
                        try {
                            Thread.sleep(1000); // sleep for 1 second
                        } catch (InterruptedException e) { //Catch the error if system fails -- Print the Stack
                            e.printStackTrace();
                        }
                        timeRemaining--;
                    }
                    System.out.println("Time's up!");
                }
            } else if (choice == 3) {
                int randomCapacity = surgeryRoom.getSpotMaximumCapacity() + (new Random().nextInt(11));
                System.out.println("Spot Name: " + surgeryRoom.getSpotName());
                System.out.println("Spot ID: " + surgeryRoom.getSpotID());
                System.out.println("Random Maximum Capacity: " + randomCapacity);
                System.out.println("Permitted Average Time: " + surgeryRoom.getSpotPermittedAverageTime());
                if (surgeryRoom.getSpotID() == 3) {
                    System.out.println("Timer Started!");
                    timeRemaining = surgeryRoom.getSpotPermittedAverageTime();
                    while (timeRemaining > 0) {
                        System.out.println("Time remaining: " + timeRemaining + " seconds");
                        try {
                            Thread.sleep(1000); // sleep for 1 second
                        } catch (InterruptedException e) { //Catch the error if system fails -- Print the Stack
                            e.printStackTrace();
                        }
                        timeRemaining--;
                    }
                    System.out.println("Time's up!");
                }
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println("Do you want to continue? (y/n)");
            String answer = input.next();
            if (answer.equalsIgnoreCase("n")) {
                continueRunning = false;
            }
        }
    }

    // Base class for restricted spots
    public static class RestrictedSpot {
        private int spotID;
        private String spotName;
        private String spotArea;
        private int spotPermittedAverageTime;
        private int spotMaximumCapacity;

        public RestrictedSpot(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            this.spotID = spotID;
            this.spotName = spotName;
            this.spotArea = spotArea;
            this.spotPermittedAverageTime = spotPermittedAverageTime;
            this.spotMaximumCapacity = spotMaximumCapacity;
        }

        public int getSpotID() {
            return spotID;
        }

        public String getSpotName() {
            return spotName;
        }

        public String getSpotArea() {
            return spotArea;
        }

        public int getSpotPermittedAverageTime() {
            return spotPermittedAverageTime;
        }

        public int getSpotMaximumCapacity() {
            return spotMaximumCapacity;
        }
    }
}