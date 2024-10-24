package CodingQuestion;

public class MultiType_Box {

    public static class Box<T> {  // Make Box static
        private T object;

        public Box(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        public void display() {
            System.out.println("Type: " + object.getClass().getName() + ", Value: " + object);
        }
    }

    public static void main(String[] args) {

    	Box<Integer> integerBox = new Box<>(10);
        integerBox.display();

        Box<String> stringBox = new Box<>("Hello World");
        stringBox.display();
    }
}
