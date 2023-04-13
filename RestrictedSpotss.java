import java.util.Random;
import java.util.Scanner;

public class RestrictedSpotss {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RestrictedSpot researchCenter = new RestrictedSpot(2, "Research Center", "", 50, 20);
        RestrictedSpot surgeryRoom = new RestrictedSpot(3, "Surgery Room", "", 120, 5);
        
        System.out.println("Enter 2 for Research Center or 3 for Surgery Room:");
        int choice = input.nextInt();
        
        if (choice == 2) {
            int randomCapacity = researchCenter.getSpotMaximumCapacity() + (new Random().nextInt(11));
            System.out.println("Spot Name: " + researchCenter.getSpotName());
            System.out.println("Spot ID: " + researchCenter.getSpotID());
            System.out.println("Random Maximum Capacity: " + randomCapacity);
            System.out.println("Permitted Average Time: " + researchCenter.getSpotPermittedAverageTime());
        } else if (choice == 3) {
            int randomCapacity = surgeryRoom.getSpotMaximumCapacity() + (new Random().nextInt(11));
            System.out.println("Spot Name: " + surgeryRoom.getSpotName());
            System.out.println("Spot ID: " + surgeryRoom.getSpotID());
            System.out.println("Random Maximum Capacity: " + randomCapacity);
            System.out.println("Permitted Average Time: " + surgeryRoom.getSpotPermittedAverageTime());
        } else {
            System.out.println("Invalid choice.");
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
