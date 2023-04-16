import java.lang.Math;

public class DynamicDistancing {
    public int[] currentCapacities;
    public int OPMainAreaCurrCapacity;
    public int OPSubAreaCurrCapacity;
    public int ICUCurrCapacity;
    public int IPMainAreaCurrCapacity;


    // public int getCurrentCapacity(int SpotID){
    //     for (int i = 0; i < currentCapacities.length; i++){
    //         switch (SpotID) {
    //             case 1:
    //                 return OPMainAreaCurrCapacity; 
    //             case 2:
    //                 return OPSubAreaCurrCapacity;
                    
    //             case 3:
    //                 return ICUCurrCapacity;
                    
    //             case 4:
    //                 return IPMainAreaCurrCapacity;
                    
    //             default:
    //                 break;
    //         }
    //     }
    //     return SpotID;
    // }

    

    public void setCurrCapacity() {
        int[] maxCapacities = StaticDistancing.getMaxCapacity();
        currentCapacities = new int[maxCapacities.length];

        for (int i = 0; i < maxCapacities.length; i++) {
            int capacity = (int) (Math.random() * (maxCapacities[i] + 2));
            switch (i) {
                case 0:
                    OPMainAreaCurrCapacity = capacity;
                    break;
                case 1:
                    OPSubAreaCurrCapacity = capacity;
                    break;
                case 2:
                    ICUCurrCapacity = capacity;
                    break;
                case 3:
                    IPMainAreaCurrCapacity = capacity;
                    break;
                default:
                    break;
            }
            currentCapacities[i] = capacity;
        }
    }

    public int[] getCurrentCapacity(){
        return currentCapacities;
    }

}
