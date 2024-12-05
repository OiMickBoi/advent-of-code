import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
    static int sum = 0;
  
    public static void init() {
       try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
       // try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String stringLine;
            while ((stringLine = br.readLine()) != null) {
                match(stringLine);
                // String[] words = stringLine.split("\\s+");
                // for (int i = 0; i < words.length; i++) {
                //     line.add(Integer.parseInt(words[i]));
                // }
                // list.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void match(String string) {
        Pattern pattern = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            eval(matcher.group());
        }
        
    }

    public static void eval(String string) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(string);
        ArrayList<Integer> products = new ArrayList<>();


        while (matcher.find()) {
            products.add(Integer.parseInt(matcher.group()));
        }

        int total = 1;
        for (Integer product : products) {
            total *= product;
        }

        sum+=total;
    }


    public static void main(String[] args) {
        init();
        System.out.println(sum);
    }
}
