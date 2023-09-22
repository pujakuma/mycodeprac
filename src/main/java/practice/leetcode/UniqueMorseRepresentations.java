package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        String[] words1={"gin","zen","gig","msg"};
        int count=uniqueMorseRepresentations(words1);
        System.out.println(count);
    }
    public static int uniqueMorseRepresentations(String[] words) {
        final String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> transformations = new HashSet<>();
        for (final String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (final char c : word.toCharArray())
                transformation.append(morse[c - 'a']);
            transformations.add(transformation.toString());

        }
        return transformations.size();
    }
}

