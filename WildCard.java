package CodingQuestion;

import java.util.ArrayList;
import java.util.List;

public class WildCard {
    
    public static class NumberUtils { // Make NumberUtils static
        public static double sumList(List<? extends Number> list) {
            double sum = 0.0;
            for (Number number : list) {
                sum += number.doubleValue(); // Convert to double and add to sum
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        
        // Call the static method sumList from NumberUtils
        System.out.println("Sum of intList: " + NumberUtils.sumList(intList)); // Output: 6.0
        System.out.println("Sum of doubleList: " + NumberUtils.sumList(doubleList)); // Output: 4.0
    }
}
