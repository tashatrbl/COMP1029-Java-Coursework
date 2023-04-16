import java.lang.Math;

public class DynamicDistancing {
    public int[] currentCapacities;
    public static int OPMainAreaCurrCapacity;
    public static int OPSubAreaCurrCapacity;
    public static int ICUCurrCapacity;
    public static int IPMainAreaCurrCapacity;
    public static int RCCurrCapacity;
    public static int SRCurrCapacity;

    public int[] setCurrCapacity(int user_input) {
        int[] maxCapacities = StaticDistancing.getMaxCapacity(user_input);
        currentCapacities = new int[maxCapacities.length];

        for (int i = 0; i < maxCapacities.length; i++) {
            int capacity = (int) (Math.random() * (maxCapacities[i] + 1));
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
                case 4:
                    RCCurrCapacity = capacity;
                    break;
                case 5:
                    SRCurrCapacity = capacity;
                    break;
                default:
                    break;
            }
            currentCapacities[i] = capacity;
        }
        return currentCapacities;
    }

    public int[] getCurrCapacity(int user_input) {
        int[] maxCapacities = StaticDistancing.getMaxCapacity(user_input);
        int[] currCapacityArr = new int[maxCapacities.length];

        for (int i = 0; i < currentCapacities.length; i++) {
            switch (i) {
                case 1:
                    currCapacityArr[i] = OPMainAreaCurrCapacity;
                    break;
                case 2:
                    currCapacityArr[i] = OPSubAreaCurrCapacity;
                    break;
                case 3:
                    currCapacityArr[i] = ICUCurrCapacity;
                    break;
                case 4:
                    currCapacityArr[i] = IPMainAreaCurrCapacity;
                    break;
                case 5:
                    currCapacityArr[i] = RCCurrCapacity;
                    break;
                case 6:
                    currCapacityArr[i] = SRCurrCapacity;
                    break;
                default:
                    break;
            }
        }
        return currCapacityArr;

    }

}
