package CodingQuestion;

import java.util.LinkedList;

public class Generic_Map {

    public static class MyMap<K, V> { // Make MyMap static
        private LinkedList<Entry<K, V>>[] table;
        private int capacity = 16;

        @SuppressWarnings("unchecked") // Suppress warning for array creation
        public MyMap() {
            table = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(K key) {
            return key == null ? 0 : Math.abs(key.hashCode() % capacity); // Use abs to avoid negative indices
        }

        public void put(K key, V value) {
            int index = hash(key);
            LinkedList<Entry<K, V>> entries = table[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Update existing key
                    return;
                }
            }
            entries.add(new Entry<>(key, value)); // Add new key-value pair
        }

        public V get(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> entries = table[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    return entry.value; // Return value if key is found
                }
            }
            return null; // Key not found
        }

        public boolean containsKey(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> entries = table[index];
            for (Entry<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    return true; // Key exists
                }
            }
            return false; // Key does not exist
        }

        private static class Entry<K, V> {
            K key;
            V value;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'two': " + map.get("two")); // Output: 2
        System.out.println("Contains key 'three': " + map.containsKey("three")); // Output: true
        System.out.println("Contains key 'four': " + map.containsKey("four")); // Output: false
    }
}
