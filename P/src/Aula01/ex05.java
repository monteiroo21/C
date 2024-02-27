package Aula01;

import java.util.*;
import java.io.*;

public class ex05 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("numbers.txt"));
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        while (sc.hasNextLine()) {
            String parts[] = sc.nextLine().split(" - ");
            dict.put(parts[1], Integer.parseInt(parts[0]));
        }

        sc.close();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine(); // Read the entire line of input

        String[] words = userInput.split(" "); // Split the line into words

        StringBuilder out = new StringBuilder();
        List<Integer> arr = new ArrayList<Integer>();
        for (String word : words) {
            out.append(word).append(" ");
            if (dict.containsKey(word)) {
                arr.add(dict.get(word));
            } else {
                System.err.println("ERRROR! You inserted a wrong number!");
            }
        }

        int num = arr.get(0);
        int total = arr.get(0);
        int sum = 0;
        for (int i = 1; i < arr.size(); i++) {
            num = arr.get(i);
            if (num > total) {
                total *= num;
            } else {
                sum += total;
                total = 0;
                total += num;
            }
        }
        sum += num;
        out.append("-> ").append(sum);

        System.out.println(out);
        scanner.close();
    }
}
