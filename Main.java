import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Main {
    // static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
    static HashMap<Integer,Integer> map = new HashMap<>();
  
    public static void init() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String stringLine;
            while ((stringLine = br.readLine()) != null) {
                ArrayList<Integer> line = new ArrayList<>();
                String[] words = stringLine.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    line.add(Integer.parseInt(words[i]));
                }
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static int eval() {
        int safeReports = 0;
        for (ArrayList<Integer> l : list) {
            int t = 0;
            int len = l.size();
            for (int i = 0; i < len-1; i++) {
                int x = l.get(i);
                int y = l.get(i+1);
                if (cal(x, y)) t++;
            }
            if (t == len) safeReports++;
        }
        return safeReports;
    }
    
    public static boolean cal(int x, int y) {
            if (Math.abs(x-y) > 0 && Math.abs(x-y) < 3) {
                return true;
            }
        return false;
    }

    public static void main(String[] args) {
        init();

        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        // }
        System.out.println(eval());
    }
}

// class Main {
//     static ArrayList<Integer> list = new ArrayList<>();
//     static HashMap<Integer,Integer> map = new HashMap<>();
  
//     public static void init() {
//         try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] words = line.split("\\s+");
//                 list.add(Integer.parseInt(words[0]));
//                 int key = Integer.parseInt(words[1]);

//                 key = Integer.parseInt(words[1]);
//                 map.put(key, map.getOrDefault(key, 0) + 1);
//             }
//             br.close();
//         } catch (IOException e) {
//             System.err.println("Error reading file: " + e.getMessage());
//         }
//     }

    
//     public static int cal() {
//         Collections.sort(list);
//         int sum = 0;
//         for (int i = 0; i < list.size(); i++) {
//             Integer key = list.get(i);
//             // Use getOrDefault to handle null values from map
//             if (key != null) {
//                 sum += key * map.getOrDefault(key, 0);
//             }
//         }
//         return sum;
//     }

//     public static void main(String[] args) {
//         init();
//         System.out.println(cal());
//     }
// }
 

