package CodingQuestion;

public class Container<T> {
	
	private T object;

    // Method to set the object
    public void set(T object) {
        this.object = object;
    }

    // Method to retrieve the object
    public T get() {
        return object;
    }

    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>();
        stringContainer.set("Hello, World!");
        System.out.println(stringContainer.get());

        Container<Integer> integerContainer = new Container<>();
        integerContainer.set(42);
        System.out.println(integerContainer.get());
    }
}
