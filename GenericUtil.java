package CodingQuestion;

public class GenericUtil {
	
	public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
        // Example usage of findMax
        Integer[] intArray = {1, 3, 7, 0, 5};
        System.out.println("Max Integer: " + findMax(intArray));

        String[] strArray = {"apple", "orange", "banana"};
        System.out.println("Max String: " + findMax(strArray));
	}

}
