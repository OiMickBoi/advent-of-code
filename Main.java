import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
  
    public static void init() {
       try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
        // try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
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
        if (len <= 1) return true;
    
        // Try without removing any element
        if (isValidSequence(new ArrayList<>(line), true) || 
            isValidSequence(new ArrayList<>(line), false)) {
            return true;
        }
    
        // Try removing each element
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> testLine = new ArrayList<>(line);
            testLine.remove(i);
        
            if (isValidSequence(testLine, true) || 
                isValidSequence(testLine, false)) {
                return true;
            }
        }
    
        return false;
    }

    public static boolean isValidSequence(ArrayList<Integer> line, boolean increasing) {
        if (line.size() <= 1) return true;
    
        for (int i = 0; i < line.size() - 1; i++) {
            int curr = line.get(i);
            int next = line.get(i + 1);
            int diff = increasing ? next - curr : curr - next;
        
            if (diff <= 0 || diff > 3) {
                return false;
            }
        }
        return true;
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

 



//     public static void main(String[] args) {
//         init();

//     //     TestFramework ts = new TestFramework();

//     //     // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1));
//     //     // System.out.println(isSafe(list, list.size()));
//     //     ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1));
//     //     ts.assertTrue(isSafe(test1, test1.size()), 
//     //         "Test 1: Path 7,6,4,2,1 should be safe without removal");

//     //     // Test case 2: Unsafe regardless of removal
//     //     ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9));
//     //     ts.assertTrue(!isSafe(test2, test2.size()), 
//     //         "Test 2: Path 1,2,7,8,9 should be unsafe regardless of removal");

//     //     // Test case 3: Unsafe regardless of removal (descending violation)
//     //     ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1));
//     //     ts.assertTrue(!isSafe(test3, test3.size()), 
//     //         "Test 3: Path 9,7,6,2,1 should be unsafe regardless of removal");

//     //     // Test case 4: Safe after removing one value
//     //     ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
//     //     ts.assertTrue(isSafe(test4, test4.size()), 
//     //         "Test 4: Path 1,3,2,4,5 should be safe by removing 3");

//     //     // Test case 5: Safe after removing duplicate
//     //     ArrayList<Integer> test5 = new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1));
//     //     ts.assertTrue(isSafe(test5, test5.size()), 
//     //         "Test 5: Path 8,6,4,4,1 should be safe by removing one 4");

//     //     // Test case 6: Already safe (ascending)
//     //     ArrayList<Integer> test6 = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
//     //     ts.assertTrue(isSafe(test6, test6.size()), 
//     //         "Test 6: Path 1,3,6,7,9 should be safe without removal");

//     //     // Additional edge cases
//     //     // Test case 7: Single element
//     //     ArrayList<Integer> test7 = new ArrayList<>(Arrays.asList(1));
//     //     ts.assertTrue(isSafe(test7, test7.size()), 
//     //         "Test 7: Single element path should be safe");

//     //     // Test case 8: Two elements
//     //     ArrayList<Integer> test8 = new ArrayList<>(Arrays.asList(1, 2));
//     //     ts.assertTrue(isSafe(test8, test8.size()), 
//     //         "Test 8: Two element ascending path should be safe");

//     //     // Test case 9: All same values
//     //     ArrayList<Integer> test9 = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
//     //     ts.assertTrue(!isSafe(test9, test9.size()), 
//     //         "Test 9: Path with all same values should be unsafe");

//     //     // Test case 10: Empty list
//     //     ArrayList<Integer> test10 = new ArrayList<>();
//     //     ts.assertTrue(isSafe(test10, test10.size()), 
//     //         "Test 10: Empty path should be safe");

//     //     ts.printTestSummary();
        
//         System.out.println(eval());
//     }


    
// // private static TestFramework ts = new TestFramework();
    
// //     public static void main(String[] args) {
// //         // Test Rule 1: All increasing OR all decreasing
// //         testCase(Arrays.asList(1, 3, 5, 7, 9), "Simple increasing sequence", true);
// //         testCase(Arrays.asList(9, 7, 5, 3, 1), "Simple decreasing sequence", true);
// //         testCase(Arrays.asList(1, 3, 2, 4, 5), "Mixed sequence with removable value", true);
// //         testCase(Arrays.asList(5, 3, 4, 2, 1), "Mixed sequence that can't be fixed", false);
        
// //         // Test Rule 2: Adjacent levels must differ by 1-3
// //         testCase(Arrays.asList(1, 2, 3, 4, 5), "Increasing with diff=1", true);
// //         testCase(Arrays.asList(1, 3, 5, 7, 9), "Increasing with diff=2", true);
// //         testCase(Arrays.asList(1, 4, 7, 10), "Increasing with diff=3", true);
// //         testCase(Arrays.asList(1, 5, 8, 10), "Invalid: diff>3", false);
        
// //         // Test Rule 3: Can remove one bad level
// //         testCase(Arrays.asList(1, 2, 5, 3, 4), "Safe after removing 5", true);
// //         testCase(Arrays.asList(5, 4, 3, 6, 2), "Safe after removing 6", true);
// //         testCase(Arrays.asList(1, 2, 6, 7, 3), "Unsafe even with removal", false);
        
// //         // Examples from real data
// //         testCase(Arrays.asList(48, 51, 52, 53, 52), "Real data - removable disruption", true);
// //         testCase(Arrays.asList(86, 87, 88, 91, 91), "Real data - valid increasing", true);
// //         testCase(Arrays.asList(94, 93, 90, 88, 85, 83), "Real data - valid decreasing", true);
// //         testCase(Arrays.asList(70, 67, 70, 71, 74, 71), "Real data - unfixable sequence", false);
        
// //         // Special cases
// //         testCase(Arrays.asList(5, 5, 5, 5, 5), "All same numbers - invalid", false);
// //         testCase(Arrays.asList(1, 4, 2, 5, 3), "Multiple violations - unfixable", false);
// //         testCase(Arrays.asList(1, 3, 6, 4, 5), "Violation of both rules - fixable by removing 6", true);
        
// //         ts.printTestSummary();
// //     }
    
// //     private static void testCase(List<Integer> numbers, String description, boolean expectedResult) {
// //         ArrayList<Integer> test = new ArrayList<>(numbers);
// //         boolean result = isSafe(test, test.size());
// //         ts.assertTrue(result == expectedResult, 
// //             description + " - Expected: " + expectedResult + ", Sequence: " + numbers);
// //     }
// // }
 
// }
