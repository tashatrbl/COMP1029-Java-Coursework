//Name: Adyan Dean bin Wafdi Kamil 
//ID: 20413774
//Name: Carmel Natasha Barnabas 
//ID: 20509430 
//Name: Rezmana Agung Wibawa 
//ID: 20410045
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


