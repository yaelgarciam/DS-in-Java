import java.util.*;

public class FrequencyCounter {

    HashMap<String, Integer> frequencyMap = new HashMap<>();
    public void addWord(String word) {
        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
    }

    public int getFrequency(String word) {
        return frequencyMap.getOrDefault(word, 0);
    }

    public void removeWord(String word) {
        frequencyMap.remove(word);
    }

    public void showFrequenciesAlphabetically() {
        List<String> words = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word + ": " + frequencyMap.get(word));
        }
    }

    public static void main(String[] args) {
        FrequencyCounter counter = new FrequencyCounter();

        counter.addWord("hello");
        counter.addWord("world");
        counter.addWord("hello");
        counter.addWord("java");

        System.out.println("Frequency of 'hello': " + counter.getFrequency("hello")); // 2
        System.out.println("Frequency of 'world': " + counter.getFrequency("world")); // 1
        System.out.println("Frequency of 'java': " + counter.getFrequency("java")); // 1

        System.out.println("\nFrequencies in alphabetical order:");
        counter.showFrequenciesAlphabetically();

        counter.removeWord("world");
        System.out.println("\nAfter removing 'world':");
        counter.showFrequenciesAlphabetically();
    }

}