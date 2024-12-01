import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Main {
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    public static void init() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                list1.add(Integer.parseInt(words[0]));
                list2.add(Integer.parseInt(words[1]));
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        
    }

    public static int cal() {
        Collections.sort(list1);
        Collections.sort(list2);
        int sum = 0;

        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list1.get(i) - list2.get(i));
        }

        return sum;
        
    }

    public static void main(String[] args) {
        init();
        System.out.println(cal());
        
    }
}
 

