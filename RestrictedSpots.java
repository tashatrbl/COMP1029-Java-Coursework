public class RestrictedSpots{
    public static void main(String[] args) {
        restrictedSpots h = new restrictedSpots();
        RestrictedSpot research_center = new RestrictedSpot(2, "Research Center", "", 50, 20);
        Main_waiting_area foo = new Main_waiting_area(2, "balls", "arf", 4, 2);
        System.out.println(foo.getSpotID());
    }

    // Method / Function
    public static class restrictedSpots{
        private int Spot_ID;
        private String Spot_Name;
        private String Spot_Area;
        private int Spot_Permitted_Average_Time;
        private int Spot_Maximum_Capacity;

        public restrictedSpots(int Spot_ID, String Spot_Name, String Spot_area, int Spot_Permitted_Average_Time, int Spot_Maximum_Capacity){
            this.Spot_ID = Spot_ID;
            this.Spot_Name = Spot_Name;
            this.Spot_Area = Spot_Area;
            this.Spot_Permitted_Average_Time = Spot_Permitted_Average_Time;
            this.Spot_Maximum_Capacity = Spot_Maximum_Capacity;
        }

        public restrictedSpots(){
            // RestrictedSpots main_waiting_area = new RestrictedSpots();
            // main_waiting_area.Spot_ID = 1;
            // main_waiting_area.Spot_Name="Main Waiting Area";
            // main_waiting_area.Spot_area="";
            // main_waiting_area.Spot_Permitted_Average_Time=50;
            // main_waiitng_area.Spot_Maximum_Capacity=30;

            // RestrictedSpots research_center = new RestrictedSpots();
            // RestrictedSpots surgery_area = new RestrictedSpots();
            // RestrictedSpots discharge_lounge = new RestrictedSpots();
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

    public static class Main_waiting_area extends RestrictedSpot {
        
        public Main_waiting_area(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }

        public Main_waiting_area() {
            super(1, "Main Waiting Area", "", 50, 30);
        }
    }

    // Subclass for Research Center
    public static class Research_center extends RestrictedSpot {
        
        public Research_center(int spotID, String spotName, String spotArea, int spotPermittedAverageTime, int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }
    }
}
}
