package Aula01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dic1.txt"));
        HashMap<String, String> dict = new HashMap<String, String>();
        while (sc.hasNextLine()) {
            String parts[] = sc.nextLine().split(" - ");
            dict.put(parts[1], parts[0]);
        }

        sc.close();
    }
}
