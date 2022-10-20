package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "src\\com\\company\\dict.txt";
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(file);
        TreeMap<String, Integer> dict = new TreeMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words){
                word = word.replaceAll("[!\"#$%&'()*+,./:;<=>?@\\[\\]^_`{|}~]", "").toLowerCase();
                if (dict.containsKey(word)) {
                    dict.put(word, dict.get(word) + 1);
                } else {
                    dict.put(word, 1);
                }
            }
        }
        br.close();
        if (dict.size() > 0) {
            System.out.printf("%30s%3s%12s\n", "СЛОВО", "|", "КОЛИЧЕСТВО");
            System.out.printf("%30s%3s%15s\n","--------------------", "|","-------------");
            for (String str: dict.keySet()) {
                System.out.printf("%30s", str);
                System.out.printf("%3s", "|");
                System.out.printf("%4s\n", dict.get(str));
            }
            int max = 1;
            SortedSet<Integer> maxValue = new TreeSet<>(dict.values());
            System.out.println("Следующие слова встречаются в тексте максимальное количество раз.\nПо " + maxValue.last() + " поторений у слов:");
            for (String str : dict.keySet()) {
                if (dict.get(str).equals(maxValue.last())) {
                    System.out.println(str);
                }
            }
        } else System.err.println("Нет слов в файле");
    }
}
