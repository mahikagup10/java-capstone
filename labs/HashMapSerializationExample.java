import java.io.*;
import java.util.*;

public class HashMapSerializationExample {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        
        // Serialize the HashMap
        FileOutputStream fos = new FileOutputStream("hashmap.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(map);
        oos.close();
        fos.close();
        
        // Deserialize the HashMap
        FileInputStream fis = new FileInputStream("hashmap.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap<String, Integer> deserializedMap = (HashMap<String, Integer>) ois.readObject();
        ois.close();
        fis.close();
        
        // Print the deserialized HashMap
        System.out.println(deserializedMap);
    }
    
}

