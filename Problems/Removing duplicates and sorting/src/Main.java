import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Set<String> sorted = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
         while (sc.hasNext()){
             sorted.add(sc.next());
         }
        sorted.forEach(System.out::println);
    }
}