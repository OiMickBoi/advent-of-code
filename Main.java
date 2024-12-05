import java.awt.JobAttributes.MultipleDocumentHandlingType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {
    static int sum = 0;

    public static final Pattern MUL_PATTERN = Pattern.compile("mul\\(([0-9]+),([0-9]+)\\)");
  
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
        Matcher matcher = MUL_PATTERN.matcher(string);

        while (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));

            sum += num1 * num2;
        }
        
    }

    public static void main(String[] args) {
        init();
        System.out.println(sum);
    }
}
