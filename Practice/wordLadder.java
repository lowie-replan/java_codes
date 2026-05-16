package Practice;

import java.util.ArrayList;

public class wordLadder {
    public static void main(String[] args) {
        String firstWord = "apple";
        String secondWord = "babby";

        char[] word1Char = firstWord.toCharArray();
        char[] word2Char = secondWord.toCharArray();

        StringBuilder newString = new StringBuilder();
        ArrayList <String> generatedString = new ArrayList<>();

        for (char c : word1Char) {
            newString.append(c);
            for (int i = 0; i < word2Char.length; i++) {
                if (i == 0) {
                    continue;
                } else {
                    newString.append(word2Char[i]);
                }
            }
            generatedString.add(newString.toString());
            newString = new StringBuilder();
        }

        for (char c : word2Char) {
            newString.append(c);
            for (int i = 0; i < word1Char.length; i++) {
                if (i == 0) {
                    continue;
                } else {
                    newString.append(word1Char[i]);
                }
            }
            generatedString.add(newString.toString());
            newString = new StringBuilder();
        }

        for (int i = 0; i < word2Char.length; i++) {
            word1Char[i] = secondWord.charAt(i);
            for (char c : word1Char) {
                newString.append(c);
            }
            if (!generatedString.contains(newString.toString())) {
                generatedString.add(newString.toString());
            }
            newString = new StringBuilder();
        }
        System.out.println(generatedString);
    }
}
