import java.util.Random;
import java.util.Scanner;

public class RestrictedSpots{
    public static void main(String[] args) {
        restrictedSpots h = new restrictedSpots();
        Main_waiting_area foo = new Main_waiting_area(2, "balls", "arf", 4, 2);
        System.out.println(foo.getSpotID());

        restrictedSpots research_center = new Research_center(2, "Research Center", "", 50, 20);
        restrictedSpots surgery_room = new Surgery_room(3, "Surgery Room", "", 120, 5);
        
        Scanner input = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Enter 2 for Research Center or 3 for Surgery Room, or 0 to exit:");
            choice = input.nextInt();
            
            if (choice == 2) {
                int randomCapacity = research_center.Spot_Maximum_Capacity() + (int)(Math.random() * 10) + 1;
                System.out.println("Spot Name: " + research_center.Spot_Name());
                System.out.println("Spot ID: " + research_center.getSpotID());
                System.out.println("Random Maximum Capacity: " + randomCapacity);
                System.out.println("Permitted Average Time: " + research_center.Spot_Permitted_Average_Time());
                System.out.println("Random Capacity: " + ((Research_center)research_center).getSpotRandomCapacity());
            } else if (choice == 3) {
                int randomCapacity = surgery_room.Spot_Maximum_Capacity() + (int)(Math.random() * 10) + 1;
                System.out.println("Spot Name: " + surgery_room.Spot_Name());
                System.out.println("Spot ID: " + surgery_room.getSpotID());
                System.out.println("Random Maximum Capacity: " + randomCapacity);
                System.out.println("Permitted Average Time: " + surgery_room.Spot_Permitted_Average_Time());
            }
            
        } while (choice != 0);
    }

    // Method / Function
    public static class restrictedSpots{
        private int Spot_ID;
        private String Spot_Name;
        private String Spot_Area;
        private int Spot_Permitted_Average_Time;
        private int Spot_Maximum_Capacity;
        private Random random;

        public restrictedSpots(int Spot_ID, String Spot_Name, String Spot_area, int Spot_Permitted_Average_Time, int Spot_Maximum_Capacity){
            this.Spot_ID = Spot_ID;
            this.Spot_Name = Spot_Name;
            this.Spot_Area = Spot_Area;
            this.Spot_Permitted_Average_Time = Spot_Permitted_Average_Time;
            this.random = new Random();
            this.Spot_Maximum_Capacity = Spot_Maximum_Capacity + random.nextInt(11);
        }
//comment
        public restrictedSpots(){
            // RestrictedSpots main_waiting_area = new RestrictedSpots();
            // main_waiting_area.Spot_ID = 1;
            // main_waiting_area.Spot_Name="Main Waiting Area";
            // main_waiting_area.Spot_area="";
            // main_waiting_area.Spot_Permitted_Average_Time=50;
            // main_waiitng_area.Spot_Maximum_Capacity=30;
        }

        public int getSpotID(){
            return Spot_ID;
        }

        public String Spot_Name(){
            return Spot_Name;
        }

        public String Spot_area(){
            return Spot_Area;
        }

        public int Spot_Permitted_Average_Time(){
            return Spot_Permitted_Average_Time;
        }

        public int Spot_Maximum_Capacity(){
            return Spot_Maximum_Capacity;
        }
    }

    public static class Main_waiting_area extends restrictedSpots {
        
        public Main_waiting_area(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }

        public Main_waiting_area() {
            super(1, "Main Waiting Area", "", 50, 30);
        }
    }

    // Subclass for Research Center
    public static class Research_center extends restrictedSpots {
        
        private int Spot_Random_Capacity;
        
        public Research_center(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
            Random r = new Random();
            this.Spot_Random_Capacity = r.nextInt(10) + 1;
        }
        
        public int getSpotRandomCapacity() {
            return Spot_Random_Capacity;
        }

    }

    public static class Surgery_room extends restrictedSpots {
        
        public Surgery_room(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }
    }
}
