import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
  
    public static void init() {
        // try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
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

    public static boolean isSafe(ArrayList<Integer> line, int len) {
        boolean isIncreasing = true;
        if (line.get(0) - line.get(1) > 0) isIncreasing = false;

        int t = 1;
        int numBadLevels = 0;
        for (int i = 0; i < len-1; i++) {
            if (isSequence(line.get(i), line.get(i+1), isIncreasing)){
                t++; 
            } 
            else {
                numBadLevels++;
                if (numBadLevels > 1) {
                    return false;
                }
            }
        }
        return t==len;
    }

    public static boolean isSequence(int x, int y, boolean isIncreasing) {
        int diff = isIncreasing ? y-x : x-y;
        return diff > 0 && diff < 4;
    }

    public static int eval() {
        int safeReports = 0;
        for (ArrayList<Integer> line : list) {
            if (isSafe(line, line.size())) safeReports++;
        }
        return safeReports;
    }

    public static void main(String[] args) {
        init();

        // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1));
        // System.out.println(isSafe(list, list.size()));

        
        System.out.println(eval());
    }
}

 

