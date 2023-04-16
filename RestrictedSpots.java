public class RestrictedSpots {

    restrictedSpots OPmain_waiting_area = new OP_main_waiting_area(1, "Main Waiting Area", 10, 50, 30);
    restrictedSpots OPsub_waiting_area = new OP_sub_waiting_area(2, "Sub Waiting Area", 20, 50, 10);
    restrictedSpots ICU_waiting_area = new ICU_Visiting_area(3, "ICU Waiting Area", 35, 50, 5);
    restrictedSpots IP_waiting_area = new IP_main_waiting_area(4, "Inpatient Waiting Area", 50, 50, 10);
    restrictedSpots research_center = new Research_center(5, "Research Center", 10, 50, 20);
    restrictedSpots surgery_room = new Surgery_room(6, "Surgery Room", 23, 120, 5);
    

    public static class restrictedSpots {
        private int Spot_ID;
        private String Spot_Name;
        private int Spot_area;
        private double Spot_Permitted_Average_Time;
        private int Spot_Maximum_Capacity;

        public restrictedSpots(int Spot_ID, String Spot_Name, int Spot_area, double Spot_Permitted_Average_Time,
                int Spot_Maximum_Capacity) {
            this.Spot_ID = Spot_ID;
            this.Spot_Name = Spot_Name;
            this.Spot_area = Spot_area;
            this.Spot_Permitted_Average_Time = Spot_Permitted_Average_Time;
            this.Spot_Maximum_Capacity = Spot_Maximum_Capacity;
        }

        public restrictedSpots() {

        }

        public int getSpotID() {
            return Spot_ID;
        }

        public String getSpotName() {
            return Spot_Name;
        }

        public int getSpot_area() {
            return Spot_area;
        }

        public double getSpot_Permitted_Average_Time() {
            return Spot_Permitted_Average_Time;
        }

        public int getSpot_Maximum_Capacity() {
            return Spot_Maximum_Capacity;
        }
    }

    public static class OP_main_waiting_area extends restrictedSpots {

        public OP_main_waiting_area(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }
    }

    // Subclass for Research Center
    public static class Research_center extends restrictedSpots {

        public Research_center(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }

    }

    public static class Surgery_room extends restrictedSpots {

        public Surgery_room(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }
    }

    public static class OP_sub_waiting_area extends restrictedSpots {

        public OP_sub_waiting_area(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);
        }

    }

    public static class ICU_Visiting_area extends restrictedSpots {

        public ICU_Visiting_area(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);

        }
    }

    public static class IP_main_waiting_area extends restrictedSpots {

        public IP_main_waiting_area(int spotID, String spotName, int spotArea, int spotPermittedAverageTime,
                int spotMaximumCapacity) {
            super(spotID, spotName, spotArea, spotPermittedAverageTime, spotMaximumCapacity);

        }
    }
}
