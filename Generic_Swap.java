package CodingQuestion;

public class Generic_Swap {
	
	public static <T> void swap(T[] array) {
        if (array.length < 2) {
            return; // No swap needed for arrays with less than 2 elements
        }
        T temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + java.util.Arrays.toString(intArray));
        swap(intArray);
        System.out.println("After swap: " + java.util.Arrays.toString(intArray));

        String[] strArray = {"first", "middle", "last"};
        System.out.println("Before swap: " + java.util.Arrays.toString(strArray));
        swap(strArray);
        System.out.println("After swap: " + java.util.Arrays.toString(strArray));
    }

}
