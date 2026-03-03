import java.util.HashSet;

public class FilterChatApp {
    HashSet<String> bannedWords = new HashSet<>(){
        {
            add("badword");
            add("anotherbadword");
            add("offensiveword");
        }
    };

    public void addBannedWord(String word) {
        bannedWords.add(word);
    }

    public boolean isBanned(String word) {
        return bannedWords.contains(word);
    }

    public boolean filterMessage(String message) {
        String[] words = message.split(" ");
        for (String word : words) {
            if (isBanned(word)) {
                return false; 
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        FilterChatApp chatApp = new FilterChatApp();

        chatApp.addBannedWord("newbadword");

        String message1 = "This is a clean message";
        String message2 = "This message contains a badword";

        String word1 = "anotherbadword";
        String word2 = "cleanword";

        System.out.println("Message 1 is valid? " + chatApp.filterMessage(message1)); 
        System.out.println("Message 2 is valid? " + chatApp.filterMessage(message2)); 
        System.out.println("Word 1 is banned? " + chatApp.isBanned(word1)); 
        System.out.println("Word 2 is banned? " + chatApp.isBanned(word2)); 
    }

}
