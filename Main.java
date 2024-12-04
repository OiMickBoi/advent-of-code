import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
  
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

    // public static int eval() {
    //     int safeReports = 0;
    //     for (ArrayList<Integer> line : list) {
    //         int t = 0;
    //         int len = line.size();

    //         isSafe(line);
    //         if (t == len-1) safeReports++;
    //     }
    //     return safeReports;
    // }

    // public static boolean isSafe(ArrayList<Integer> line) {
    //     for (int i = 0; i < len-1; i++) {
    //         int x = line.get(i);
    //         int y = line.get(i+1);
    //         if (isSafe(x, y)) t++;
    //     }
    // }

    
    public static boolean isIncreasing(int x, int y) {
        System.out.println(y + " - " + x);
            if (y-x > 0 && y-x < 4) {
                return true;
            }
        return false;
    }
    
    public static boolean isDecreasing(int x, int y) {
        System.out.println(x + " - " + y);
            if (x-y > 0 && x-y < 4) {
                return true;
            }
        return false;
    }

    public static void main(String[] args) {
        init();

        System.out.println(isIncreasing(1,2));
        System.out.println(isIncreasing(1,3));
        System.out.println(isIncreasing(1,4));
        System.out.println(isIncreasing(1,5)); // too much
        System.out.println(isIncreasing(1,0)); // decreasing

        System.out.println(isDecreasing(0,1));
        System.out.println(isDecreasing(1,0));
        System.out.println(isDecreasing(2,1));
        System.out.println(isDecreasing(3,1));
        System.out.println(isDecreasing(4,1));
        System.out.println(isDecreasing(5,1)); // toomuch
        
        // System.out.println(eval());
    }
}

 

