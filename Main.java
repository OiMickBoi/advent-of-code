import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static HashMap<Integer,Integer> map = new HashMap<>();
  
    public static void init() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                list.add(Integer.parseInt(words[0]));
                int key = Integer.parseInt(words[1]);

                key = Integer.parseInt(words[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());

        }

        
    }

    
    public static int cal() {
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i);
            // Use getOrDefault to handle null values from map
            if (key != null) {
                sum += key * map.getOrDefault(key, 0);
            }
        
            // if (key != null) {
            // }
        }
        return sum;
    }

    public static void main(String[] args) {
        init();
        System.out.println(cal());
        
    }
}
 

