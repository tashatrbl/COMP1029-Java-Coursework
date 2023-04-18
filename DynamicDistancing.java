import java.lang.Math;

public class DynamicDistancing {
    public int[] currentCapacities;

    public int[] getCurrCapacity(int user_input) {
        int[] maxCapacities = StaticDistancing.getMaxCapacity(user_input);
        currentCapacities = new int[maxCapacities.length];

        for (int i = 0; i < maxCapacities.length; i++) {
            int capacity = (int) (Math.random() * (maxCapacities[i] + 1));
            currentCapacities[i] = capacity;
        }
        return currentCapacities;
    }

}


