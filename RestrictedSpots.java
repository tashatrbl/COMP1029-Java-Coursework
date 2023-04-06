public class RestrictedSpots{
    public static void main(String[] args) {
        restrictedSpots h = new restrictedSpots();
        Main_waiting_area foo = new Main_waiting_area(2, "balls", "arf", 4, 2);
        System.out.println(foo.getSpotID());
    }

    public static class restrictedSpots{
        private int Spot_ID;
        private String Spot_Name;
        private String Spot_area;
        private int Spot_Permitted_Average_Time;
        private int Spot_Maximum_Capacity;

        public restrictedSpots(int Spot_ID, String Spot_Name, String Spot_area, int Spot_Permitted_Average_Time, int Spot_Maximum_Capacity){
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
    }

    public static class Main_waiting_area extends restrictedSpots{
        
        public Main_waiting_area(int Spot_ID, String Spot_Name, String Spot_area, int Spot_Permitted_Average_Time, int Spot_Maximum_Capacity){
            super(Spot_ID,Spot_Name,Spot_area,Spot_Permitted_Average_Time,Spot_Maximum_Capacity);
        }

        // public Main_waiting_area(){
        //     super(2, "balls", "arf", 4, 2);
        // }
    }
}
