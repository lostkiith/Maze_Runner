import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Set<String> knownWords = new HashSet<>();
        Set<String> words = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int wordCount = sc.nextInt();
        for (int i = 0; i < wordCount; i++){
           knownWords.add(sc.next().toLowerCase(Locale.ROOT));
        }
        int listCount = sc.nextInt();
        for (int k = 0; k < listCount; k++){
            words.add(sc.next().toLowerCase());
            words.addAll(List.of(sc.nextLine().toLowerCase().split(" ")));
        }
        words.removeAll(knownWords);
        words.forEach(System.out::println);
    }
}