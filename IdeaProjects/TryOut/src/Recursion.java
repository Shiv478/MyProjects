import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("hi", "world", "thee", "Rasmussen"));
        int minLength = 10;
        int maxLength = 13;

        backTracking(words, "", new boolean[words.size()], minLength, maxLength);
    }

    public static void backTracking(List<String> allWords, String wordSentence, boolean[] used, int low, int high) {
        // Include period in the sentence length
        int sentenceLength = wordSentence.length() + (wordSentence.isEmpty() ? 0 : 1); // +1 for the period
        if (sentenceLength >= low && sentenceLength <= high) {
            System.out.println(wordSentence + ".");
        }

        // Prune if already too long
        if (sentenceLength >= high) return;

        // Try adding each unused word
        for (int i = 0; i < allWords.size(); i++) {
            if (!used[i]) { // If the word has not been used yet
                used[i] = true; // Mark as used
                String newSentence = wordSentence.isEmpty() ? allWords.get(i) : wordSentence + " " + allWords.get(i);
                backTracking(allWords, newSentence, used, low, high);
                used[i] = false; // Backtrack and unmark
            }
        }
    }
}
