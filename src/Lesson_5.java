import java.util.*;

public class Lesson_5 {
    //Lesson 2 solution
    public static class PhoneDirectory {
        private Map<String, List<String>> directory;

        public PhoneDirectory() {
            directory = new HashMap<>();
        }

        public void add(String surname, String phoneNumber) {
            directory.putIfAbsent(surname, new ArrayList<>());
            directory.get(surname).add(phoneNumber);
        }

        public List<String> get(String surname) {
            return directory.getOrDefault(surname, new ArrayList<>());
        }
    }
    public static void main(String[] args) {
        //Lesson 2 solution
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Smith", "123-4567");
        phoneDirectory.add("Johnson", "987-6543");
        phoneDirectory.add("Smith", "555-1234");
        phoneDirectory.add("Williams", "777-8888");

        System.out.println("Телефоны Smith: " + phoneDirectory.get("Smith"));
        System.out.println("Телефоны Johnson: " + phoneDirectory.get("Johnson"));
        System.out.println("Телефоны Williams: " + phoneDirectory.get("Williams"));
        System.out.println("Телефоны Brown: " + phoneDirectory.get("Brown"));

        //Lesson 1 solution
        String[] words = {"apple", "banana", "orange", "apple", "kiwi", "banana", "apple", "grape", "kiwi", "peach", "banana", "plum"};

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + uniqueWords);

        System.out.println("Количество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
