package Aula01;

import java.util.*;
import java.io.*;

public class ex04 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("numbers.txt"));
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        while (sc.hasNextLine()) {
            String parts[] = sc.nextLine().split(" ");
            dict.put(parts[2], Integer.parseInt(parts[0]));
        }

        sc.close();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine(); // Read the entire line of input

        String[] words = userInput.split(" "); // Split the line into words

        StringBuilder out = new StringBuilder();
        for (String word : words) {
            if (dict.containsKey(word)) {
                out.append(dict.get(word)).append(" ");
            } else {
                out.append(word).append(" ");
            }
        }

        System.out.println(out);
        scanner.close();;
    }
}
