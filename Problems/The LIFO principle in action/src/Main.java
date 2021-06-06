import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>(Integer.parseInt(sc.next()));
        while (sc.hasNext()){
            stack.addFirst(Integer.parseInt(sc.next()));
        }
        stack.forEach(System.out::println);
    }

}