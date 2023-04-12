public class RestrictedSpots{
    public static void main(String[] args) {
        Out_main_waiting_area foo = new Out_main_waiting_area();
        System.out.println(foo.getSpotID());
    }

    public static class restrictedSpots{
        private int Spot_ID;
        private String Spot_Name;
        private String Spot_area;
        private double Spot_Permitted_Average_Time;
        private int Spot_Maximum_Capacity;

        public restrictedSpots(int Spot_ID, String Spot_Name, String Spot_area, double Spot_Permitted_Average_Time, int Spot_Maximum_Capacity){
            this.Spot_ID = Spot_ID;
            this.Spot_Name = Spot_Name;
            this.Spot_area = Spot_area;
            this.Spot_Permitted_Average_Time = Spot_Permitted_Average_Time;
            this.Spot_Maximum_Capacity = Spot_Maximum_Capacity;
        }

        public restrictedSpots(){
            
        }

        public int getSpotID(){
            return Spot_ID;
        }

        public String getSpotName(){
            return Spot_Name;
        }

        public String getSpot_area(){
            return Spot_area;
        }

        public double getSpot_Permitted_Average_Time(){
            return Spot_Permitted_Average_Time;
        }

        public int getSpot_Maximum_Capacity(){
            return Spot_Maximum_Capacity;
        }
    }

    public static class Out_main_waiting_area extends restrictedSpots{
        
        public Out_main_waiting_area(){
            super(1,"Main waiting area", "Out Patient Waiting Area", 6.9, 10);
        }

    }

    public static class Sub_waiting_area extends restrictedSpots{
        
        public Sub_waiting_area(){
            super(2,"Sub waiting area", "Sub Patient Waiting Area", 12, 14);
        }

    }

    public static class ICU_Visiting_area extends restrictedSpots{
        
        public ICU_Visiting_area(){
            super(3,"ICU_Visiting_area","Visiting Area",7,14);
        }

    }

    public static class In_Main_waiting_area extends restrictedSpots{
        
        public In_Main_waiting_area(){
            super(4, "In_Main_Waiting_Area", "In-Patient", 4.5, 10);
        }

    }
}
