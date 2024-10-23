package CodingQuestion;

import java.util.List;

public class Bounded_Type_Parameters {
	
	public static void printList(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        
        System.out.println("Integer List:");
        printList(intList);

        System.out.println("Double List:");
        printList(doubleList);
    }

}
