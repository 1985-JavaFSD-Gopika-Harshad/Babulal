package CodingQuestion;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeExample {
	
	public static void main(String[] args) {
		
		ConcurrentHashMap<String, Integer> map =new ConcurrentHashMap<>();
		
		// Create threads to modify the map
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                map.put("Key" + i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 5; i < 15; i++) {
                map.put("Key" + i, i);
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the contents of the map
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
